package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class QualifierList {

    private List<Qualifier> qualifiers;

    public QualifierList(List<Qualifier> qualifiers) {
        this.qualifiers = qualifiers;
    }

    public float calculate(CustomRecord record) {
        AtomicReference<Float> result = new AtomicReference<Float>(
                qualifiers.get(0).getMembershipFunction().calculate(
                        AttributeEnum.getValue(record, qualifiers.get(0).getColumnName()))
        );
        for(int i=1; i<qualifiers.size(); i++) {
            float newValue = qualifiers.get(i).getMembershipFunction().calculate(
                    AttributeEnum.getValue(record, qualifiers.get(i).getColumnName()));
            if(qualifiers.get(i).getConnective().equals(ConnectiveEnum.AND)) {
                result.set(Math.min(result.get(), newValue));
            } else if(qualifiers.get(i).getConnective().equals(ConnectiveEnum.OR)) {
                result.set(Math.max(result.get(), newValue));
            }
        }
        return result.get();
    }

    public String toString() {
        if(qualifiers != null && qualifiers.size() > 0) {
            StringBuilder result = new StringBuilder(qualifiers.get(0).getColumnName() + " equals " + qualifiers.get(0).getLabel());
            for(int i=1; i<qualifiers.size(); i++) {
                if(qualifiers.get(i).getConnective().equals(ConnectiveEnum.AND)) {
                    result.append(" and ");
                } else if(qualifiers.get(i).getConnective().equals(ConnectiveEnum.OR)) {
                    result.append(" or ");
                }
                result.append(qualifiers.get(i).getColumnName() + " equals " + qualifiers.get(i).getLabel());
            }
            return result.toString();
        } else {
            return "";
        }
    }

    public float getLengthOfQualification() {
        return (float) (2d * Math.pow(0.5, qualifiers.size()));
    }

    public float getDegreeOfQualifierRelativeCardinality(List<CustomRecord> records) {
        AtomicReference<Float> result = new AtomicReference<>(1f);
        float p = qualifiers.size();
        qualifiers.forEach(qualifier -> {
            AtomicReference<Float> sum = new AtomicReference<>(0f);
            records.forEach(r -> sum.set(sum.get() + qualifier.getMembershipFunction().calculate(AttributeEnum.getValue(r, qualifier.getColumnName()))));
            result.set(result.get() * (sum.get() / (float)records.size()));
        });
        result.set((float) Math.pow(result.get(), 1/p));
        return 1f - result.get();
    }

    public float getDegreeOfImprecision() {
        AtomicReference<Float> result = new AtomicReference<>(1f);
        float p = qualifiers.size();
        qualifiers.forEach(qualifier -> {
            result.set(result.get() * qualifier.getDegreeOfFuzziness());
        });
        result.set((float) Math.pow(result.get(), 1/p));
        return 1f - result.get();
    }
}
