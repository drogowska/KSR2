package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.defined.DefinedLinguisticVariables;
import ksr.zad2.soft.gui.MainController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LinguisticSummary {

    private Quantifier quantifier;
    private QualifierList qualifierList;
    private  SummarizerList summarizerList;
    private List<CustomRecord> firstSubject;
    private List<CustomRecord> secondSubject;
    private boolean isThirdFormInMultiSubject;
    private List<Float> wages;
    private MainController.FormEnum form;

    public LinguisticSummary(MainController.FormEnum form, Quantifier quantifier, List<Qualifier> qualifiers, List<Summarizer> summarizers, List<CustomRecord> firstSubject, List<CustomRecord> secondSubject,
                             boolean isThirdFormInMultiSubject, List<Float> wages) {
        if(qualifiers != null) {
            this.qualifierList = new QualifierList(qualifiers);
        }
        this.form = form;
        this.quantifier = quantifier;
        this.wages = wages;
        this.summarizerList = new SummarizerList(summarizers);
        this.firstSubject = firstSubject;
        this.secondSubject = secondSubject;
        this.isThirdFormInMultiSubject = isThirdFormInMultiSubject;
    }

    public LinguisticSummary(Quantifier quantifier, List<Qualifier> qualifiers, List<Summarizer> summarizers, List<CustomRecord> firstSubject, List<CustomRecord> secondSubject,
                             boolean isThirdFormInMultiSubject, List<Float> wages) {
        if(qualifiers != null) {
            this.qualifierList = new QualifierList(qualifiers);
        }
        this.quantifier = quantifier;
        this.wages = wages;
        this.summarizerList = new SummarizerList(summarizers);
        this.firstSubject = firstSubject;
        this.secondSubject = secondSubject;
        this.isThirdFormInMultiSubject = isThirdFormInMultiSubject;
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
        float sum = 0;
        for (int i = 0; i < wages.size(); i++) {
            res += wages.get(i) * getT().get(i);
            sum += wages.get(i);
        }
        return res / sum;
    }

    public float getOptimal() {
        float res = 0;
        float sum = 0;
        for (int i = 0; i < wages.size(); i++) {
            sum += wages.get(i);
            res += wages.get(i) * getT().get(i);
        }
        return res / sum;
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
                result = quantifier.getMembershipFunction().calculate((firstSubject.size() * sum.get()) / sumQualifier.get());
            }
        }
        else { // TWO SUBJECTS
            AtomicReference<Float> firstSubjectSigmaCount = new AtomicReference<>(0f);
            AtomicReference<Float> secondSubjectSigmaCount = new AtomicReference<>(0f);
            if(getForm() == 1) {
                firstSubject.forEach(record -> firstSubjectSigmaCount.set(firstSubjectSigmaCount.get() + summarizerList.calculate(record)));
                secondSubject.forEach(record -> secondSubjectSigmaCount.set(secondSubjectSigmaCount.get() + summarizerList.calculate(record)));
            }
            else if(getForm() == 2) {
                firstSubject.forEach(record -> firstSubjectSigmaCount.set(firstSubjectSigmaCount.get() + summarizerList.calculate(record)));
                secondSubject.forEach(record -> secondSubjectSigmaCount.set(secondSubjectSigmaCount.get() +
                        Math.min(summarizerList.calculate(record), qualifierList.calculate(record))));
            } else if(getForm() == 3) {
                firstSubject.forEach(record -> firstSubjectSigmaCount.set(firstSubjectSigmaCount.get() +
                        Math.min(summarizerList.calculate(record), qualifierList.calculate(record))));
                secondSubject.forEach(record -> secondSubjectSigmaCount.set(secondSubjectSigmaCount.get() + summarizerList.calculate(record)));
            }
            if(getForm() != 4) {
                result = quantifier.getMembershipFunction().calculate(((firstSubjectSigmaCount.get() / firstSubject.size())
                        / ((firstSubjectSigmaCount.get() / firstSubject.size()) + (secondSubjectSigmaCount.get() / secondSubject.size())))
                        * DefinedLinguisticVariables.database_size);
            } else {
                firstSubject.forEach(record -> firstSubjectSigmaCount.set(firstSubjectSigmaCount.get() + summarizerList.calculate(record)));
                secondSubject.forEach(record -> secondSubjectSigmaCount.set(secondSubjectSigmaCount.get() + summarizerList.calculate(record)));
                result = 1 - KleeneDienesImplication(firstSubjectSigmaCount.get() / firstSubject.size(), secondSubjectSigmaCount.get() / secondSubject.size());
            }

        }
        return result;
    }

    private float KleeneDienesImplication(float x, float y) {
        return Math.max(1 - x, y);
    }

    public float getT2() {
        if(secondSubject == null) {
            return summarizerList.getDegreeOfImprecision(firstSubject);
        } else {
            return 0;
        }
    }

    public float getT3() {
        if(secondSubject == null) {
            if(qualifierList == null) {
                qualifierList = DefinedLinguisticVariables.stableQualifierList;
            }
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
            if(qualifierList == DefinedLinguisticVariables.stableQualifierList) {
                qualifierList = null;
            }
            return t.get() / h.get();
        } else {
            return 0;
        }
    }

    public float getT4() {
        if(secondSubject == null) {
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
            return qualifierList.getDegreeOfImprecision(firstSubject);
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
        if(secondSubject == null) {
            if(qualifierList == null) {
                return 1;
            }
            return qualifierList.getLengthOfQualification();
        } else {
            return 0;
        }
    }

    public int getForm() {
        if(form == null) {
            if(secondSubject == null) {
                if(qualifierList == null) {
                    return 1;
                }
                if(qualifierList != null) {
                    return 2;
                }
            } else {
                if(qualifierList == null && quantifier != null) {
                    return 1;
                }
                if(qualifierList != null && !isThirdFormInMultiSubject) {
                    return 2;
                }
                if(qualifierList != null && isThirdFormInMultiSubject) {
                    return 3;
                }
                if(qualifierList == null && quantifier == null) {
                    return 4;
                }
            }
        } else {
            switch(form) {
                case Jednopodmiotowe_forma_1:
                    secondSubject = null;
                    return 1;
                case Jednopodmiotowe_forma_2:
                    secondSubject = null;
                    return 2;
                case Wielopodmiotowe_forma_1:
                    return 1;
                case Wielopodmiotowe_forma_2:
                    return 2;
                case Wielopodmiotowe_forma_3:
                    return 3;
                case Wielopodmiotowe_forma_4:
                    return 4;
            }
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
            if(getForm() == 1) {
                result = quantifier.getQuantifierName() + " " +
                        firstSubject.get(0).getName() + " compared to " +
                        secondSubject.get(0).getName() + " are/have " +
                        summarizerList.toString();
            }
            else if(getForm() == 2) {
                result = quantifier.getQuantifierName() + " " +
                        firstSubject.get(0).getName() + " compared to " +
                        secondSubject.get(0).getName() +  " having " +
                        qualifierList.toString() + " are/have " +
                        summarizerList.toString();
            }
            else if(getForm() == 3) {
                result = quantifier.getQuantifierName() + " " +
                        firstSubject.get(0).getName() + " having " +
                        qualifierList.toString() + " compared to " +
                        secondSubject.get(0).getName() + " are/have " +
                        summarizerList.toString();
            }
            else if(getForm() == 4) {
                result = "More " +
                        firstSubject.get(0).getName() + " than " +
                        secondSubject.get(0).getName() + " are/have " +
                        summarizerList.toString();
            }
        }
        return result;
    }
}
