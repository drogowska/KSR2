package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LinguisticSummary {

    Quantifier quantifier;
    Qualifier qualifier;
    SummarizerList summarizerList;
    List<CustomRecord> firstSubject;
    List<CustomRecord> secondSubject;

    public LinguisticSummary(Quantifier quantifier, Qualifier qualifier, List<Summarizer> summarizers, List<CustomRecord> firstSubject) {
        this.qualifier = qualifier;
        this.quantifier = quantifier;
        this.summarizerList = new SummarizerList(summarizers);
        this.firstSubject = firstSubject;
    }

    public List<Float> getT() {
        return List.of(
                getT1(),
                getT2(),
                getT3(),
                getT4(),
                getT5(),
                getT6(),
                getT7(),
                getT8());
    }

    public float getT1() {
        float result = 0;
        if(secondSubject == null) { // ONE SUBJECT
            if(getForm() == 1) {
                AtomicReference<Float> sum = new AtomicReference<>(0f);
                firstSubject.forEach(record -> {
                    sum.set(sum.get() + summarizerList.calculate(record));
                });
                result = quantifier.getMembershipFunction().calculate(sum.get());
            }
            else if(getForm() == 2) {
                AtomicReference<Float> sum = new AtomicReference<>(0f);
                AtomicReference<Float> sumQualifier = new AtomicReference<>(0f);
                firstSubject.forEach(record -> {
                    float summarizerValue = summarizerList.calculate(record);
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

    public float getT2() {
        if(secondSubject == null) {
            return summarizerList.getDegreeOfImprecision(firstSubject);
        } else {
            return 0;
        }
    }

    public float getT3() {
        if(getForm() == 2 && secondSubject == null) {
            AtomicReference<Float> h = new AtomicReference<>(0f);
            AtomicReference<Float> t = new AtomicReference<>(0f);
            firstSubject.forEach(record -> {
                if(qualifier.getMembershipFunction().calculate(AttributeEnum.getValue(record, qualifier.getColumnName())) > 0) {
                    h.set(h.get() + 1);
                    if(summarizerList.calculate(record) > 0) {
                        t.set(t.get() + 1);
                    }
                }
            });
            return t.get() / h.get();
        } else {
            return 0;
        }
    }

    public float getT4() {
        if(getForm() == 2 && secondSubject == null) {
            return summarizerList.getDegreeOfAppropriateness(firstSubject, getT3());
        } else {
            return 0;
        }
    }

    public float getT5() {
        if(secondSubject == null) {
            return summarizerList.getLengthOfSummary();
        } else {
            return 0;
        }
    }

    public float getT6() {
        return 1 - (quantifier.getMembershipFunction().getSupport() / firstSubject.size());
    }

    public float getT7() {
        return 1 - (quantifier.getMembershipFunction().getCardinality() / firstSubject.size());
    }

    public float getT8() {
        return summarizerList.getDegreeOfSummarizerRelativeCardinality(firstSubject.size());
    }


    public int getForm() {
        if(qualifier == null) {
            return 1;
        }
        if(qualifier != null) {
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
                        summarizerList.toString();
            }
            else if(getForm() == 2) {
                result = quantifier.getQuantifierName() + " " +
                        firstSubject.get(0).getName() + " are/have " +
                        qualifier.getColumnName() + " equals " +
                        qualifier.getLabel() + " are/have " +
                        summarizerList.toString();
            }
        } else { // TWO SUBJECTS

        }
        return result;
    }
}
