package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.functions.*;
import ksr.zad2.soft.set.ClassicSet;
import ksr.zad2.soft.set.FuzzySet;

import java.util.List;

import static ksr.zad2.soft.SoftApplication.cutDB;

public class Defined {

    public static List<FuzzyQuantifier> quantifier = List.of
            (new FuzzyQuantifier("Almost none of", new TrapezoidalMembershipFunction<Double>(x-> x, 0, 0, 50, 100), false),
                    new FuzzyQuantifier("Some of", new TrapezoidalMembershipFunction<Double>(x-> x,0, 200, 1500, 1700), false),
                    new FuzzyQuantifier("Approximately 1/3 of", new GaussMembershipFunction<Double>(x-> x,2700.0, 800.0, new ClassicSet<Integer>(1000, 5000)), false),
                    new FuzzyQuantifier("Around half of", new TriangleMembershipFunction<Double>(x-> x,3789, 4189, 4589), false),
                    new FuzzyQuantifier("Most of", new TrapezoidalMembershipFunction<Double>(x-> x,4100, 4600, 8378, 8378), false),
                    new FuzzyQuantifier("The vast majority of", new TrapezoidalMembershipFunction<Double>(x-> x,7300, 8300, 8378, 8378), false),
                            new FuzzyQuantifier("Around 8000", new TrapezoidalMembershipFunction<Double>(x-> x,5500, 8000, 8400, 8400), true),
                            new FuzzyQuantifier("More than 5000", new GaussMembershipFunction<Double>(x-> x,5000.0, 1000.0, new ClassicSet<Integer>(2800, 6900)), true),
                            new FuzzyQuantifier("Approximately 3000", new TrapezoidalMembershipFunction<Double>(x-> x,1600, 2600,4000,5000), true),
                            new FuzzyQuantifier("More than 1000", new GaussMembershipFunction<Double>(x-> x,1500, 500, new ClassicSet<Integer>(300, 2700)), true),
                            new FuzzyQuantifier("Less than 1000", new TrapezoidalMembershipFunction<Double>(x-> x,0, 0, 600, 1000), true)
                    );

//    public static LinguisticVariable sincere = new LinguisticVariable("sincere",
//                    List.of(new Label("insincere", new GaussMembershipFunction(7.0, 2.0, new UniverseOfDiscourse({}))),
//                            new Label("sincere", new TrapezoidalMembershipFunction(8, 11, 13, 13)),
//                            new Label("duplicitous", new TrapezoidalMembershipFunction(0, 2, 2, 6))
//                    ),
//                    new UniverseOfDiscourse<Integer>(0, 13));
//
//    public static LinguisticVariable funny = new LinguisticVariable("funny",
//                                    List.of(new Label("boring", new TrapezoidalMembershipFunction(0,0,2,3)),
//                                            new Label("a little bit boring", new TriangleMembershipFunction(1,4,6)),
//                                            new Label("entertaining", new TrapezoidalMembershipFunction(9, 10, 13,13)),
//                                            new Label("funny", new TrapezoidalMembershipFunction(5,6,7,10))),
//                                    new UniverseOfDiscourse<Integer>(0, 13));
//
//    public static LinguisticVariable guess_prob_liked = new LinguisticVariable("guess_prob_liked",
//            List.of(new Label("none", new TrapezoidalMembershipFunction(0, 0, 1, 2)),
//                    new Label("tiny", new TriangleMembershipFunction(1, 3, 4)),
//                    new Label("small", new TriangleMembershipFunction(3, 5, 6)),
//                    new Label("significant", new TrapezoidalMembershipFunction(5, 8, 9, 10)),
//                    new Label("huge", new TrapezoidalMembershipFunction(9, 11, 12, 12))),
//            new UniverseOfDiscourse<Integer>(0, 13));

