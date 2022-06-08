package ksr.zad2.soft;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.defined.DefinedLinguisticVariables;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.TrapezoidalMembershipFunction;
import ksr.zad2.soft.fuzzy.*;
import ksr.zad2.soft.set.FuzzySet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static ksr.zad2.soft.defined.DefinedLinguisticVariables.*;

@SpringBootTest
@EnableAutoConfiguration
class SoftApplicationTests {

    @Autowired
    private SpeedDatingRepository repository;

    private static MembershipFunction quantifierFunction;
    private static Quantifier q;
    private static MembershipFunction summarizerFunction;
    private static MembershipFunction qualifierFunction;
    private static Label label1;
    private static Label label2;
    private static Summarizer summarizer;
    private static List<CustomRecord> subject1;
    private static List<CustomRecord> subject2;
    private static Qualifier qualifier;
    private static Qualifier qualifier1;
//    private static Qualifier qualifier;

    @BeforeAll
    static void setup() {
        quantifierFunction = new TrapezoidalMembershipFunction(100, 4600, 10000, 7000);
        q = new Quantifier("Most of", quantifierFunction, true);

        qualifierFunction = new TrapezoidalMembershipFunction(1, 4, 5, 6);
        label2 = new Label("a bit boring", new FuzzySet(qualifierFunction));
        qualifier = new Qualifier(label2, AttributeEnum.valueOf("funny"), ConnectiveEnum.AND);
        qualifier1 = new Qualifier(d_age.getLabel(1), AttributeEnum.valueOf("d_age"), ConnectiveEnum.AND);

        summarizerFunction = new TrapezoidalMembershipFunction(28, 34, 40, 44);
        label1 = new Label("young", new FuzzySet(summarizerFunction));
        summarizer = new Summarizer(label1, AttributeEnum.valueOf("age"), ConnectiveEnum.AND);
    }

    @Test
    void realTest() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        Quantifier quantifier = quantifiers.get(2);

