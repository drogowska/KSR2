package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SummarizerList {

    private List<Summarizer> summarizers;

    SummarizerList(List<Summarizer> summarizers) {
        this.summarizers = summarizers;
    }

    public float calculate(CustomRecord record) {
        AtomicReference<Float> result = new AtomicReference<Float>(
                summarizers.get(0).getMembershipFunction().calculate(
                        AttributeEnum.getValue(record, summarizers.get(0).getColumnName()))
        );
        for(int i=1; i<summarizers.size(); i++) {
            float newValue = summarizers.get(i).getMembershipFunction().calculate(
                    AttributeEnum.getValue(record, summarizers.get(0).getColumnName()));
            if(summarizers.get(i).getConnective().equals(ConnectiveEnum.AND)) {
                result.set(Math.min(result.get(), newValue));
            } else if(summarizers.get(i).getConnective().equals(ConnectiveEnum.OR)) {
                result.set(Math.max(result.get(), newValue));
            }
        }
        return result.get();
    }

    public String toString() {
        StringBuilder result = new StringBuilder(summarizers.get(0).getColumnName() + " equals " + summarizers.get(0).getLabel());
        for(int i=1; i<summarizers.size(); i++) {
            if(summarizers.get(i).getConnective().equals(ConnectiveEnum.AND)) {
                result.append(" and ");
            } else if(summarizers.get(i).getConnective().equals(ConnectiveEnum.OR)) {
                result.append(" and ");
            }
            result.append(summarizers.get(i).getColumnName() + " equals " + summarizers.get(i).getLabel());
        }
        return result.toString();
    }
}
