package ksr.zad2.soft.gui;

import java.text.DecimalFormat;

public class SummaryModel {

    private String summary;
    private Float T1;
    private Float T2;
    private Float T3;
    private Float T4;
    private Float T5;
    private Float T6;
    private Float T7;
    private Float T8;
    private Float T9;
    private Float T10;
    private Float T11;
    private Float T;
    private Boolean save;

    public SummaryModel(String summary, Float t1, Float t2, Float t3, Float t4, Float t5, Float t6, Float t7, Float t8, Float t9, Float t10, Float t11, Float t, Boolean save) {
        this.summary = summary;
        T1 = t1;
        T2 = t2;
        T3 = t3;
        T4 = t4;
        T5 = t5;
        T6 = t6;
        T7 = t7;
        T8 = t8;
        T9 = t9;
        T10 = t10;
        T11 = t11;
        T = t;
        this.save = save;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Float getT1() {
        return T1;
    }

    public void setT1(Float t1) {
        T1 = t1;
    }

    public Float getT2() {
        return T2;
    }

    public void setT2(Float t2) {
        T2 = t2;
    }

    public Float getT3() {
        return T3;
    }

    public void setT3(Float t3) {
        T3 = t3;
    }

    public Float getT4() {
        return T4;
    }

    public void setT4(Float t4) {
        T4 = t4;
    }

    public Float getT5() {
        return T5;
    }

    public void setT5(Float t5) {
        T5 = t5;
    }

    public Float getT6() {
        return T6;
    }

    public void setT6(Float t6) {
        T6 = t6;
    }

    public Float getT7() {
        return T7;
    }

    public void setT7(Float t7) {
        T7 = t7;
    }

    public Float getT8() {
        return T8;
    }

    public void setT8(Float t8) {
        T8 = t8;
    }

    public Float getT9() {
        return T9;
    }

    public void setT9(Float t9) {
        T9 = t9;
    }

    public Float getT10() {
        return T10;
    }

    public void setT10(Float t10) {
        T10 = t10;
    }

    public Float getT11() {
        return T11;
    }

    public void setT11(Float t11) {
        T11 = t11;
    }

    public Float getT() {
        return T;
    }

    public void setT(Float t) {
        T = t;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.###");
        return summary +
                " & " + df.format(T1) + " " +
                " & " + df.format(T2) + " " +
                " & " + df.format(T3) + " " +
                " & " + df.format(T4) + " " +
                " & " + df.format(T5) + " " +
                " & " + df.format(T6) + " " +
                " & " + df.format(T7) + " " +
                " & " + df.format(T8) + " " +
                " & " + df.format(T9) + " " +
                " & " + df.format(T10) + " " +
                " & " + df.format(T11) + " " +
                " & " + df.format(T);
    }
}
