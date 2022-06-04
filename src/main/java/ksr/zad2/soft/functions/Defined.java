package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.functions.*;
import ksr.zad2.soft.set.ClassicSet;
import ksr.zad2.soft.set.DenseClassicSet;
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

    private static DenseClassicSet sincereUni = new DenseClassicSet(List.of(0,1,2,3,4,5,6,7,8,9,10,11,12));

    public static LinguisticVariable sincere = new LinguisticVariable("sincere",
                    List.of(new FuzzySet("insincere", new GaussMembershipFunction<CustomRecord>(Extractor::sincere, 7.0, 2.0, new DenseClassicSet(4, 11)), sincereUni),
                            new FuzzySet("sincere", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::sincere,8, 11, 13, 13), sincereUni),
                            new FuzzySet("duplicitous", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::sincere,0, 2, 2, 6), sincereUni)
                    ), sincereUni);

    public static LinguisticVariable funny = new LinguisticVariable("funny",
                                    List.of(new FuzzySet("boring", new TrapezoidalMembershipFunction<CustomRecord>( Extractor::funny, 0,0,2,3), sincereUni),
                                            new FuzzySet("a little bit boring", new TriangleMembershipFunction<CustomRecord>( Extractor::funny,1,4,6), sincereUni),
                                            new FuzzySet("entertaining", new TrapezoidalMembershipFunction<CustomRecord>( Extractor::funny,9, 10, 13,13), sincereUni),
                                            new FuzzySet("funny", new TrapezoidalMembershipFunction<CustomRecord>( Extractor::funny,5,6,7,10), sincereUni)),
                                    sincereUni);

    public static LinguisticVariable guess_prob_liked = new LinguisticVariable("guess_prob_liked",
            List.of(new FuzzySet("none", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::guess_prob_liked,0, 0, 1, 2),sincereUni),
                    new FuzzySet("tiny", new TriangleMembershipFunction<CustomRecord>(Extractor::guess_prob_liked,1, 3, 4),sincereUni),
                    new FuzzySet("small", new TriangleMembershipFunction<CustomRecord>(Extractor::guess_prob_liked,3, 5, 6),sincereUni),
                    new FuzzySet("significant", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::guess_prob_liked,5, 8, 9, 10), sincereUni),
                    new FuzzySet("huge", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::guess_prob_liked,9, 11, 12, 12), sincereUni)),
            sincereUni);

    private static DenseClassicSet ageUni = new DenseClassicSet(List.of(18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,42,55));
    public static LinguisticVariable age = new LinguisticVariable<CustomRecord>("age",
            List.of(new FuzzySet("teneageer", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 16,16,18, 20), cutDB),
                    new FuzzySet("young", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 17, 22, 28,30), ageUni),
                    new FuzzySet("in middle age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 28,34,40,44), ageUni),
                    new FuzzySet("in the prime of age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 40,45,49,50), ageUni),
                    new FuzzySet("old", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::age, 45,50,65,65), ageUni)),ageUni);

    private static DenseClassicSet dageUni = new DenseClassicSet(List.of(18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,42,55));

    public static LinguisticVariable d_age = new LinguisticVariable("d_age",
            List.of(new FuzzySet("none difference in age", new TriangleMembershipFunction<CustomRecord>(Extractor::d_age,0,0,1), dageUni),
                    new FuzzySet("tiny difference in age", new TriangleMembershipFunction<CustomRecord>(Extractor::d_age,1, 3, 5), dageUni),
                    new FuzzySet("small difference in age", new TriangleMembershipFunction<CustomRecord>(Extractor::d_age,3,7,10), dageUni),
                    new FuzzySet("average difference in age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::d_age,9,17,19,23),dageUni),
                    new FuzzySet("significant difference in age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::d_age,15,19,22,32),dageUni),
                    new FuzzySet("huge difference in age", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::d_age,30,35,45,45),dageUni)),dageUni);


    public static LinguisticVariable importance_same_race = new LinguisticVariable("importance_same_race",
            List.of(new FuzzySet("none", new TriangleMembershipFunction<CustomRecord>(Extractor::importance_same_race, 0,0,1), sincereUni),
                    new FuzzySet("tiny", new TriangleMembershipFunction<CustomRecord>(Extractor::importance_same_race,1, 2, 3), sincereUni),
                    new FuzzySet("small", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::importance_same_race,2, 3, 4, 5), sincereUni),
                    new FuzzySet("average", new TriangleMembershipFunction<CustomRecord>(Extractor::importance_same_race,4,5,6), sincereUni),
                    new FuzzySet("significant", new GaussMembershipFunction<CustomRecord>(Extractor::importance_same_race,6, 1, new DenseClassicSet(5, 8)),sincereUni),
                    new FuzzySet("huge", new GaussMembershipFunction<CustomRecord>(Extractor::importance_same_race,9,1.5, new DenseClassicSet(7, 10)), sincereUni)),
           sincereUni);

    public static LinguisticVariable importance_same_religion = new LinguisticVariable("importance_same_religion",
            List.of(new FuzzySet("none", new TriangleMembershipFunction<CustomRecord>(Extractor::importance_same_religion, 0,0,1),sincereUni),
                    new FuzzySet("tiny", new TriangleMembershipFunction<CustomRecord>(Extractor::importance_same_religion,1, 2, 3),sincereUni),
                    new FuzzySet("small", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::importance_same_religion,2, 3, 4, 5),sincereUni),
                    new FuzzySet("average", new TriangleMembershipFunction<CustomRecord>(Extractor::importance_same_religion,4,5,6),sincereUni),
                    new FuzzySet("significant", new GaussMembershipFunction<CustomRecord>(Extractor::importance_same_religion,6, 1, new DenseClassicSet(0, 13)),sincereUni),
                    new FuzzySet("huge", new GaussMembershipFunction<CustomRecord>(Extractor::importance_same_religion,9,1.5, new DenseClassicSet(0, 13)),sincereUni)),
            sincereUni);

