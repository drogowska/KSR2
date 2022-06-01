package ksr.zad2.soft.data;

import java.util.ArrayList;
import java.util.List;

import static ksr.zad2.soft.SoftApplication.database;

public class AttributesLists {
    static List<Integer> age = new ArrayList<>();
    static List<Integer> d_age= new ArrayList<>();;
    static List<Integer> importance_same_race= new ArrayList<>();;
    static List<Integer> importance_same_religion= new ArrayList<>();;
    static List<Integer> pref_o_ambitious= new ArrayList<>();;
    static List<Integer> pref_o_intelligence= new ArrayList<>();;
    static List<Integer> sincere= new ArrayList<>();;
    static List<Integer> tvsports= new ArrayList<>();;
    static List<Integer> expected_num_interested_in_me= new ArrayList<>();;
    static List<Integer> guess_prob_liked= new ArrayList<>();;

    public static void fill() {
        database.forEach(d -> {
            age.add((int) d.getAge());
            d_age.add((int) d.getD_age());
            importance_same_race.add((int) d.getImportance_same_race());
            importance_same_religion.add((int) d.getImportance_same_religion());
            pref_o_ambitious.add((int) d.getPref_o_ambitious());
            pref_o_intelligence.add((int) d.getPref_o_intelligence());
            sincere.add((int) d.getSincere());
            tvsports.add((int) d.getTvsports());
            expected_num_interested_in_me.add((int) d.getExpected_num_interested_in_me());
            guess_prob_liked.add((int) d.getGuess_prob_liked());
        });
    }
}
