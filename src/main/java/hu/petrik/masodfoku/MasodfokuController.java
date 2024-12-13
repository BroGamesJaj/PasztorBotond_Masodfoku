package hu.petrik.masodfoku;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class MasodfokuController {
    @FXML
    private Label resultText;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;

    @FXML
    private void initialize() {
        resultText.setText("x1 = \nx2 = ");
        input1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Csak számot adhat meg!");
                    alert.showAndWait();
                    input1.setText(input1.getText().substring(0, input1.getText().length() - 1));
                }
            }
        });
        input2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Csak számot adhat meg!");
                    alert.showAndWait();
                    input2.setText(input2.getText().substring(0, input2.getText().length() - 1));
                }
            }
        });
        input3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("Csak számot adhat meg!");
                    alert.showAndWait();
                    input3.setText(input3.getText().substring(0, input3.getText().length() - 1));
                }
            }
        });
    }

    @FXML
    protected void onCalcClick() {

        if(Objects.equals(input1.getText(), "") || Objects.equals(input2.getText(), "") || Objects.equals(input3.getText(), "")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Mind a három bemeneti mezőben kell számnak szerepelnie!");
            alert.showAndWait();
        }else{
            double a = Double.parseDouble(input1.getText());
            double b = Double.parseDouble(input2.getText());
            double c = Double.parseDouble(input3.getText());

            double root1, root2;

            // calculate the discriminant (b2 - 4ac)
            double discriminant = b * b - 4 * a * c;

            // check if discriminant is greater than 0
            if (discriminant > 0) {

                // two real and distinct roots
                root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                resultText.setText("x1 = " + root1 + "\nx2 = " + root2);
            }

            // check if discriminant is equal to 0
            else if (discriminant == 0) {

                // two real and equal roots
                // discriminant is equal to 0
                // so -b + 0 == -b
                root1 = root2 = -b / (2 * a);
                resultText.setText("x1 = x2 = " + root1);
            } else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Nem oldható meg a valós számok halmazán");
                alert.showAndWait();
            }
        }


    }
}