package application.model;

import application.persistence.RestClient;
import application.persistence.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentHandler {
    private RestClient restClient;

    @Autowired
    public StudentHandler(RestClient restClient) {
        this.restClient = restClient;
    }

    public Student getStudentById(Long id){
        return restClient.getStudent(id).getBody().getStudent();
    }
}
