package com.works._10_days;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class UseList {

    // List
    @FXML
    private ListView listViewCity;

    // radio
    @FXML
    private RadioButton radioYes, radioNo, radioCancel;

    String[] city = {"Ankara", "İstanbul", "İzmir", "Samsun", "Adana"};

    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3;

    @FXML
    private ChoiceBox choiceBoxCity;

    @FXML
    private ComboBox comboBoxCity;

    @FXML
    private Button btnDataSource, btnSelectItem;
    
    public void fncDataSource(ActionEvent event) {
        List<String> ls = Arrays.asList(city);
        comboBoxCity.setItems(FXCollections.observableList(ls));
        comboBoxCity.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(o);
                System.out.println(t1);
            }
        });
        choiceBoxCity.setItems(FXCollections.observableList(ls));

        listViewCity.setItems(FXCollections.observableList(ls));
        // listView Select
        listViewCity.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(o);
                System.out.println(t1);
            }
        });
    }

    public void fncSelectItem(ActionEvent event) {
       int index = comboBoxCity.getSelectionModel().getSelectedIndex();
       if ( index > -1 ) {
           System.out.println(city[index]);
       }else {

       }

        // checkBox status
        boolean s1 = checkBox1.isSelected();
        boolean s2 = checkBox2.isSelected();
        boolean s3 = checkBox3.isSelected();
        System.out.println(s1 + " " + s2 + " " + s3);

        int selectIndex = listViewCity.getSelectionModel().getSelectedIndex();
        System.out.println(selectIndex);
    }


}
