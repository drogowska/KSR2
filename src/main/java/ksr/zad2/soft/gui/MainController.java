package ksr.zad2.soft.gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import ksr.zad2.soft.Main;
import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.functions.GaussMembershipFunction;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.TrapezoidalMembershipFunction;
import ksr.zad2.soft.functions.TriangularMembershipFunction;
import ksr.zad2.soft.fuzzy.*;
import ksr.zad2.soft.fuzzy.Label;
import ksr.zad2.soft.set.FuzzySet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @FXML
    TableView summariesTable;

    @FXML
    ComboBox<LabelForNewObjectsEnum> newObjectComboBox;

    @FXML
    ComboBox<AttributeEnum> variablesComboBox;

    @FXML
    TextField labelNameField;

    @FXML
    ComboBox<FunctionEnum> functionComboBox;

    @FXML
    TextField A;

    @FXML
    TextField B;

    @FXML
    TextField C;

    @FXML
    TextField D;

    @FXML
    Text Ctext;

    @FXML
    Text Dtext;

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
    private List<LinguisticSummary> previousSummaries;
    private static String NONE = "none";
    private static String EQUALS = " equals ";

    public enum SubjectEnum {
        NONE, PEOPLE, FEMALE, MALE;
    }

    public enum FormEnum {
        Jednopodmiotowe_forma_1,
        Jednopodmiotowe_forma_2,
        Wielopodmiotowe_forma_1,
        Wielopodmiotowe_forma_2,
        Wielopodmiotowe_forma_3,
        Wielopodmiotowe_forma_4
    }

    public enum LabelForNewObjectsEnum {
        sumaryzatorów_i_kwalifikatorów,
        kwantyfikatorów_absolutnych,
        kwantyfikatorów_względnych
    }

    public enum FunctionEnum {
        Funkcja_Gaussa,
        Funkcja_Trójkątna,
        Funkcja_Trapezowa
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
        if(!isSummaryCorrect()) {
            return;
        }

        List<CustomRecord> firstSubject = getByEnum(subject1ComboBox.getValue());
        List<CustomRecord> secondSubject = getByEnum(subject2ComboBox.getValue());

        LinguisticSummary linguisticSummary = new LinguisticSummary(
                formComboBox.getValue(),
                quantifiers.stream().filter(q -> q.getQuantifierName().equals(quantifierComboBox.getValue())).findFirst().orElse(null),
                chosenQualifiers.isEmpty() ? null : chosenQualifiers,
                chosenSummarizers.isEmpty() ? null : chosenSummarizers,
                firstSubject,
                secondSubject,
                formComboBox.getValue().equals(FormEnum.Wielopodmiotowe_forma_3),
                new ArrayList<>(wages)
        );
        previousSummaries.add(linguisticSummary);
        refreshSummaryTable();
        generateAlert(Alert.AlertType.INFORMATION, "Powodzenie", "Podsumowanie zostało poprawnie wygenerowane i zapisane w zakładce Wyniki");
    }

    private List<CustomRecord> getByEnum(SubjectEnum s) {
        switch(s) {
            case PEOPLE:
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

        wages = new ArrayList<>();
        List.of(0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f).forEach(f -> wages.add(f));

        chosenSummarizers = new ArrayList<>();
        chosenQualifiers = new ArrayList<>();
        previousSummaries = new ArrayList<>();
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
        variablesComboBox.getItems().clear();
        newObjectComboBox.getItems().clear();
        functionComboBox.getItems().clear();

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
        refreshSummaryTable();

        Arrays.stream(AttributeEnum.values()).forEach(a -> variablesComboBox.getItems().add(a));
        Arrays.stream(LabelForNewObjectsEnum.values()).forEach(l -> newObjectComboBox.getItems().add(l));
        Arrays.stream(FunctionEnum.values()).forEach(f -> functionComboBox.getItems().add(f));
    }

    private void refreshSummaryTable() {
        ObservableList<SummaryModel> tableData = FXCollections.observableArrayList();
        previousSummaries.forEach(s -> {
            tableData.add(new SummaryModel(
                    s.toString(),
                    s.getT1(),
                    s.getT2(),
                    s.getT3(),
                    s.getT4(),
                    s.getT5(),
                    s.getT6(),
                    s.getT7(),
                    s.getT8(),
                    s.getT9(),
                    s.getT10(),
                    s.getT11(),
                    s.getOptimal(),
                    false
                    ));
        });

        ((TableColumn)summariesTable.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory<SummaryModel, String>("summary"));
        ((TableColumn)summariesTable.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T1"));
        ((TableColumn)summariesTable.getColumns().get(2)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T2"));
        ((TableColumn)summariesTable.getColumns().get(3)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T2"));
        ((TableColumn)summariesTable.getColumns().get(4)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T4"));
        ((TableColumn)summariesTable.getColumns().get(5)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T5"));
        ((TableColumn)summariesTable.getColumns().get(6)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T6"));
        ((TableColumn)summariesTable.getColumns().get(7)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T7"));
        ((TableColumn)summariesTable.getColumns().get(8)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T8"));
        ((TableColumn)summariesTable.getColumns().get(9)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T9"));
        ((TableColumn)summariesTable.getColumns().get(10)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T10"));
        ((TableColumn)summariesTable.getColumns().get(11)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T11"));
        ((TableColumn)summariesTable.getColumns().get(12)).setCellValueFactory(new PropertyValueFactory<SummaryModel, Float>("T"));

        ((TableColumn)summariesTable.getColumns().get(13)).setCellValueFactory(//new PropertyValueFactory<SummaryModel, Boolean>("save"));
                new Callback<TableColumn.CellDataFeatures<SummaryModel, CheckBox>, ObservableValue<CheckBox>>() {

                    @Override
                    public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<SummaryModel, CheckBox> summaryModelCheckBoxCellDataFeatures) {
                            SummaryModel summaryModel = summaryModelCheckBoxCellDataFeatures.getValue();
                            CheckBox checkBox = new CheckBox();

                            checkBox.selectedProperty().setValue(summaryModel.getSave());
                            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                                public void changed(ObservableValue<? extends Boolean> ov,
                                                    Boolean old_val, Boolean new_val) {
                                    summaryModel.setSave(new_val);
                                }
                            });

                            return new SimpleObjectProperty<CheckBox>(checkBox);
                    }
                });

        summariesTable.setItems(tableData);
    }

    private ObservableList<SummaryModel> getSummaryModelList() {
        return summariesTable.getItems();
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
        newObjectComboBox.getSelectionModel().selectFirst();
        variablesComboBox.getSelectionModel().selectFirst();
        functionComboBox.getSelectionModel().selectFirst();
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

    private boolean isSummaryCorrect() {
        Quantifier quantifier = quantifiers.stream().filter(q -> q.getQuantifierName().equals(quantifierComboBox.getValue())).findFirst().orElse(null);
        boolean isCorrect = false;

        switch (formComboBox.getValue()) {
            case Jednopodmiotowe_forma_1:
                isCorrect = (quantifier != null && getByEnum(subject1ComboBox.getValue()) != null && !chosenSummarizers.isEmpty());
                if(!isCorrect) {
                    generateAlert(Alert.AlertType.WARNING, "Złe parametry!", "Wybrana forma wymaga wybrania kwantyfikatora, sumaryzatorów oraz podmiotu 1");
                }
                break;
            case Jednopodmiotowe_forma_2:
                isCorrect = (quantifier != null && getByEnum(subject1ComboBox.getValue()) != null && !chosenSummarizers.isEmpty() && !chosenQualifiers.isEmpty());
                if(!isCorrect) {
                    generateAlert(Alert.AlertType.WARNING, "Złe parametry!", "Wybrana forma wymaga wybrania kwantyfikatora, kwalifikatorów, sumaryzatorów oraz podmiotu 1");
                }
                break;
            case Wielopodmiotowe_forma_1:
                isCorrect = (quantifier != null && getByEnum(subject1ComboBox.getValue()) != null && getByEnum(subject2ComboBox.getValue()) != null && !chosenSummarizers.isEmpty());
                if(!isCorrect) {
                    generateAlert(Alert.AlertType.WARNING, "Złe parametry!", "Wybrana forma wymaga wybrania kwantyfikatora, sumaryzatorów oraz podmiotu 1 oraz 2");
                }
                break;
            case Wielopodmiotowe_forma_2:
            case Wielopodmiotowe_forma_3:
                isCorrect = (quantifier != null && getByEnum(subject1ComboBox.getValue()) != null && getByEnum(subject2ComboBox.getValue()) != null && !chosenSummarizers.isEmpty() && !chosenQualifiers.isEmpty());
                if(!isCorrect) {
                    generateAlert(Alert.AlertType.WARNING, "Złe parametry!", "Wybrana forma wymaga wybrania kwantyfikatora, kwalifikatorów, sumaryzatorów oraz podmiotu 1 oraz 2");
                }
                break;
            case Wielopodmiotowe_forma_4:
                isCorrect = (getByEnum(subject1ComboBox.getValue()) != null && getByEnum(subject2ComboBox.getValue()) != null && !chosenSummarizers.isEmpty());
                if(!isCorrect) {
                    generateAlert(Alert.AlertType.WARNING, "Złe parametry!", "Wybrana forma wymaga wybrania sumaryzatorów oraz podmiotu 1 oraz 2");
                }
                break;
        }
        return isCorrect;
    }

    @FXML
    private void updateWages() {
        wagesGridPane.getChildren().forEach(node -> {
            if(node != null && GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null) {
                if(GridPane.getColumnIndex(node) == 1) {
                    wages.set(GridPane.getRowIndex(node) - 1, Float.parseFloat(((TextField)node).getText()));
                }
            }
        });
    }

    @FXML
    private void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Zapisz");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showSaveDialog(Stage.getWindows().stream().filter(Window::isShowing).collect(Collectors.toList()).get(0));

        StringBuilder result = new StringBuilder();
        getSummaryModelList().forEach(m -> {
            if(m.getSave()) {
                result.append(m.toString()).append("\n");
            }
        });

        try(FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(result.toString().getBytes());
        } catch (IOException ex) {
        }
    }

    @FXML
    private void addNewLabel() {
        MembershipFunction membershipFunction = switch (functionComboBox.getValue()) {
            case Funkcja_Trójkątna -> new TriangularMembershipFunction(Float.parseFloat(A.getText()), Float.parseFloat(B.getText()), Float.parseFloat(C.getText()));
            case Funkcja_Trapezowa -> new TrapezoidalMembershipFunction(Float.parseFloat(A.getText()), Float.parseFloat(B.getText()), Float.parseFloat(C.getText()), Float.parseFloat(D.getText()));
            case Funkcja_Gaussa -> new GaussMembershipFunction(Float.parseFloat(A.getText()), Float.parseFloat(B.getText()));
            default -> null;
        };

        switch(newObjectComboBox.getValue()) {
            case kwantyfikatorów_absolutnych:
                Quantifier q1 = new Quantifier(
                        labelNameField.getText(),
                        membershipFunction,
                        true
                );
                quantifiers.add(q1);
                break;
            case kwantyfikatorów_względnych:
                Quantifier q2 = new Quantifier(
                        labelNameField.getText(),
                        membershipFunction,
                        false
                );
                quantifiers.add(q2);
                break;
            case sumaryzatorów_i_kwalifikatorów:
                Label label = new Label<>(labelNameField.getText(), new FuzzySet<>(membershipFunction));
                variables.stream().filter(v -> v.getColumn().equals(variablesComboBox.getValue()))
                        .findFirst().orElseGet(null).addNewLabel(label);
                break;
        }
        refreshJavaFx();
    }

    @FXML
    private void filterFunctionAttributes() {
        switch(functionComboBox.getValue()) {
            case Funkcja_Gaussa:
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(false);
                D.setVisible(false);
                Ctext.setVisible(false);
                Dtext.setVisible(false);
                break;
            case Funkcja_Trapezowa:
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(true);
                Ctext.setVisible(true);
                Dtext.setVisible(true);
                break;
            case Funkcja_Trójkątna:
                A.setVisible(true);
                B.setVisible(true);
                C.setVisible(true);
                D.setVisible(false);
                Ctext.setVisible(true);
                Dtext.setVisible(false);
                break;
        }
    }
}
