package ksr.zad2.soft.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
@AllArgsConstructor
@Getter
public class CustomRecord {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private float age;
    private String gender;
    private String race;
    private String field;
    private float d_age;
    private float importance_same_race;
    private float importance_same_religion;
    private float pref_o_ambitious;
    private float pref_o_intelligence;
    private float sincere;
    private float tvsports;
    private float expected_num_interested_in_me;
    private float guess_prob_liked;
    private float funny;

    public CustomRecord(float age, String gender, String race, String field,
                        float d_age, float importance_same_race, float importance_same_religion,
                        float pref_o_ambitious, float pref_o_intelligence, float sincere,
                        float tvsports, float expected_num_interested_in_me, float guess_prob_liked, float funny) {
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.field = field;
        this.d_age = d_age;
        this.importance_same_race = importance_same_race;
        this.importance_same_religion = importance_same_religion;
        this.pref_o_ambitious = pref_o_ambitious;
        this.pref_o_intelligence = pref_o_intelligence;
        this.sincere = sincere;
        this.tvsports = tvsports;
        this.expected_num_interested_in_me = expected_num_interested_in_me;
        this.guess_prob_liked = guess_prob_liked;
        this.funny = funny;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public float getD_age() {
        return d_age;
    }

    public void setD_age(float d_age) {
        this.d_age = d_age;
    }

    public float getImportance_same_race() {
        return importance_same_race;
    }

    public void setImportance_same_race(float importance_same_race) {
        this.importance_same_race = importance_same_race;
    }

    public float getImportance_same_religion() {
        return importance_same_religion;
    }

    public void setImportance_same_religion(float importance_same_religion) {
        this.importance_same_religion = importance_same_religion;
    }

    public float getPref_o_ambitious() {
        return pref_o_ambitious;
    }

    public void setPref_o_ambitious(float pref_o_ambitious) {
        this.pref_o_ambitious = pref_o_ambitious;
    }

    public float getPref_o_intelligence() {
        return pref_o_intelligence;
    }

    public void setPref_o_intelligence(float pref_o_intelligence) {
        this.pref_o_intelligence = pref_o_intelligence;
    }

    public float getSincere() {
        return sincere;
    }

    public void setSincere(float sincere) {
        this.sincere = sincere;
    }

    public float getTvsports() {
        return tvsports;
    }

    public void setTvsports(float tvsports) {
        this.tvsports = tvsports;
    }

    public float getExpected_num_interested_in_me() {
        return expected_num_interested_in_me;
    }

    public void setExpected_num_interested_in_me(float expected_num_interested_in_me) {
        this.expected_num_interested_in_me = expected_num_interested_in_me;
    }

    public float getGuess_prob_liked() {
        return guess_prob_liked;
    }

    public void setGuess_prob_liked(float guess_prob_liked) {
        this.guess_prob_liked = guess_prob_liked;
    }

    public float getFunny() {
        return funny;
    }

    public void setFunny(float funny) {
        this.funny = funny;
    }
}
