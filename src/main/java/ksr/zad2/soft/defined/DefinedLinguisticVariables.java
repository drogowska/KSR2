package ksr.zad2.soft.defined;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.functions.GaussMembershipFunction;
import ksr.zad2.soft.functions.TrapezoidalMembershipFunction;
import ksr.zad2.soft.functions.TriangularMembershipFunction;
import ksr.zad2.soft.fuzzy.Label;
import ksr.zad2.soft.fuzzy.LinguisticVariable;
import ksr.zad2.soft.fuzzy.Quantifier;
import ksr.zad2.soft.set.FuzzySet;

import java.util.List;

public class DefinedLinguisticVariables {

    // 8378 values in database
    public static final int database_size = 8378;

    public static final List<Quantifier> quantifiers = List.of(
            new Quantifier("Almost none of", new TrapezoidalMembershipFunction(0, 0, 0.006f, 0.012f), false),
            new Quantifier("Some of", new TrapezoidalMembershipFunction(0, 0.024f, 0.179f, 0.203f), false),
            new Quantifier("Approximately 1/3 of", new GaussMembershipFunction(0.322f, 0.095f), false),
            new Quantifier("Around half of", new TriangularMembershipFunction(0.452f, 0.5f, 0.548f), false),
            new Quantifier("Most of", new TrapezoidalMembershipFunction(0.489f, 0.549f, 1, 1), false),
            new Quantifier("The vast majority of", new TrapezoidalMembershipFunction(0.871f, 0.991f, 1, 1), false),

            new Quantifier("Around 8000", new TrapezoidalMembershipFunction(5500, 8000, 8378, 8378), true),
            new Quantifier("More than 5000", new GaussMembershipFunction(5000, 1000), true),
            new Quantifier("Approximately 3000", new TrapezoidalMembershipFunction(1600, 2600, 4000, 5000), true),
            new Quantifier("More than 1000", new GaussMembershipFunction(1500, 500), true),
            new Quantifier("Less than 1000", new TrapezoidalMembershipFunction(0, 0, 600, 1000), true)
    );

    public static final LinguisticVariable sincere = new LinguisticVariable(AttributeEnum.sincere, List.of(
            new Label("duplicitous", new FuzzySet(new TrapezoidalMembershipFunction(0, 0, 2, 6))),
            new Label("insincere", new FuzzySet(new GaussMembershipFunction(7, 2))),
            new Label("sincere", new FuzzySet(new TrapezoidalMembershipFunction(8, 11, 13, 13)))
    ));

    public static final LinguisticVariable age = new LinguisticVariable(AttributeEnum.age, List.of(
            new Label("teenager", new FuzzySet(new TrapezoidalMembershipFunction(15, 16, 18, 20))),
            new Label("young", new FuzzySet(new TrapezoidalMembershipFunction(17, 22, 28, 30))),
            new Label("in middle age", new FuzzySet(new TrapezoidalMembershipFunction(28, 34, 40, 44))),
            new Label("in the prime of age", new FuzzySet(new TrapezoidalMembershipFunction(40, 45,49, 50))),
            new Label("old", new FuzzySet(new TrapezoidalMembershipFunction(45, 50, 65, 65)))
    ));

    public static final LinguisticVariable d_age = new LinguisticVariable(AttributeEnum.d_age, List.of(
            new Label("none", new FuzzySet(new TriangularMembershipFunction(0, 0, 1))),
            new Label("tiny", new FuzzySet(new TriangularMembershipFunction(1, 3, 5))),
            new Label("small", new FuzzySet(new TriangularMembershipFunction(3, 7, 10))),
            new Label("average", new FuzzySet(new TrapezoidalMembershipFunction(9, 17, 19, 23))),
            new Label("significant", new FuzzySet(new TrapezoidalMembershipFunction(15, 19, 22, 32))),
            new Label("huge", new FuzzySet(new TrapezoidalMembershipFunction(30, 35, 45, 45)))
    ));

    public static final LinguisticVariable funny = new LinguisticVariable(AttributeEnum.funny, List.of(
            new Label("boring", new FuzzySet(new TrapezoidalMembershipFunction(0, 0, 2, 3))),
            new Label("a little bit boring", new FuzzySet(new TriangularMembershipFunction(1, 4, 6))),
            new Label("entertaining", new FuzzySet(new TrapezoidalMembershipFunction(9, 10, 13, 13))),
            new Label("funny", new FuzzySet(new TrapezoidalMembershipFunction(5, 6, 7,10)))
    ));

