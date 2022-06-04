package ksr.zad2.soft.database;

import ksr.zad2.soft.data.SpeedDatingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface SpeedDatingRepository extends JpaRepository<SpeedDatingRecord, Long> {

    default List<Float> getDistinctAge() {
        return findAll().stream().map(r -> r.getCustomRecord().getAge()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctD_Age() {
        return findAll().stream().map(r -> r.getCustomRecord().getD_age()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctImportance_same_race() {
        return findAll().stream().map(r -> r.getCustomRecord().getImportance_same_race()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctImportance_same_religion() {
        return findAll().stream().map(r -> r.getCustomRecord().getImportance_same_religion()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctPref_o_ambitious() {
        return findAll().stream().map(r -> r.getCustomRecord().getPref_o_ambitious()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctPref_o_intelligence() {
        return findAll().stream().map(r -> r.getCustomRecord().getPref_o_intelligence()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctSincere() {
        return findAll().stream().map(r -> r.getCustomRecord().getSincere()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctTvsports() {
        return findAll().stream().map(r -> r.getCustomRecord().getTvsports()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctExpected_num_interested_in_me() {
        return findAll().stream().map(r -> r.getCustomRecord().getExpected_num_interested_in_me()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctGuess_prob_liked() {
        return findAll().stream().map(r -> r.getCustomRecord().getGuess_prob_liked()).distinct().collect(Collectors.toList());
    }

    default List<Float> getDistinctFunny() {
        return findAll().stream().map(r -> r.getCustomRecord().getFunny()).distinct().collect(Collectors.toList());
    }
}
