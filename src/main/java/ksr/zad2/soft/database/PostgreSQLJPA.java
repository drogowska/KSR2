package ksr.zad2.soft.database;

import ksr.zad2.soft.data.SpeedDatingRecord;

import javax.persistence.*;
import java.util.List;

public class PostgreSQLJPA {

    @PersistenceContext
    private EntityManagerFactory emf;
    private EntityManager em;

    public PostgreSQLJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("record");
        em = emf.createEntityManager();
    }

    public List<SpeedDatingRecord> getAllRecords() {
        TypedQuery<SpeedDatingRecord> q = em.createQuery("SELECT id, has_null, wave, gender, age, age_o, d_age, d_d_age, race, race_o, samerace, importance_same_race, importance_same_religion, d_importance_same_race, d_importance_same_religion, field, pref_o_attractive, pref_o_sincere, pref_o_intelligence, pref_o_funny, pref_o_ambitious, pref_o_shared_interests, d_pref_o_attractive, d_pref_o_sincere, d_pref_o_intelligence, d_pref_o_funny, d_pref_o_ambitious, d_pref_o_shared_interests, attractive_o, sinsere_o, intelligence_o, funny_o, ambitous_o, shared_interests_o, d_attractive_o, d_sinsere_o, d_intelligence_o, d_funny_o, d_ambitous_o, d_shared_interests_o, attractive_important, sincere_important, intellicence_important, funny_important, ambtition_important, shared_interests_important, d_attractive_important, d_sincere_important, d_intellicence_important, d_funny_important, d_ambtition_important, d_shared_interests_important, attractive, sincere, intelligence, funny, ambition, d_attractive, d_sincere, d_intelligence, d_funny, d_ambition, attractive_partner, sincere_partner, intelligence_partner, funny_partner, ambition_partner, shared_interests_partner, d_attractive_partner, d_sincere_partner, d_intelligence_partner, d_funny_partner, d_ambition_partner, d_shared_interests_partner, sports, tvsports, exercise, dining, museums, art, hiking, gaming, clubbing, reading, tv, theater, movies, concerts, music, shopping, yoga, d_sports, d_tvsports, d_exercise, d_dining, d_museums, d_art, d_hiking, d_gaming, d_clubbing, d_reading, d_tv, d_theater, d_movies, d_concerts, d_music, d_shopping, d_yoga, interests_correlate, d_interests_correlate, expected_happy_with_sd_people, expected_num_interested_in_me, expected_num_matches, d_expected_happy_with_sd_people, d_expected_num_interested_in_me, d_expected_num_matches, _like, guess_prob_liked, d_like, d_guess_prob_liked, met, decision, decision_o, _match, d_pref_o_intelligence, d_pref_o_sincere\n" +
                "\t FROM sp_tab", SpeedDatingRecord.class);
        return q.getResultList();
    }
}
