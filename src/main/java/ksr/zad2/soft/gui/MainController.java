package ksr.zad2.soft.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ksr.zad2.soft.Main;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
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

    @FXML
    ComboBox<ConnectiveEnum> summarizerConnective;

    @FXML
    ComboBox<ConnectiveEnum> qualifierConnective;

    @FXML
    ComboBox<FormEnum> formComboBox;

    @FXML
    TextArea summarizerText;

    @FXML
    TextArea qualifierText;

    private SpeedDatingRepository speedDatingRepository;
    private List<LinguisticVariable> variables;
    private List<CustomRecord> allData;
    private List<CustomRecord> females;
    private List<CustomRecord> males;
    private List<Summarizer> availableSummarizers;
    private List<Qualifier> availableQualifiers;
    private List<Quantifier> availableQuantifiers;
    private List<Float> wages;
    private List<Summarizer> chosenSummarizers;
    private List<Qualifier> chosenQualifiers;
    private static String NONE = "none";
    private static String EQUALS = " equals ";

    private enum SubjectEnum {
        NONE, ALL, FEMALE, MALE;
    }

    private enum FormEnum {
        Jednopodmiotowe_forma_1,
        Jednopodmiotowe_forma_2,
        Wielopodmiotowe_forma_1,
        Wielopodmiotowe_forma_2,
        Wielopodmiotowe_forma_3,
        Wielopodmiotowe_forma_4
    }

    @FXML
    public void initialize() {
        speedDatingRepository = Main.applicationContext.getBean(SpeedDatingRepository.class);
        initializeRealVariables();
        refreshJavaFx();
        fillComboBoxes();
    }

    @FXML
    public void generateSummary() {

        List<CustomRecord> firstSubject = getByEnum(subject1ComboBox.getValue());
        List<CustomRecord> secondSubject = getByEnum(subject2ComboBox.getValue());

        LinguisticSummary linguisticSummary = new LinguisticSummary(
                quantifiers.stream().filter(q -> q.getQuantifierName().equals(quantifierComboBox.getValue())).findFirst().orElse(null),
                chosenQualifiers,
                chosenSummarizers,
                firstSubject,
                secondSubject,
                formComboBox.getValue().equals(FormEnum.Wielopodmiotowe_forma_3)
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

        wages = List.of(0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f);

        chosenSummarizers = new ArrayList<>();
        chosenQualifiers = new ArrayList<>();
    }

    private static void generateAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void refreshJavaFx() {
        qualifierComboBox.getItems().clear();
        quantifierComboBox.getItems().clear();
        summarizerComboBox.getItems().clear();
        summarizerConnective.getItems().clear();
        qualifierConnective.getItems().clear();
        subject1ComboBox.getItems().clear();
        subject2ComboBox.getItems().clear();
        formComboBox.getItems().clear();

        qualifierComboBox.getItems().add(NONE);
        quantifierComboBox.getItems().add(NONE);
        summarizerComboBox.getItems().add(NONE);

        availableQuantifiers.forEach(q -> quantifierComboBox.getItems().add(q.getQuantifierName()));
        availableQualifiers.forEach(q -> qualifierComboBox.getItems().add(q.getColumnName().name() + EQUALS + q.getLabel()));
        availableSummarizers.forEach(s -> summarizerComboBox.getItems().add(s.getColumnName().name() + EQUALS + s.getLabel()));

        Arrays.stream(SubjectEnum.values()).forEach(s -> {
            subject1ComboBox.getItems().add(s);
            subject2ComboBox.getItems().add(s);
        });

        wagesGridPane.getChildren().forEach(node -> {
            if(node != null && GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null) {
                if(GridPane.getColumnIndex(node) == 1) {
                    ((TextField)node).setText(String.valueOf(wages.get(GridPane.getRowIndex(node) - 1)));
                }
            }
        });

        Arrays.stream(ConnectiveEnum.values()).forEach(connectiveEnum -> {
            summarizerConnective.getItems().add(connectiveEnum);
            qualifierConnective.getItems().add(connectiveEnum);
        });

        Arrays.stream(FormEnum.values()).forEach(form -> formComboBox.getItems().add(form));

        refreshQualifierAndSummarizer();
    }

    private void refreshQualifierAndSummarizer() {
        summarizerText.setText(new SummarizerList(chosenSummarizers).toString());
        qualifierText.setText(new QualifierList(chosenQualifiers).toString());
    }

    private void fillComboBoxes() {
        qualifierComboBox.getSelectionModel().select(0);
        quantifierComboBox.getSelectionModel().select(0);
        summarizerComboBox.getSelectionModel().select(0);
        summarizerConnective.getSelectionModel().select(0);
        qualifierConnective.getSelectionModel().select(0);
        subject1ComboBox.getSelectionModel().select(0);
        subject2ComboBox.getSelectionModel().select(0);
        formComboBox.getSelectionModel().select(0);
    }

    @FXML
    public void addSummarizer() {
        if(summarizerComboBox.getValue() != NONE) {
            String summarizerColumn = summarizerComboBox.getValue().split(EQUALS)[0];
            String summarizerLabel = "";
            if(summarizerComboBox.getValue().split(EQUALS).length > 1) {
                summarizerLabel = summarizerComboBox.getValue().split(EQUALS)[1];
            }
            String finalSummarizerLabel = summarizerLabel;
            Summarizer summarizer = availableSummarizers.stream().filter(s ->
                s.getColumnName().name().equals(summarizerColumn) && s.getLabel().equals(finalSummarizerLabel)
            ).findFirst().orElse(null);
            summarizer = summarizer.copy();
            summarizer.setConnective(summarizerConnective.getValue());
            chosenSummarizers.add(summarizer);
        }
        refreshQualifierAndSummarizer();
    }

    @FXML
    public void addQualifier() {
        if(qualifierComboBox.getValue() != NONE) {
            String qualifierColumn = qualifierComboBox.getValue().split(EQUALS)[0];
            String qualifierLabel = "";
            if(qualifierComboBox.getValue().split(EQUALS).length > 1) {
                qualifierLabel = qualifierComboBox.getValue().split(EQUALS)[1];
            }
            String finalQualifierLabel = qualifierLabel;
            Qualifier qualifier = availableQualifiers.stream().filter(q ->
                    q.getColumnName().name().equals(qualifierColumn) && q.getLabel().equals(finalQualifierLabel)
            ).findFirst().orElse(null);
            qualifier = qualifier.copy();
            qualifier.setConnective(qualifierConnective.getValue());
            chosenQualifiers.add(qualifier);
        }
        refreshQualifierAndSummarizer();
    }

    @FXML
    public void resetSummary() {
        chosenQualifiers.clear();
        chosenSummarizers.clear();
        refreshJavaFx();
        fillComboBoxes();
    }
}
