package application;

import application.model.Student;
import application.model.StudentResource;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class Startup extends Application {
    public static void main(String[] args) {
        //launch();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Resource<StudentResource>> responseEntity = restTemplate.exchange("http://localhost:8000/students/1", HttpMethod.GET, null, new ParameterizedTypeReference<Resource<StudentResource>>() {}, Collections.emptyMap());
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            Resource<StudentResource> studentResource = responseEntity.getBody();
            System.out.println(responseEntity.getHeaders());
            System.out.println(studentResource.toString());
           /* Student student = studentResource.getContent();
            List<Link> links = studentResource.getLinks();
            System.out.println(student);*/
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
