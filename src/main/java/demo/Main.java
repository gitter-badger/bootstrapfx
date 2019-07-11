package demo;

import demo.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Wasula Benjamin
 */
public class Main extends Application {
    private static final Rectangle2D SCREEN_BOUNDS= Screen.getPrimary().getVisualBounds();
    private static double[] offset_XY;

    @Override public void start(Stage stage) throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("/view/GeneralUI.fxml"));

        root.setOnMousePressed( p-> offset_XY= new double[]{p.getSceneX(), p.getSceneY()});
        root.setOnMouseDragged(d-> {
            if (d.getScreenY()<(SCREEN_BOUNDS.getMaxY()-20)) stage.setY(d.getScreenY() - offset_XY[1]);
            stage.setX(d.getScreenX() - offset_XY[0]);
        });
        root.setOnMouseReleased(r-> {if (stage.getY()<0.0) stage.setY(0.0);});

        Controller.primaryStage= stage;

        stage.getIcons().add(new Image(getClass().getResourceAsStream(
                "/assets/img/icons8_color_palette_32px.png"
        )));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.setTitle("BootstrapFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}