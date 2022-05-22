package data;

public class Subject {

    private final int age;
    private final int d_age;
    private final int importance_same_race;
    private final int importance_same_religion;
    private final float pref_o_intelligence;
    private final float pref_o_ambitious;
    private final int tvsports;
    private final int expected_num_interested_in_me;
    private final float guess_prob_liked;
    private final float sincere;

    public Subject(int age, int d_age, int importance_same_race, int importance_same_religion, float pref_o_inteligence, float pref_o_ambitious,
                   int tvsports, int expected_num_interested_in_me, float guess_prob_liked, float sincere) {
        this.age = age;
        this.d_age = d_age;
        this.importance_same_race = importance_same_race;
        this.importance_same_religion = importance_same_religion;
        this.pref_o_intelligence = pref_o_inteligence;
        this.pref_o_ambitious = pref_o_ambitious;
        this.tvsports = tvsports;
        this.expected_num_interested_in_me = expected_num_interested_in_me;
        this.guess_prob_liked = guess_prob_liked;
        this.sincere = sincere;
    }
}
