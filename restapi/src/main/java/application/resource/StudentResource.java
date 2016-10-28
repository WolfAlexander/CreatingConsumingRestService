package application.resource;

import application.controller.StudentController;
import application.domain.Student;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class StudentResource extends ResourceSupport {
    private final Student student;

    public StudentResource(Student student){
        Long studentId = student.getEid();
        this.student = student;
        this.add(linkTo(StudentController.class, studentId).withRel("students"));
        this.add(linkTo(methodOn(StudentController.class, studentId).getStudentById(studentId)).withSelfRel());
    }

    public Student getStudent(){
        return student;
    }
}
