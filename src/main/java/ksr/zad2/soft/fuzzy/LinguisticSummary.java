package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.CustomRecord;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LinguisticSummary {

    Quantifier quantifier;
    List<Summarizer> summarizers;

    List<CustomRecord> firstSubject;
    List<CustomRecord> secondSubject;

    public LinguisticSummary(Quantifier quantifier, List<Summarizer> summarizers, List<CustomRecord> firstSubject) {
        this.quantifier = quantifier;
        this.summarizers = summarizers;
        this.firstSubject = firstSubject;
    }

    public double getT1() {
        double result = 0;
        if(secondSubject == null) {
            if(getForm() == 1) {
                AtomicReference<Double> sum = new AtomicReference<>(0d);
                firstSubject.forEach(record -> {
                    sum.set(sum.get() + summarizers.get(0).getMembershipFunction().calculate(record.getAge())); // age
                });
                result = quantifier.getMembershipFunction().calculate(sum.get());
            }
        } else {

        }
        return result;
    }

    public int getForm() {
        return 1;
    }

    @Override
    public String toString() {
        String result = "";
        if(secondSubject == null) {
            if(getForm() == 1) {
                result = quantifier.getQuantifierName() + " " +
                        firstSubject.get(0).getName() + " are/have " +
                        summarizers.get(0).getColumnName() + " equals " +
                        summarizers.get(0).getLabel();
            }
        } else {

        }
        return result;
    }
}
