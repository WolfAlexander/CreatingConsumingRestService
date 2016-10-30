package application.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
    private final RestTemplate restTemplate;
    private final String STUDENT_INFORMATION_SERVER_LOCATION = "http://localhost:8000/students/";

    @Autowired
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<StudentResource> getStudent(Long id){
        return restTemplate.getForEntity(STUDENT_INFORMATION_SERVER_LOCATION + id, StudentResource.class);
    }
}
