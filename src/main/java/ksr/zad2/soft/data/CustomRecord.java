package ksr.zad2.soft.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.management.ConstructorParameters;
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


}
