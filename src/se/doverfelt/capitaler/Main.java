/* © 2014 Rickard Doverfelt */
package se.doverfelt.capitaler;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Capitaler 0.1");
        Scene scene = new Scene(root, Screen.getPrimary().getBounds().getWidth()-250, Screen.getPrimary().getBounds().getHeight() - 250);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.F11) {
                    primaryStage.setFullScreen(!primaryStage.isFullScreen());
                }
                if (keyEvent.isAltDown()) {
                    if (keyEvent.getCode() == KeyCode.U) {
                        ((Controller) loader.getController()).unCapitalize();
                    } else if (keyEvent.getCode() == KeyCode.C) {
                        ((Controller) loader.getController()).capitalize();
                    } else if (keyEvent.getCode() == KeyCode.I) {
                        ((Controller) loader.getController()).invert();
                    }
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
        ((Controller) loader.getController()).initialize();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