        LinguisticSummary summary = new LinguisticSummary(quantifier, null, List.of(
                new Summarizer(expected_num_interested_in_me.getLabel(2), expected_num_interested_in_me.getColumn(), ConnectiveEnum.AND)
        ), subject1, null, false);

        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
        summary.getT().forEach(System.out::println);
    }

    @Test
    void realTest2() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        Quantifier quantifier = quantifiers.get(4);

        LinguisticSummary summary = new LinguisticSummary(quantifier, null, List.of(
                new Summarizer(age.getLabel(1), age.getColumn(), ConnectiveEnum.AND)
        ), subject1, null, false);

        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
        summary.getT().forEach(System.out::println);
    }

    @Test
    void realTest3() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        Quantifier quantifier = quantifiers.get(10);

        LinguisticSummary summary = new LinguisticSummary(quantifier, null, List.of(
                new Summarizer(age.getLabel(0), age.getColumn(), ConnectiveEnum.AND)
        ), subject1, null, false);

        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
        summary.getT().forEach(System.out::println);
    }


    @Test
    void testForm1() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());


        LinguisticSummary summary = new LinguisticSummary(q, null, List.of(summarizer, summarizer, summarizer), subject1, null, false);
        System.out.println(summary.toString() + " [" + summary.getT1() + "]");

        summary.getT().forEach(System.out::println);
    }

    @Test
    void t() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        List<LinguisticVariable> variables = List.of(sincere, age, d_age, expected_num_interested_in_me, tvsports, pref_o_intelligence, pref_o_ambitious, importance_same_race, importance_same_religion, guess_prob_liked, funny);
        Quantifier quantifier = quantifiers.get(9);

        variables.forEach(v1 -> {
            variables.forEach(v2 -> {
                variables.forEach(v3 -> {
                    v3.getLabels().forEach(l3 -> {
                        v1.getLabels().forEach(labelS -> {
                            v2.getLabels().forEach(labelQ -> {
                                LinguisticSummary summary = new LinguisticSummary(quantifier, List.of(
                                        new Qualifier(labelQ, v2.getColumn(), ConnectiveEnum.AND)
                                ), List.of(
                                        new Summarizer(labelS, v1.getColumn(), ConnectiveEnum.AND),
                                        new Summarizer(l3, v3.getColumn(), ConnectiveEnum.AND)
                                ), subject1, null, false);

                                System.out.print(summary.toString() + " ");
                                List<Float> wages = List.of(0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f);
                                summary.getTstr().forEach(t -> System.out.print(t + " "));
                                System.out.println(summary.getOptimal(wages));
                            });
                        });
                    });
                });
            });
        });

    }

    @Test
    void testForm2() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(q, List.of(qualifier), List.of(summarizer), subject1, null, false);
        System.out.println(summary.toString() + " [" + summary.getT1() + "]");

        summary.getT().forEach(System.out::println);
    }


    @Test
    void test1() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("people");
            return customRecord;
        }).collect(Collectors.toList());
        d_age.getLabels().forEach( s-> {
            summarizer = new Summarizer(s, AttributeEnum.valueOf("age"), ConnectiveEnum.AND);
            quantifiers.forEach(q -> {
                LinguisticSummary summary = new LinguisticSummary(q, null, List.of(summarizer), subject1, null, false);
                System.out.println(summary.toString() + " [" + summary.getT1() + "]");
                List<String> m = summary.getTstr();
                for (String f : m) {
                    System.out.print(f + " & ");
                }
                List<Float> wages = List.of(0.16f, 0.16f, 0f, 0f, 0.16f, 0.16f, 0.16f, 0.16f, 0.0f, 0.0f, 0.0f);
                System.out.println(summary.getOptimal(wages));
                System.out.println("");
            });
        });

        List<Float> wages = List.of(0.091f,0.091f, 0.091f, 0.091f, 0.091f, 0.091f, 0.091f ,0.091f, 0.091f,0.091f,0.091f);
    }

    @Test
    public void MultiSubject1Form() {
        subject1 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("female"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Females");
                    return customRecord;
                }).collect(Collectors.toList());

        subject2 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("male"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Males");
                    return customRecord;
                }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(
                quantifiers.get(4),
                null,
                List.of(new Summarizer(age.getLabel("teenager"), age.getColumn(), ConnectiveEnum.AND)),
                subject1,
                subject2,
                false
        );

        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
    }

    @Test
    public void MultiSubject2Form() {
        subject1 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("female"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Females");
                    return customRecord;
                }).collect(Collectors.toList());

        subject2 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("male"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Males");
                    return customRecord;
                }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(
                quantifiers.get(4),
                List.of(new Qualifier(funny.getLabel("entertaining"), funny.getColumn(), ConnectiveEnum.AND)),
                List.of(new Summarizer(age.getLabel("teenager"), age.getColumn(), ConnectiveEnum.AND)),
                subject1,
                subject2,
                false
        );

        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
    }

    @Test
    public void MultiSubject3Form() {
        subject1 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("female"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Females");
                    return customRecord;
                }).collect(Collectors.toList());

        subject2 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("male"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Males");
                    return customRecord;
                }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(
                quantifiers.get(4),
                List.of(new Qualifier(funny.getLabel("entertaining"), funny.getColumn(), ConnectiveEnum.AND)),
                List.of(new Summarizer(age.getLabel("teenager"), age.getColumn(), ConnectiveEnum.AND)),
                subject1,
                subject2,
                true
        );

        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
    }

    @Test
    public void MultiSubject4Form() {
        subject1 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("female"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Females");
                    return customRecord;
                }).collect(Collectors.toList());

        subject2 = repository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("male"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Males");
                    return customRecord;
                }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(
                null,
                null,
                List.of(new Summarizer(age.getLabel("teenager"), age.getColumn(), ConnectiveEnum.AND)),
                subject2,
                subject1,
                false
        );

        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
    }
}
