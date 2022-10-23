package com.works._10_days;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends Application {

    @FXML
    private TextField txtData;

    @FXML
    private Label lblData;


    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        String data = txtData.getText();
        lblData.setText(data);
        if ( data.equals("can") ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Can Uyarı");
            alert.setContentText("Can Java Uyarısı");
            //alert.show();

            FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource("dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            // mevcut sahneyi öldür
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        if ( data.equals("list") ) {
            FXMLLoader fxmlLoader = new FXMLLoader(Dashboard.class.getResource("UseList.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            // mevcut sahneyi öldür
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start call");
        txtData.setText("list");
    }
}