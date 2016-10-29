package application.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class Student {
    @JsonProperty("enamn")
    private String enamn;
    @JsonProperty("adress")
    private String adress;
    @JsonProperty("postnr")
    private String postnr;
    @JsonProperty("ort")
    private String ort;
    @JsonProperty("etel")
    private String etel;
}
