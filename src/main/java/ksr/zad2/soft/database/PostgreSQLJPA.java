package ksr.zad2.soft.database;

import ksr.zad2.soft.data.SpeedDatingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostgreSQLJPA {

    @Autowired
    private SpeedDatingRepository speedDatingRepository;

    public List<SpeedDatingRecord> getAllRecords() {
        return speedDatingRepository.findAll();
    }
}
