package application.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Specification of the student in database
 */
@Entity
@Table(name = "elev")
@Getter
@EqualsAndHashCode(callSuper = false)
public class Student{
    @Id
    @GeneratedValue
    private Long eid;
    @NotNull
    private String enamn;
    private String adress;
    private String postnr;
    private String ort;
    private String etel;

    /**
     * Jpa required
     */
    Student(){}

    public Student(String enamn, String adress, String postnr, String ort, String etel) {
        this.enamn = enamn;
        this.adress = adress;
        this.postnr = postnr;
        this.ort = ort;
        this.etel = etel;
    }
}