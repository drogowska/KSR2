package ksr.zad2.soft.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import ksr.zad2.soft.Main;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.defined.DefinedLinguisticVariables;
import ksr.zad2.soft.fuzzy.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ksr.zad2.soft.defined.DefinedLinguisticVariables.*;

public class MainController {

    @FXML
    ComboBox<String> quantifierComboBox;

    @FXML
    ComboBox<String> summarizerComboBox;

    @FXML
    ComboBox<String> qualifierComboBox;

    @FXML
    ComboBox<SubjectEnum> subject1ComboBox;

    @FXML
    ComboBox<SubjectEnum> subject2ComboBox;

    @FXML
    GridPane wagesGridPane;

    private SpeedDatingRepository speedDatingRepository;
    private List<LinguisticVariable> variables;
    private List<CustomRecord> allData;
    private List<CustomRecord> females;
    private List<CustomRecord> males;
    private List<Summarizer> availableSummarizers;
    private List<Qualifier> availableQualifiers;
    private List<Quantifier> availableQuantifiers;

    private enum SubjectEnum {
        NONE, ALL, FEMALE, MALE;
    }

    @FXML
    public void initialize() {
        speedDatingRepository = Main.applicationContext.getBean(SpeedDatingRepository.class);
        initializeRealVariables();
        refreshJavaFx();
    }

    @FXML
    public void generateSummary() {
        String summarizerColumn = summarizerComboBox.getValue().split(" equals ")[0];
        String qualifierColumn = qualifierComboBox.getValue().split(" equals ")[0];
        String summarizerLabel = "";
        String qualifierLabel = "";
        if(summarizerComboBox.getValue().split(" equals ").length > 1) {
            summarizerLabel = summarizerComboBox.getValue().split(" equals ")[1];
        }
        if(qualifierComboBox.getValue().split(" equals ").length > 1) {
            qualifierLabel = qualifierComboBox.getValue().split(" equals ")[1];
        }

        List<CustomRecord> firstSubject = getByEnum(subject1ComboBox.getValue());
        List<CustomRecord> secondSubject = getByEnum(subject2ComboBox.getValue());

        String finalSummarizerLabel = summarizerLabel;
        Summarizer summarizer = availableSummarizers.stream().filter(s -> {
            return s.getColumnName().name().equals(summarizerColumn) && s.getLabel().equals(finalSummarizerLabel);
        }).findFirst().orElse(null);

        String finalQualifierLabel = qualifierLabel;
        Qualifier qualifier = availableQualifiers.stream().filter(q -> {
            return q.getColumnName().name().equals(qualifierColumn) && q.getLabel().equals(finalQualifierLabel);
        }).findFirst().orElse(null);

        LinguisticSummary linguisticSummary = new LinguisticSummary(
                quantifiers.stream().filter(q -> q.getQuantifierName().equals(quantifierComboBox.getValue())).findFirst().orElse(null),
                qualifier == null ? null : List.of(qualifier),
                summarizer == null ? null : List.of(summarizer),
                firstSubject,
                secondSubject,
                false
        );
        System.out.println(linguisticSummary.toString() + " [" + linguisticSummary.getT1() + "]");
    }

    private List<CustomRecord> getByEnum(SubjectEnum s) {
        switch(s) {
            case ALL:
                return allData;
            case MALE:
                return males;
            case FEMALE:
                return females;
            default:
                return null;
        }
    }

    private void initializeRealVariables() {
        allData = speedDatingRepository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        males = speedDatingRepository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("male"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Males");
                    return customRecord;
                }).collect(Collectors.toList());

        females = speedDatingRepository.findAll().stream()
                .filter(r -> r.getCustomRecord().getGender().equals("female"))
                .map(r -> {
                    CustomRecord customRecord = r.getCustomRecord();
                    customRecord.setName("Females");
                    return customRecord;
                }).collect(Collectors.toList());

        variables = List.of(sincere, age, d_age, expected_num_interested_in_me, tvsports, pref_o_intelligence, pref_o_ambitious, importance_same_race, importance_same_religion, guess_prob_liked, funny);
        availableQuantifiers = quantifiers;
        availableSummarizers = new ArrayList<>();
        availableQualifiers = new ArrayList<>();

        variables.forEach(v -> v.getLabels().forEach(l -> {
            availableQualifiers.add(new Qualifier(l, v.getColumn(), ConnectiveEnum.AND));
            availableSummarizers.add(new Summarizer(l, v.getColumn(), ConnectiveEnum.AND));
        }));
    }

    private void refreshJavaFx() {
        qualifierComboBox.getItems().clear();
        quantifierComboBox.getItems().clear();
        summarizerComboBox.getItems().clear();

        qualifierComboBox.getItems().add("none");
        quantifierComboBox.getItems().add("none");
        summarizerComboBox.getItems().add("none");

        availableQuantifiers.forEach(q -> quantifierComboBox.getItems().add(q.getQuantifierName()));
        availableQualifiers.forEach(q -> qualifierComboBox.getItems().add(q.getColumnName().name() + " equals " + q.getLabel()));
        availableSummarizers.forEach(s -> summarizerComboBox.getItems().add(s.getColumnName().name() + " equals " + s.getLabel()));

        Arrays.stream(SubjectEnum.values()).forEach(s -> {
            subject1ComboBox.getItems().add(s);
            subject2ComboBox.getItems().add(s);
        });
    }
}
