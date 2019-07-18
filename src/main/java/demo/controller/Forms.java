package demo.controller;

import com.github.wasulabenjamin.bootstrapfx.BootstrapFX;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.ResourceBundle;

public class Forms extends BootstrapFX implements Initializable {
    @FXML private JFXTextField usr_name;
    @FXML private JFXPasswordField usr_pass;
    @FXML private JFXButton submit;

    @FXML private PasswordField ent_pass;
    @FXML private PasswordField conf_pass;
    @FXML private JFXButton pw_submit;

    @FXML private JFXTextField em_name;
    @FXML private JFXPasswordField em_pass;
    @FXML private JFXButton em_submit;

    @FXML private Hyperlink rfc_5322;

    @Override public void initialize(URL location, ResourceBundle resources) {
        submit.setOnAction(event -> isValid(usr_name, usr_pass));

        pw_submit.setOnAction(event -> {if (isValid(ent_pass, conf_pass)) {
            if (!ent_pass.getText().equals(conf_pass.getText()))
                setInvalid(conf_pass, "Passwords do no match");
        }});

        em_submit.setOnAction(event -> isValid(em_name, em_pass));

        rfc_5322.setOnAction(event -> openHyperlink("https://en.wikipedia.org/wiki/Email_address#Local-part"));
    }
}