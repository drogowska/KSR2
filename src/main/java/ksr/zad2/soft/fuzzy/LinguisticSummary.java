package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LinguisticSummary {

    Quantifier quantifier;
    Qualifier qualifier;
    List<Summarizer> summarizers;
    List<CustomRecord> firstSubject;
    List<CustomRecord> secondSubject;

    public LinguisticSummary(Quantifier quantifier, Qualifier qualifier, List<Summarizer> summarizers, List<CustomRecord> firstSubject) {
        this.qualifier = qualifier;
        this.quantifier = quantifier;
        this.summarizers = summarizers;
        this.firstSubject = firstSubject;
    }

    public float getT1() {
        float result = 0;
        if(secondSubject == null) { // ONE SUBJECT
            if(getForm() == 1) {
                AtomicReference<Float> sum = new AtomicReference<>(0f);
                firstSubject.forEach(record -> {
                    sum.set(sum.get() + summarizers.get(0).getMembershipFunction().calculate(
                            AttributeEnum.getValue(record, summarizers.get(0).getColumnName())));
                });
                result = quantifier.getMembershipFunction().calculate(sum.get());
            }
            else if(getForm() == 2) {
                AtomicReference<Float> sum = new AtomicReference<>(0f);
                AtomicReference<Float> sumQualifier = new AtomicReference<>(0f);
                firstSubject.forEach(record -> {
                    float summarizerValue = summarizers.get(0).getMembershipFunction().calculate(AttributeEnum.getValue(record, summarizers.get(0).getColumnName()));
                    float qualifierValue = qualifier.getMembershipFunction().calculate(AttributeEnum.getValue(record, qualifier.getColumnName()));
                    sum.set(sum.get() + Math.min(summarizerValue, qualifierValue));
                    sumQualifier.set(sumQualifier.get() + qualifierValue);
                });
                result = quantifier.getMembershipFunction().calculate(sum.get() / sumQualifier.get());
            }
        }
        else { // TWO SUBJECTS

        }
        return result;
    }

    public int getForm() {
        if(summarizers.size() == 1 && qualifier == null) {
            return 1;
        }
        if(summarizers.size() == 1 && qualifier != null) {
            return 2;
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "";
        if(secondSubject == null) { // ONE SUBJECT
            if(getForm() == 1) {
                result = quantifier.getQuantifierName() + " " +
                        firstSubject.get(0).getName() + " are/have " +
                        summarizers.get(0).getColumnName() + " equals " +
                        summarizers.get(0).getLabel();
            }
            else if(getForm() == 2) {
                result = quantifier.getQuantifierName() + " " +
                        firstSubject.get(0).getName() + " are/have " +
                        qualifier.getColumnName() + " equals " +
                        qualifier.getLabel() + " are/have " +
                        summarizers.get(0).getColumnName() + " equals " +
                        summarizers.get(0).getLabel();
            }
        } else { // TWO SUBJECTS

        }
        return result;
    }
}
