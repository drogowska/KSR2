package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SummarizerList {

    private List<Summarizer> summarizers;

    public SummarizerList(List<Summarizer> summarizers) {
        this.summarizers = summarizers;
    }

    public float calculate(CustomRecord record) {
        AtomicReference<Float> result = new AtomicReference<Float>(
                summarizers.get(0).getMembershipFunction().calculate(
                        AttributeEnum.getValue(record, summarizers.get(0).getColumnName()))
        );
        for(int i=1; i<summarizers.size(); i++) {
            float newValue = summarizers.get(i).getMembershipFunction().calculate(
                    AttributeEnum.getValue(record, summarizers.get(i).getColumnName()));
            if(summarizers.get(i).getConnective().equals(ConnectiveEnum.AND)) {
                result.set(Math.min(result.get(), newValue));
            } else if(summarizers.get(i).getConnective().equals(ConnectiveEnum.OR)) {
                result.set(Math.max(result.get(), newValue));
            }
        }
        return result.get(); 
    }

    public String toString() {
        if(summarizers != null && summarizers.size() > 0) {
            StringBuilder result = new StringBuilder(summarizers.get(0).getColumnName() + " equals " + summarizers.get(0).getLabel());
            for(int i=1; i<summarizers.size(); i++) {
                if(summarizers.get(i).getConnective().equals(ConnectiveEnum.AND)) {
                    result.append(" and ");
                } else if(summarizers.get(i).getConnective().equals(ConnectiveEnum.OR)) {
                    result.append(" or ");
                }
                result.append(summarizers.get(i).getColumnName() + " equals " + summarizers.get(i).getLabel());
            }
            return result.toString();
        } else {
            return "";
        }
    }

    public float getDegreeOfImprecision(List<CustomRecord> records) {
        AtomicReference<Float> result = new AtomicReference<>(1f);
        float p = summarizers.size();
        summarizers.forEach(summarizer -> {
            result.set(result.get() * summarizer.getDegreeOfFuzziness(records, summarizer.getColumnName()));
        });
        result.set((float) Math.pow(result.get(), 1/p));
        return 1f - result.get();
    }

    public float getDegreeOfAppropriateness(List<CustomRecord> records, float t3) {
        AtomicReference<Float> result = new AtomicReference<>(1f);
        summarizers.forEach(summarizer -> {
            long suppCount = records.stream().filter(r -> summarizer.getMembershipFunction()
                    .calculate(AttributeEnum.getValue(r, summarizer.getColumnName())) > 0).count();
            result.set(result.get() * ((float)suppCount / records.size()));
        });
        return Math.abs(result.get() - t3);
    }

    public float getLengthOfSummary() {
        return (float) (2d * Math.pow(0.5, summarizers.size()));
    }

    public float getDegreeOfSummarizerRelativeCardinality(int recordsSize) {
        AtomicReference<Float> result = new AtomicReference<>(1f);
        float p = summarizers.size();
        summarizers.forEach(summarizer -> {
            result.set(result.get() * (summarizer.getMembershipFunction().getCardinality() / recordsSize));
        });
        result.set((float) Math.pow(result.get(), 1/p));
        return 1f - result.get();
    }
}
