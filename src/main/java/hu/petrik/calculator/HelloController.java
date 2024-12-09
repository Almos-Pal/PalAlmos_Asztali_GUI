package hu.petrik.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private Button plusId;
    @FXML
    private Button minusId;
    @FXML
    private Button percentageDivisionId;
    @FXML
    private Label resultId;
    @FXML
    private Spinner seondInputId;
    @FXML
    private Spinner firstInputId;
    @FXML
    private GridPane gridId;
    @FXML
    private Button multiplicationId;
    @FXML
    private Button divisionId;


    public boolean CheckIfZero() {
        int firstInput = (int) firstInputId.getValue();
        int secondInput = (int) seondInputId.getValue();
        if (secondInput == 0) {
            return true;
        }
            return false;
    }

    public void initialize() {


        firstInputId.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
        seondInputId.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
    }

    @FXML
    public void onPlus(ActionEvent actionEvent) {
        int firstInput = (int) firstInputId.getValue();
        int secondInput = (int) seondInputId.getValue();
        int result = firstInput + secondInput;
        resultId.setText(String.valueOf(result));
    }

    @FXML
    public void onMinus(ActionEvent actionEvent) {
        CheckIfZero();
        int firstInput = (int) firstInputId.getValue();
        int secondInput = (int) seondInputId.getValue();
        int result = firstInput - secondInput;
        resultId.setText(String.valueOf(result));
    }

    @FXML
    public void onMulti(ActionEvent actionEvent) {
        int firstInput = (int) firstInputId.getValue();
        int secondInput = (int) seondInputId.getValue();
        int result = firstInput * secondInput;
        resultId.setText(String.valueOf(result));

    }

    @FXML
    public void onPerDiv(ActionEvent actionEvent) {
        if (CheckIfZero()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cannot divide by zero");
            alert.showAndWait();
            return;
        }
        int firstInput = (int) firstInputId.getValue();
        int secondInput = (int) seondInputId.getValue();
        int result = firstInput % secondInput;
        resultId.setText(String.valueOf(result));

    }

    @FXML
    public void onDiv(ActionEvent actionEvent) {

        if (CheckIfZero()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cannot divide by zero");
            alert.showAndWait();
            return;

        }

        int firstInput = (int) firstInputId.getValue();
        int secondInput = (int) seondInputId.getValue();
        double result = (double) firstInput / secondInput;
        resultId.setText(String.format("%.2f", result));

    }
}