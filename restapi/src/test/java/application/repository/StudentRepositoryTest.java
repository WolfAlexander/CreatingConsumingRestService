package application.repository;

import application.RestApiApplication;
import application.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
/*TODO: Find an alternative to @SpringApplicationConfiguration*/
@SpringApplicationConfiguration(RestApiApplication.class)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;

    @Test
    public void testFindOne() throws Exception{
        Student student = this.repository.findOne(1L);
        assertEquals((Long)1L, student.getEid());
        assertEquals("Bo Dahl", student.getEnamn());
        assertEquals("Ahlgatan 6", student.getAdress());
        assertEquals("16102", student.getPostnr());
        assertEquals("Bromma", student.getOrt());
        assertEquals("163578", student.getEtel());
    }

}
