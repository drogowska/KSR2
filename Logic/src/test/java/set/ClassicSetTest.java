package set;

import functions.ConstantFunction;
import functions.UniverseOfDiscourse;
import functions.UniverseOfDiscourseType;
import fuzzy.CompoundVariable;
import fuzzy.Defined;
import fuzzy.Label;
import fuzzy.LinguisticSummary;


import org.junit.Test;
import quantifier.FuzzyQuantifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ClassicSetTest {

    @Test
    public void createClassicSet() {
        Label l = Defined.age.getByName("young");
        Label l1 = Defined.funny.getByName("funny");
        String subject = "female"; //record.getGender()
        FuzzyQuantifier quantifier = (FuzzyQuantifier) Defined.quantifier.get(0);
        //1 forma
        //almost none of female is young and funny.  //f 1 o


        CompoundVariable sum = new CompoundVariable(List.of(l, l), List.of("and") );
//        LinguisticSummary s = new LinguisticSummary(quantifier, sum, subject);


    }
}