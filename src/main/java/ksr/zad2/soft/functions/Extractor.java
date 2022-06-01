package ksr.zad2.soft.functions;

import ksr.zad2.soft.data.CustomRecord;

public class Extractor {

    public static double age(CustomRecord record) {
        return record.getAge();
    }

    public static double d_age(CustomRecord record) {
        return record.getD_age();
    }

    public static double importance_same_race(CustomRecord record) {
        return record.getImportance_same_race();
    }
    public static double importance_same_religion(CustomRecord record) {
        return record.getImportance_same_religion();
    }
    public static double pref_o_ambitious(CustomRecord record) {
        return record.getPref_o_ambitious();
    }
    public static double pref_o_intelligence(CustomRecord record) {
        return record.getPref_o_intelligence();
    }
}
