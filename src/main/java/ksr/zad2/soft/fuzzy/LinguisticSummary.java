package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LinguisticSummary {

    Quantifier quantifier;
    QualifierList qualifierList;
    SummarizerList summarizerList;
    List<CustomRecord> firstSubject;
    List<CustomRecord> secondSubject;

    public LinguisticSummary(Quantifier quantifier, List<Qualifier> qualifiers, List<Summarizer> summarizers, List<CustomRecord> firstSubject, List<CustomRecord> secondSubject) {
        if(qualifiers != null) {
            this.qualifierList = new QualifierList(qualifiers);
        }
        this.quantifier = quantifier;
        this.summarizerList = new SummarizerList(summarizers);
        this.firstSubject = firstSubject;
        this.secondSubject = secondSubject;
    }

    public List<String> getTstr() {
        DecimalFormat df = new DecimalFormat("#.###");
        List<Float> res = List.of(
                getT1(),
                getT2(),
                getT3(),
                getT4(),
                getT5(),
                getT6(),
                getT7(),
                getT8(),
                getT9(),
                getT10(),
                getT11());
        List<String> str = new ArrayList<>();
        res.forEach(f -> str.add(df.format(f)));
        return str;
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
                getT8(),
                getT9(),
                getT10(),
                getT11());
    }

    public float getOptimal(List<Float> wages) {
        float res = 0;
        for (int i = 0; i < wages.size(); i++)
            res += wages.get(i) * getT().get(i);
        return res;
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
                    float qualifierValue = qualifierList.calculate(record);
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
                if(qualifierList.calculate(record) > 0) {
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
        if(secondSubject == null) {
            return 1 - (quantifier.getMembershipFunction().getSupport() / firstSubject.size());
        } else {
            return 0;
        }
    }

    public float getT7() {
        if(secondSubject == null) {
            return 1 - (quantifier.getMembershipFunction().getCardinality() / firstSubject.size());
        } else {
            return 0;
        }
    }

    public float getT8() {
        if(secondSubject == null) {
            return summarizerList.getDegreeOfSummarizerRelativeCardinality(firstSubject.size());
        } else {
            return 0;
        }
    }

    public float getT9() {
        if(secondSubject == null && qualifierList != null) {
            return 1 - ((float)firstSubject.stream().filter(record -> qualifierList.calculate(record) > 0)
                    .count() / (float)firstSubject.size());
        } else {
            return 0;
        }
    }

    public float getT10() {
        if(secondSubject == null && qualifierList != null) {
            return qualifierList.getDegreeOfQualifierRelativeCardinality(firstSubject.size());
        } else {
            return 0;
        }
    }

    public float getT11() {
        if(secondSubject == null && qualifierList != null) {
            return qualifierList.getLengthOfQualification();
        } else {
            return 0;
        }
    }

    public int getForm() {
        if(qualifierList == null) {
            return 1;
        }
        if(qualifierList != null) {
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
                        firstSubject.get(0).getName() + " having " +
                        qualifierList.toString() + " are/have " +
                        summarizerList.toString();
            }
        } else { // TWO SUBJECTS

        }
        return result;
    }
}
