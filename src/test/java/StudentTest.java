
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testStudentName() {

        Student student = new Student(
            "Arun", "101", "Computer Engineering"
        );

        assertEquals("Arun", student.getName());
    }

    @Test
    public void testRegisterNumber() {

        Student student = new Student(
            "Arun", "101", "Computer Engineering"
        );

        assertEquals("101", student.getRegisterNumber());
    }

    @Test
    public void testDepartment() {

        Student student = new Student(
            "Arun", "101", "Computer Engineering"
        );

        assertEquals("Computer Engineering",
                     student.getDepartment());
    }

    @Test
    public void testEmptyStudentName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Student("", "101", "Computer Engineering");
        });
    }
}
