package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.functions.*;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import java.util.List;

public class Defined {

    public static List<FuzzyQuantifier> quantifier = List.of
            (new FuzzyQuantifier("Almost none of", new TrapezoidalMembershipFunction(0, 0, 50, 100), false),
                    new FuzzyQuantifier("Some of", new TrapezoidalMembershipFunction(0, 200, 1500, 1700), false),
                    new FuzzyQuantifier("Approximately 1/3 of", new GaussMembershipFunction(2700.0, 800.0, new UniverseOfDiscourse(1000.0, 5000.0)), false),
                    new FuzzyQuantifier("Around half of", new TriangleMembershipFunction(3789, 4189, 4589), false),
                    new FuzzyQuantifier("Most of", new TrapezoidalMembershipFunction(4100, 4600, 8378.0, 8378.0), false),
                    new FuzzyQuantifier("The vast majority of", new TrapezoidalMembershipFunction(7300, 8300, 8378, 8378.0), false),
                            new FuzzyQuantifier("Around 8000", new TrapezoidalMembershipFunction(5500.0, 8000, 8400, 8400), true),
                            new FuzzyQuantifier("More than 5000", new GaussMembershipFunction(5000.0, 1000.0, new UniverseOfDiscourse(2800.0, 6900.0)), true),
                            new FuzzyQuantifier("Approximately 3000", new TrapezoidalMembershipFunction(1600, 2600,4000,5000), true),
                            new FuzzyQuantifier("More than 1000", new GaussMembershipFunction(1500, 500, new UniverseOfDiscourse(300.0, 2700)), true),
                            new FuzzyQuantifier("Less than 1000", new TrapezoidalMembershipFunction(0, 0, 600, 1000), true)
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


    public static LinguisticVariable age = new LinguisticVariable("age",
            List.of(new Label("teneageer", new TrapezoidalMembershipFunction(16,16,18, 20)),
                    new Label("young", new TrapezoidalMembershipFunction(17, 22, 28,30)),
                    new Label("in middle age", new TrapezoidalMembershipFunction(28,34,40,44)),
                    new Label("in the prime of age", new TrapezoidalMembershipFunction(40,45,49,50)),
                    new Label("old", new TrapezoidalMembershipFunction(45,50,65,65))),
            new UniverseOfDiscourse<Integer>(List.of(18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,42,55)));

    public static LinguisticVariable d_age = new LinguisticVariable("d_age",
            List.of(new Label("none", new TriangleMembershipFunction(0,0,1)),
                    new Label("tiny", new TriangleMembershipFunction(1, 3, 5)),
                    new Label("small", new TriangleMembershipFunction(3,7,10)),
                    new Label("average", new TrapezoidalMembershipFunction(9,17,19,23)),
                    new Label("significant", new TrapezoidalMembershipFunction(15,19,22,32)),
                    new Label("huge", new TrapezoidalMembershipFunction(30,35,45,45))),
            new UniverseOfDiscourse<Integer>(List.of(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,32,34,36,37)));

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
