package com.works._10_days;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Dashboard {

    @FXML
    private TextField num1;

    @FXML
    private TextField num2;

    @FXML
    private Button btnCall;

    @FXML
    private Label lblCall;

    public void sum(ActionEvent event) {
        String n1 = num1.getText();
        String n2 = num2.getText();
        try {
            int cn1 = Integer.parseInt(n1);
            int cn2 = Integer.parseInt(n2);
            int sm = cn1 + cn2;
            lblCall.setText(""+sm);
        }catch (Exception ex) {
         lblCall.setText("Number format fail");
        }
        btnCall.setStyle("-fx-background-color: #c96242");
    }

}
