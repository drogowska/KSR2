package ksr.zad2.soft.data;

import javax.persistence.*;

@Entity(name = "sp_tab")
public class SpeedDatingRecord {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private int has_null;
    private float wave;
    private String gender;
    private float age;
    private float age_o;
    private float d_age;
    private String d_d_age;
    private String race;
    private String race_o;
    private int samerace;
    private float importance_same_race;
    private float importance_same_religion;
    private String d_importance_same_race;
    private String d_importance_same_religion;
    private String field;
    private float pref_o_attractive;
    private float pref_o_sincere;
    private float pref_o_intelligence;
    private float pref_o_funny;
    private float pref_o_ambitious;
    private float pref_o_shared_interests;
    private String d_pref_o_attractive;
    private String d_pref_o_sincered_pref_o_intelligence;
    private String d_pref_o_funny;
    private String d_pref_o_ambitious;
    private String d_pref_o_shared_interests;
    private String attractive_o;
    private float sinsere_o;
    private float intelligence_o;
    private float funny_o;
    private float ambitous_o;
    private float shared_interests_o;
    private String d_attractive_o;
    private String d_sinsere_o;
    private String d_intelligence_o;
    private String d_funny_o;
    private String d_ambitous_o;
    private String d_shared_interests_o;
    private String attractive_important;
    private float sincere_important;
    private float intellicence_important;
    private float funny_important;
    private float ambtition_important;
    private float shared_interests_important;
    private String d_attractive_important;
    private String d_sincere_important;
    private String d_intellicence_important;
    private String d_funny_important;
    private String d_ambtition_important;
    private String d_shared_interests_important;
    private String attractive;
    private float sincere;
    private float intelligence;
    private float funny;
    private float ambition;
    private String d_attractive;
    private String d_sincere;
    private String d_intelligence;
    private String d_funny;
    private String d_ambition;
    private String attractive_partner;
    private float sincere_partner;
    private float intelligence_partner;
    private float funny_partner;
    private float ambition_partner;
    private float shared_interests_partner;
    private String d_attractive_partner;
    private String d_sincere_partner;
    private String d_intelligence_partner;
    private String d_funny_partner;
    private String d_ambition_partner;
    private String d_shared_interests_partner;
    private String sports;
    private float tvsports;
    private float exercise;
    private float dining;
    private float museums;
    private float art;
    private float hiking;
    private float gaming;
    private float clubbing;
    private float reading;
    private float tv;
    private float theater;
    private float movies;
    private float concerts;
    private float music;
    private float shopping;
    private float yoga;
    private float d_sports;
    private String d_tvsports;
    private String d_exercise;
    private String d_dining;
    private String d_museums;
    private String d_art;
    private String d_hiking;
    private String d_gaming;
    private String d_clubbing;
    private String d_reading;
    private String d_tv;
    private String d_theater;
    private String d_movies;
    private String d_concerts;
    private String d_music;
    private String d_shopping;
    private String d_yoga;
    private String interests_correlate;
    private float d_interests_correlate;
    private String expected_happy_with_sd_people;
    private float expected_num_interested_in_me;
    private float expected_num_matches;
    private String d_expected_happy_with_sd_people;
    private String d_expected_num_interested_in_me;
    private String d_expected_num_matches;
    private String _like;
    private float guess_prob_liked;
    private String d_like;
    private String d_guess_prob_liked;
    private String met;
    private float decision;
    private float decision_o;
    private float _match;
    private float column_123;

    public SpeedDatingRecord() {
    }

    public CustomRecord getCustomRecord() {
        return new CustomRecord(age, gender, race, field, d_age, importance_same_race,
                importance_same_religion, pref_o_ambitious, pref_o_intelligence, sincere, tvsports,
                expected_num_interested_in_me, guess_prob_liked, funny);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