    public static final LinguisticVariable expected_num_interested_in_me = new LinguisticVariable(AttributeEnum.expected_num_interested_in_me, List.of(
            new Label("none", new FuzzySet(new TrapezoidalMembershipFunction(0, 0, 1, 3))),
            new Label("few", new FuzzySet(new TrapezoidalMembershipFunction(1, 3, 4, 6))),
            new Label("not many", new FuzzySet(new TriangularMembershipFunction(4, 5, 7))),
            new Label("some", new FuzzySet(new TriangularMembershipFunction(6,7,8))),
            new Label("many", new FuzzySet(new TriangularMembershipFunction(8, 9, 10))),
            new Label("a lot", new FuzzySet(new TrapezoidalMembershipFunction(9, 11, 15, 15)))
    ));

    public static final LinguisticVariable tvsports = new LinguisticVariable(AttributeEnum.tvsports, List.of(
            new Label("not interested", new FuzzySet(new TrapezoidalMembershipFunction(0,0,2,5))),
            new Label("neutral", new FuzzySet(new TriangularMembershipFunction(2, 4, 7))),
            new Label("moderately interested", new FuzzySet(new TrapezoidalMembershipFunction(4, 6, 8, 9))),
            new Label("interested", new FuzzySet(new TriangularMembershipFunction(8, 9, 11))),
            new Label("passionate", new FuzzySet(new TrapezoidalMembershipFunction(9, 11, 12, 12)))
    ));

    public static final LinguisticVariable pref_o_intelligence = new LinguisticVariable(AttributeEnum.pref_o_intelligence, List.of(
            new Label("stupid", new FuzzySet(new TrapezoidalMembershipFunction(0, 0, 1, 3))),
            new Label("not very intelligent", new FuzzySet(new TrapezoidalMembershipFunction(2, 5, 12, 16))),
            new Label("average", new FuzzySet(new TrapezoidalMembershipFunction(14, 20, 30, 35))),
            new Label("intelligent", new FuzzySet(new TrapezoidalMembershipFunction(32, 44, 58, 64))),
            new Label("genius", new FuzzySet(new TrapezoidalMembershipFunction(57, 62, 67, 67)))
    ));

    public static final LinguisticVariable pref_o_ambitious = new LinguisticVariable(AttributeEnum.pref_o_ambitious, List.of(
            new Label("not ambitious", new FuzzySet(new GaussMembershipFunction(6,8))),
            new Label("moderately ambitious", new FuzzySet(new GaussMembershipFunction(30,12))),
            new Label("very ambitious", new FuzzySet(new GaussMembershipFunction(45, 5)))
    ));

    public static final LinguisticVariable importance_same_religion = new LinguisticVariable(AttributeEnum.importance_same_religion, List.of(
            new Label("none", new FuzzySet(new TriangularMembershipFunction(0, 0, 1))),
            new Label("tiny", new FuzzySet(new TriangularMembershipFunction(1, 2, 3))),
            new Label("small", new FuzzySet(new TrapezoidalMembershipFunction(2, 3, 4,5))),
            new Label("average", new FuzzySet(new TriangularMembershipFunction(4, 5, 6))),
            new Label("significant", new FuzzySet(new GaussMembershipFunction(6, 1))),
            new Label("huge", new FuzzySet(new GaussMembershipFunction(9, 1.5f)))
    ));

    public static final LinguisticVariable importance_same_race = new LinguisticVariable(AttributeEnum.importance_same_race, List.of(
            new Label("none", new FuzzySet(new TriangularMembershipFunction(0, 0, 1))),
            new Label("tiny", new FuzzySet(new TriangularMembershipFunction(1, 2, 3))),
            new Label("small", new FuzzySet(new TrapezoidalMembershipFunction(2, 3, 4,5))),
            new Label("average", new FuzzySet(new TriangularMembershipFunction(4, 5, 6))),
            new Label("significant", new FuzzySet(new GaussMembershipFunction(6, 1))),
            new Label("huge", new FuzzySet(new GaussMembershipFunction(9, 1.5f)))
    ));

    public static final LinguisticVariable guess_prob_liked = new LinguisticVariable(AttributeEnum.guess_prob_liked, List.of(
            new Label("none", new FuzzySet(new TrapezoidalMembershipFunction(0, 0, 1, 2))),
            new Label("tiny", new FuzzySet(new TriangularMembershipFunction(1, 3, 4))),
            new Label("small", new FuzzySet(new TriangularMembershipFunction(3, 5, 6))),
            new Label("significant", new FuzzySet(new TrapezoidalMembershipFunction(5, 8, 9, 10))),
            new Label("huge", new FuzzySet(new TrapezoidalMembershipFunction(9, 11, 12, 12)))
    ));
}
