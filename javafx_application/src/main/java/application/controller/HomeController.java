package application.controller;

import application.model.StudentHandler;
import application.persistence.Student;
import application.view.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeController implements CustomController{
    private ViewLoader viewLoader;
    private StudentHandler studentHandler;
    @FXML TextField studentIdInput;

    @Autowired
    public HomeController(StudentHandler studentHandler) {
        this.studentHandler = studentHandler;
    }

    @Override
    public void setViewLoader(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @Override
    public void showView() {
        viewLoader.showView(ViewLoader.Views.HOME, this);
    }

    public void showStudentUsingId(){
        Long id = Long.valueOf(studentIdInput.getText());
        Student student = studentHandler.getStudentById(id);
        System.out.println(student);
    }
}
