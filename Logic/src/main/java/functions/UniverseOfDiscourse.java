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
        this.values = values;
    }
//    public List<Double> getValues()
    public UniverseOfDiscourse(UniverseOfDiscourseType universeOfDiscourseType) {
        super();
        this.universeOfDiscourseType = universeOfDiscourseType;
    }

    public UniverseOfDiscourse(UniverseOfDiscourseType universeOfDiscourseType, List<Double> domain) {
        this.universeOfDiscourseType = universeOfDiscourseType;
        this.values = domain;
    }


    @Override
    public int compareTo(UniverseOfDiscourse o) {
        if (this.values.equals(o.values)) return 0;
        return -1;
    }
}
