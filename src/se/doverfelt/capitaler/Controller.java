package se.doverfelt.capitaler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class Controller extends GridPane {

    @FXML
    public TextArea input;
    @FXML
    public TextArea output;

    @FXML
    public Button unc;
    @FXML
    public Button cap;
    @FXML
    public Button inv;

    public void initialize() {
    }

    @FXML
    public void unCapitalize() {
        output.setText(input.getText().toLowerCase());
    }

    @FXML
    public void capitalize() {
        output.setText(input.getText().toUpperCase());
    }

    @FXML
    public void invert() {
        char[] inputText = input.getText().toCharArray();
        StringBuilder out = new StringBuilder();
        for (char c : inputText) {
            if (Character.isUpperCase(c)) {
                out.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                out.append(Character.toUpperCase(c));
            } else {
                out.append(c);
            }
        }
        output.setText(out.toString());
    }

}