    private static ClassicSet<Integer> ageUni = new ClassicSet(List.of(18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,42,55));
    public static LinguisticVariable age = new LinguisticVariable<CustomRecord>("age",
            List.of(new FuzzySet("teneageer", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 16,16,18, 20), cutDB),
                    new FuzzySet("young", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 17, 22, 28,30), ageUni),
                    new FuzzySet("in middle age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 28,34,40,44), ageUni),
                    new FuzzySet("in the prime of age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 40,45,49,50), ageUni),
                    new FuzzySet("old", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 45,50,65,65), ageUni)),ageUni);

    private static ClassicSet dageUni = new ClassicSet(List.of(18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,42,55));

    public static LinguisticVariable d_age = new LinguisticVariable("d_age",
            List.of(new FuzzySet("none difference in age", new TriangleMembershipFunction<CustomRecord>(Extractor::d_age,0,0,1), dageUni),
                    new FuzzySet("tiny difference in age", new TriangleMembershipFunction<CustomRecord>(Extractor::d_age,1, 3, 5), dageUni),
                    new FuzzySet("small difference in age", new TriangleMembershipFunction<CustomRecord>(Extractor::d_age,3,7,10), dageUni),
                    new FuzzySet("average difference in age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::d_age,9,17,19,23),dageUni),
                    new FuzzySet("significant difference in age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::d_age,15,19,22,32),dageUni),
                    new FuzzySet("huge difference in age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::d_age,30,35,45,45),dageUni)),dageUni);

//    public static LinguisticVariable importance_same_race = new LinguisticVariable("importance_same_race",
//            List.of(new Label("none", new TriangleMembershipFunction(0,0,1)),
//                    new Label("tiny", new TriangleMembershipFunction(1, 2, 3)),
//                    new Label("small", new TrapezoidalMembershipFunction(2, 3, 4, 5)),
//                    new Label("average", new TriangleMembershipFunction(4,5,6)),
//                    new Label("significant", new GaussMembershipFunction(6, 1, new UniverseOfDiscourse(0, 13, 1))),
//                    new Label("huge", new GaussMembershipFunction(9,1.5, new UniverseOfDiscourse(0, 13, 1)))),
//            new UniverseOfDiscourse(0, 13));
//
//    public static LinguisticVariable importance_same_religion = new LinguisticVariable("importance_same_religion",
//            List.of(new Label("none", new TriangleMembershipFunction(0,0,1)),
//                    new Label("tiny", new TriangleMembershipFunction(1, 2, 3)),
//                    new Label("small", new TrapezoidalMembershipFunction(2, 3, 4, 5)),
//                    new Label("average", new TriangleMembershipFunction(4,5,6)),
//                    new Label("significant", new GaussMembershipFunction(6, 1, new UniverseOfDiscourse(0, 13, 1))),
//                    new Label("huge", new GaussMembershipFunction(9,1.5, new UniverseOfDiscourse(0, 13, 1)))),
//            new UniverseOfDiscourse(0, 13, 1));
//
//    public static LinguisticVariable pref_o_ambitious = new LinguisticVariable("pref_o_ambitious",
//            List.of(new Label("not ambitious", new GaussMembershipFunction(6, 8, new UniverseOfDiscourse(0, 55, 1))),
//                    new Label("moderately ambitious'", new GaussMembershipFunction(30, 12, new UniverseOfDiscourse(0, 55, 1))),
//                    new Label("ambitious", new GaussMembershipFunction(45, 5, new UniverseOfDiscourse(0, 55, 1)))),
//            new UniverseOfDiscourse(0, 55, 1));
//
//    public static LinguisticVariable pref_o_intelligence = new LinguisticVariable("pref_o_intelligence",
//            List.of(new Label("stupid", new TrapezoidalMembershipFunction(0,0,1,3)),
//                    new Label("not very intelligent", new TrapezoidalMembershipFunction(2,5,12,16)),
//                    new Label("average", new TrapezoidalMembershipFunction(14, 20, 30, 35)),
//                    new Label("inteligent", new TrapezoidalMembershipFunction(32, 44, 58, 64)),
//                    new Label("genius", new TrapezoidalMembershipFunction(57, 62, 67, 67))),
//            new UniverseOfDiscourse(0, 68, 1));
//
//    public static LinguisticVariable tvsports = new LinguisticVariable("sports",
//            List.of(new Label("not interested", new TrapezoidalMembershipFunction(0, 0, 2, 5)),
//                    new Label("neutral", new TriangleMembershipFunction(2, 4, 7)),
//                    new Label("moderately interested", new TrapezoidalMembershipFunction(4, 6, 8, 9)),
//                    new Label("interested", new TriangleMembershipFunction(8, 9, 11)),
//                    new Label("passionate", new TrapezoidalMembershipFunction(9, 11, 12, 12))),
//            new UniverseOfDiscourse(0, 13, 1));
//
//    public static LinguisticVariable expected_num_interested_in_me = new LinguisticVariable("expected_num_interested_in_me",
//            List.of(new Label("none", new TrapezoidalMembershipFunction(0, 0, 1, 3)),
//                    new Label("few", new TrapezoidalMembershipFunction(1, 3, 4, 6)),
//                    new Label("not many", new TriangleMembershipFunction(4, 5, 7)),
//                    new Label("some", new TriangleMembershipFunction(6, 7, 8)),
//                    new Label("many", new TriangleMembershipFunction(8, 9, 10)),
//                    new Label("a lot", new TrapezoidalMembershipFunction(9, 11, 15, 15))),
//            new UniverseOfDiscourse(0, 15, 1));

}
