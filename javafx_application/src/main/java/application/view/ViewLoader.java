package application.view;

import application.controller.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * This class handles views - loads FXML, sets controllers and shows in primary stage
 */
public class ViewLoader {
    private HashMap<Views, URL> viewToFXML = new HashMap<Views, URL>();
    private final int WIDTH = 1024;
    private final int HEIGHT = 756;
    private Stage primaryStage;

    public enum Views{
        HOME
    }

    public ViewLoader(Stage primaryStage) {
        this.primaryStage = primaryStage;

        viewToFXML.put(Views.HOME, getClass().getResource("/home.fxml"));
    }

    public void showView(Views view, HomeController controller){
        showScene(getScene(view, controller));
    }

    private Scene getScene(Views view, HomeController controller){
        try {
            FXMLLoader loader = new FXMLLoader(viewToFXML.get(view));
            setController(loader, controller);
            Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);
            scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toString());
            return scene;
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void showScene(Scene scene){
        primaryStage.setScene(scene);

        if(!primaryStage.isShowing())
            primaryStage.show();
    }

    private void setController(FXMLLoader loader, final HomeController controller){
        loader.setControllerFactory(param -> controller);
    }
}
