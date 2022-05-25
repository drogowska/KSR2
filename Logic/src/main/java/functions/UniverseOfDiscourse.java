package functions;

import lombok.Getter;
import set.ClassicSet;

import java.util.List;
@Getter
public class UniverseOfDiscourse extends ClassicSet implements Cloneable {
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



}
