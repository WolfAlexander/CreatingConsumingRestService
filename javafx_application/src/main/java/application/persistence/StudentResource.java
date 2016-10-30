package application.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class StudentResource{



    private Student student;

    @JsonProperty("_links")
    private Map<String, Object> links = new HashMap<String, Object>();

    StudentResource(){}


}