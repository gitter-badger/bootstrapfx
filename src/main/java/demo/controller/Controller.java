package demo.controller;

import com.github.wasulabenjamin.bootstrapfx.BootstrapFX;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BootstrapFX implements Initializable {
    public static Stage primaryStage;

    @FXML private AnchorPane login_pane;
    @FXML private Label err_msg, forgot_pass;
    @FXML private TextField login_id;
    @FXML private PasswordField login_pass;
    @FXML private JFXCheckBox keep_loggedin;
    @FXML private JFXButton btn_cancel, btn_login;

    @FXML private AnchorPane main_pane;
    @FXML private Button btn_out, btn_min, btn_clz;

    @FXML private JFXButton typos, bttns, forms, views;
    @FXML private AnchorPane typos_pane, bttns_pane, forms_pane, views_pane;
    @FXML private ScrollPane typos_view, bttns_view, forms_view, views_view;

    @Override public void initialize(URL location, ResourceBundle resources) {
        typos_pane.toFront();

        keep_loggedin.setOnAction(event -> {
            //TODO: Add implementation here
        });

        btn_login.setOnAction(event -> {
            if (isValid(login_id, login_pass)) {
                //TODO: Add implementation here
                main_pane.toFront();
            }
        });

        forgot_pass.setOnMouseClicked(event -> {
            //TODO: Add implementation here
        });
    }

    @FXML void windowControl(ActionEvent event) {
        if (event.getSource()==btn_clz || event.getSource()==btn_cancel) System.exit(0);
        if (event.getSource()==btn_min) primaryStage.setIconified(true);
        if (event.getSource()==btn_out) login_pane.toFront();
    }

    @FXML void navigationControl(ActionEvent event) {
        ((Group)((Button)event.getSource()).getParent()).getChildren().forEach(
                node-> (node).getStyleClass().removeAll("ctrl-selected")
        );
        ((Button)event.getTarget()).getStyleClass().add("ctrl-selected");

        if (event.getSource()==typos) typos_pane.toFront();
        if (event.getSource()==bttns) bttns_pane.toFront();
        if (event.getSource()==forms) forms_pane.toFront();
        if (event.getSource()==views) views_pane.toFront();
    }
}