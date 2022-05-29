package fuzzy;

import functions.*;
import quantifier.FuzzyQuantifier;

import java.util.List;

public class Defined {

    public static List<FuzzyQuantifier> quantifier = List.of
            (new FuzzyQuantifier("Almost none of", new TrapezoidalMembershipFunction(0, 0, 50, 100), false),
                    new FuzzyQuantifier("Some of", new TrapezoidalMembershipFunction(0, 200, 1500, 1700), false),
                    new FuzzyQuantifier("Approximately 1/3 of", new GaussMembershipFunction(2700.0, 800.0, new UniverseOfDiscourse(1000.0, 5000.0, 1.0)), false),
                    new FuzzyQuantifier("Around half of", new TriangleMembershipFunction(3789, 4189, 4589), false),
                    new FuzzyQuantifier("Most of", new TrapezoidalMembershipFunction(4100, 4600, 8378.0, 8378.0), false),
                    new FuzzyQuantifier("The vast majority of", new TrapezoidalMembershipFunction(7300, 8300, 8378, 8378.0), false),
                            new FuzzyQuantifier("Around 8000", new TrapezoidalMembershipFunction(5500.0, 8000, 8400, 8400), true),
                            new FuzzyQuantifier("More than 5000", new GaussMembershipFunction(5000.0, 1000.0, new UniverseOfDiscourse(2800.0, 6900.0, 1)), true),
                            new FuzzyQuantifier("Approximately 3000", new TrapezoidalMembershipFunction(1600, 2600,4000,5000), true),
                            new FuzzyQuantifier("More than 1000", new GaussMembershipFunction(1500, 500, new UniverseOfDiscourse(300.0, 2700, 1)), true),
                            new FuzzyQuantifier("Less than 1000", new TrapezoidalMembershipFunction(0, 0, 600, 1000), true)
                    );

    public static LinguisticVariable sincere = new LinguisticVariable("sincere",
                    List.of(new Label("insincere", new GaussMembershipFunction(7.0, 2.0, new UniverseOfDiscourse(4, 11, 1))),
                            new Label("sincere", new TrapezoidalMembershipFunction(8, 11, 13, 13)),
                            new Label("duplicitous", new TrapezoidalMembershipFunction(0, 2, 2, 6))
                    ),
                    new UniverseOfDiscourse(0, 13, 1));

    public static LinguisticVariable funny = new LinguisticVariable("funny",
                                    List.of(new Label("boring", new TrapezoidalMembershipFunction(0,0,2,3)),
                                            new Label("a little bit boring", new TriangleMembershipFunction(1,4,6)),
                                            new Label("entertaining", new TrapezoidalMembershipFunction(9, 10, 13,13)),
                                            new Label("funny", new TrapezoidalMembershipFunction(5,6,7,10))),
                                    new UniverseOfDiscourse(0, 13, 1));

//    LinguisticVariable guess_prob_liked = new LinguisticVariable("guess_prob_liked",
//            List.of(new Label("none", new TrapezoidalMembershipFunction(0, 0, 1, 2)),
//                    new Label("some")),
//            new UniverseOfDiscourse(0, 13, 1));
//?

    public static LinguisticVariable age = new LinguisticVariable("age",
            List.of(new Label("teneageer", new TrapezoidalMembershipFunction(16,16,18, 20)),
                    new Label("young", new TrapezoidalMembershipFunction(17, 22, 28,30)),
                    new Label("in middle age", new TrapezoidalMembershipFunction(28,34,40,44)),
                    new Label("in the prime of age", new TrapezoidalMembershipFunction(40,45,49,50)),
                    new Label("old", new TrapezoidalMembershipFunction(45,50,65,65))),
            new UniverseOfDiscourse(16, 65, 1));

//    List<Summarizer> summarizers = new ArrayList<>();
//    {
//        this.summarizers.add();
//    }


}
