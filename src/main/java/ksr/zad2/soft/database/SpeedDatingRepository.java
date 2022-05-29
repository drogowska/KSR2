package ksr.zad2.soft.database;

import ksr.zad2.soft.data.SpeedDatingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeedDatingRepository extends JpaRepository<SpeedDatingRecord, Long> {
}
