package demo.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Buttons implements Initializable {
    @FXML private ToggleGroup toggle_1, radio_1;
    @FXML private ChoiceBox<String> names;

    @Override public void initialize(URL location, ResourceBundle resources) {
        //TODO: Check on how to add prompt-text
        //TODO: Add names from sqlite Database (Fruits)
        names.setItems(FXCollections.observableArrayList("James", "Cindy", "Benjah", "Brian", "Mercy"));
    }
}