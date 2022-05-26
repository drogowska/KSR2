import functions.*;
import fuzzy.LinguisticVariable;
import fuzzy.Qualifier;
import set.Label;

import java.util.List;

public class Defined {

    List<Qualifier> qualifiers = List.of(
            new Qualifier("relative",
                         List.of(new Label("Almost none", new TrapezoidalMembershipFunction(0,0, 50, 100)),
                                 new Label("Some of", new TrapezoidalMembershipFunction(0, 200, 1500, 1700)),
                                 new Label("Approximately 1/3 of", new GaussMembershipFunction(2700.0, 800.0, new UniverseOfDiscourse(1000.0, 5000.0, 1.0))),
                                 new Label("Around half of", new TriangleMembershipFunction(3789, 4189,4589)),
                                 new Label("Most of", new TrapezoidalMembershipFunction(4100, 4600,8378.0, 8378.0)),
                                 new Label("The vast majority of", new TrapezoidalMembershipFunction(7300, 8300, 8378, 8378.0))),
                         new UniverseOfDiscourse(0.0, 8378.0, 1.0)),

            new Qualifier("absolute",
                    List.of(
                            new Label("Around 8000", new TrapezoidalMembershipFunction(5500.0, 8000, 8400, 8400)),
                            new Label("More than 5000", new GaussMembershipFunction(5000.0, 1000.0, new UniverseOfDiscourse(2800.0, 6900.0, 1))),
                            new Label("Approximately 3000", new TrapezoidalMembershipFunction(1600, 2600,4000,5000)),
                            new Label("More than 1000", new GaussMembershipFunction(1500, 500, new UniverseOfDiscourse(300.0, 2700, 1))),
                            new Label("Less than 1000", new TrapezoidalMembershipFunction(0, 0, 600, 1000))
                    ),
                    new UniverseOfDiscourse(0.0, 28378.0,1.0)));

    LinguisticVariable sincere = new LinguisticVariable("sincere",
                                                            List.of(new Label("insincere", new GaussMembershipFunction(7.0, 2.0, new UniverseOfDiscourse(4, 11, 1))),
                                                                    new Label("sincere", new TrapezoidalMembershipFunction(8, 11, 13, 13)),
                                                                    new Label("duplicitous", new TrapezoidalMembershipFunction(0, 2, 2, 6))
                                                            ),
                                                            new UniverseOfDiscourse(0, 13, 1));
}
