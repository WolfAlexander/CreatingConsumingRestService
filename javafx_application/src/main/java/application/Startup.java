package application;

import application.configuration.AppConfig;
import application.configuration.ViewConfig;
import application.model.StudentHandler;
import application.view.ViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Startup extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, ViewConfig.class);
        ViewConfig viewConfig = context.getBean(ViewConfig.class);
        viewConfig.setPrimaryStage(primaryStage);

        ViewLoader viewLoader = context.getBean(ViewLoader.class);
        StudentHandler studentHandler = context.getBean(StudentHandler.class);
        viewConfig.homeStageController(viewLoader, studentHandler).showView();
    }
}
