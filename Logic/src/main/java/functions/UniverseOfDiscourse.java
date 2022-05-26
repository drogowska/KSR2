package functions;

import lombok.Getter;
import set.ClassicSet;

import java.util.List;
@Getter
public class UniverseOfDiscourse extends ClassicSet implements Cloneable, Comparable<UniverseOfDiscourse> {
    private UniverseOfDiscourseType universeOfDiscourseType;
    boolean isDense = true;
    boolean finite = true;

    public UniverseOfDiscourse(List<Double> values) {
        super();
        this.x = values;
    }
    public UniverseOfDiscourse(UniverseOfDiscourseType universeOfDiscourseType) {
        super();
        this.universeOfDiscourseType = universeOfDiscourseType;
    }

    public UniverseOfDiscourse(UniverseOfDiscourseType universeOfDiscourseType, List<Double> domain) {
        this.universeOfDiscourseType = universeOfDiscourseType;
        this.x = domain;
    }

    public UniverseOfDiscourse(double min, double max, double step) {
        for (Double i = min; i<=max; i+=step) {
            x.add(i);
        }
    }


    @Override
    public int compareTo(UniverseOfDiscourse o) {
        if (this.x.equals(o.x)) return 0;
        return -1;
    }
}
