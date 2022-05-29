import data.SpeedDatingRecord;
import database.PostgreSQLJPA;

import java.util.List;

public class TUIMain {

    public static void main(String[] args) {
        List<SpeedDatingRecord> recordList = (new PostgreSQLJPA()).getAllRecords();
        System.out.println(recordList.size());
        //LinguisticSummary linguisticSummary = new LinguisticSummary(quant);
        //System.out.println(linguisticSummary.T1());
    }
}