private static DenseClassicSet ambitiousUni = new DenseClassicSet(0,55);

    public static LinguisticVariable pref_o_ambitious = new LinguisticVariable("pref_o_ambitious",
            List.of(new FuzzySet("not ambitious", new GaussMembershipFunction<CustomRecord>(Extractor::pref_o_ambitious,6, 8, new DenseClassicSet(0, 24)),ambitiousUni),
                    new FuzzySet("moderately ambitious'", new GaussMembershipFunction<CustomRecord>(Extractor::pref_o_ambitious,30, 12, new DenseClassicSet(5, 54)),ambitiousUni),
                    new FuzzySet("ambitious", new GaussMembershipFunction<CustomRecord>(Extractor::pref_o_ambitious,45, 5, new DenseClassicSet(30, 55)),ambitiousUni)),
            ambitiousUni);

private static DenseClassicSet IntelligenceUni = new DenseClassicSet(0,55);
    public static LinguisticVariable pref_o_intelligence = new LinguisticVariable<CustomRecord>("pref_o_intelligence",
            List.of(new FuzzySet("stupid", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::pref_o_intelligence,0,0,1,3),IntelligenceUni),
                    new FuzzySet("not very intelligent", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::pref_o_intelligence,2,5,12,16),IntelligenceUni),
                    new FuzzySet("average", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::pref_o_intelligence,14, 20, 30, 35),IntelligenceUni),
                    new FuzzySet("inteligent", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::pref_o_intelligence,32, 44, 58, 64),IntelligenceUni),
                    new FuzzySet("genius", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::pref_o_intelligence,57, 62, 67, 67),IntelligenceUni)),
            IntelligenceUni);

    public static LinguisticVariable tvsports = new LinguisticVariable("sports",
            List.of(new FuzzySet("not interested", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::tvsports, 0, 0, 2, 5),sincereUni),
                    new FuzzySet("neutral", new TriangleMembershipFunction<CustomRecord>(Extractor::tvsports,2, 4, 7),sincereUni),
                    new FuzzySet("moderately interested", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::tvsports,4, 6, 8, 9),sincereUni),
                    new FuzzySet("interested", new TriangleMembershipFunction<CustomRecord>(Extractor::tvsports,8, 9, 11),sincereUni),
                    new FuzzySet("passionate", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::tvsports,9, 11, 12, 12),sincereUni)),
            sincereUni);

    public static LinguisticVariable expected_num_interested_in_me = new LinguisticVariable("expected_num_interested_in_me",
            List.of(new FuzzySet("none", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::expected_num_interested_in_me,0, 0, 1, 3),sincereUni),
                    new FuzzySet("few", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::expected_num_interested_in_me,1, 3, 4, 6),sincereUni),
                    new FuzzySet("not many", new TriangleMembershipFunction<CustomRecord>(Extractor::expected_num_interested_in_me,4, 5, 7),sincereUni),
                    new FuzzySet("some", new TriangleMembershipFunction<CustomRecord>(Extractor::expected_num_interested_in_me,6, 7, 8),sincereUni),
                    new FuzzySet("many", new TriangleMembershipFunction<CustomRecord>(Extractor::expected_num_interested_in_me,8, 9, 10),sincereUni),
                    new FuzzySet("a lot", new TrapezoidalMembershipFunction<CustomRecord>(Extractor::expected_num_interested_in_me,9, 11, 15, 15),sincereUni)),
            sincereUni);

}
