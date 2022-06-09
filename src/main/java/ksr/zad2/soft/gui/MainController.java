package ksr.zad2.soft.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import ksr.zad2.soft.Main;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.defined.DefinedLinguisticVariables;
import ksr.zad2.soft.fuzzy.*;

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

    private enum SubjectEnum {
        NONE, ALL, FEMALE, MALE;
    }

    @FXML
    public void initialize() {
        speedDatingRepository = Main.applicationContext.getBean(SpeedDatingRepository.class);

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

        DefinedLinguisticVariables.quantifiers.forEach(q -> quantifierComboBox.getItems().add(q.getQuantifierName()));

        variables.forEach(v -> v.getLabels().forEach(l -> {
            summarizerComboBox.getItems().add(v.getColumn() + " equals " + l.getLabelName());
            qualifierComboBox.getItems().add(v.getColumn() + " equals " + l.getLabelName());
        }));

        Arrays.stream(SubjectEnum.values()).forEach(s -> {
            subject1ComboBox.getItems().add(s);
            subject2ComboBox.getItems().add(s);
        });

    }

    @FXML
    public void generateSummary() {
        String summarizerColumn = summarizerComboBox.getValue().split(" equals ")[0];
        String summarizerLabel = summarizerComboBox.getValue().split(" equals ")[1];
        String qualifierColumn = qualifierComboBox.getValue().split(" equals ")[0];
        String qualifierLabel = qualifierComboBox.getValue().split(" equals ")[1];
        LinguisticVariable summarizerVariable = variables.stream().filter(v -> v.getColumn().name().equals(summarizerColumn)).findFirst().orElseThrow();
        LinguisticVariable qualifierVariable = variables.stream().filter(v -> v.getColumn().name().equals(qualifierColumn)).findFirst().orElseThrow();
        List<CustomRecord> firstSubject = getByEnum(subject1ComboBox.getValue());
        List<CustomRecord> secondSubject = getByEnum(subject2ComboBox.getValue());

        LinguisticSummary linguisticSummary = new LinguisticSummary(
                quantifiers.stream().filter(q -> q.getQuantifierName().equals(quantifierComboBox.getValue())).findFirst().orElseThrow(),
                List.of(new Qualifier(qualifierVariable.getLabel(qualifierLabel), qualifierVariable.getColumn(), ConnectiveEnum.AND)),
                List.of(new Summarizer(summarizerVariable.getLabel(summarizerLabel), summarizerVariable.getColumn(), ConnectiveEnum.AND)),
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
}
