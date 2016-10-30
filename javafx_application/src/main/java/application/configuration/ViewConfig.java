package application.configuration;

import application.controller.HomeController;
import application.model.StudentHandler;
import application.view.ViewLoader;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@Import({AppConfig.class})
public class ViewConfig {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Bean
    public ViewLoader viewLoader(){
        return new ViewLoader(primaryStage);
    }

    @Bean
    public HomeController homeStageController(ViewLoader viewLoader, StudentHandler studentHandler){
        HomeController controller = new HomeController(studentHandler);
        controller.setViewLoader(viewLoader);

        return controller;
    }
}
