package ksr.zad2.soft.data;

public enum AttributeEnum {
    age, gender, race, field,
    d_age, importance_same_race, importance_same_religion,
    pref_o_ambitious, pref_o_intelligence, sincere,
    tvsports, expected_num_interested_in_me, guess_prob_liked, funny;

    public static Object getValue(CustomRecord customRecord, AttributeEnum attributeEnum) {
        switch(attributeEnum) {
            case age: return customRecord.getAge();
            case race: return customRecord.getRace();
            case d_age: return customRecord.getD_age();
            case field: return customRecord.getField();
            case funny: return customRecord.getFunny();
            case gender: return customRecord.getGender();
            case sincere: return customRecord.getSincere();
            case tvsports: return customRecord.getTvsports();
            case guess_prob_liked: return customRecord.getGuess_prob_liked();
            case pref_o_ambitious: return customRecord.getPref_o_ambitious();
            case pref_o_intelligence: return customRecord.getPref_o_intelligence();
            case importance_same_race: return customRecord.getImportance_same_race();
            case importance_same_religion: return customRecord.getImportance_same_religion();
            case expected_num_interested_in_me: return customRecord.getExpected_num_interested_in_me();
            default: return null;
        }
    }
}
