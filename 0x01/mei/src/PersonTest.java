import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1); // Data de nascimento: 01/01/2000
        Date birthDate = calendar.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        // Configura pessoa para ser válida como MEI
        person = new Person("John", "Lennon", new Date(100, 0, 1), false, false, false);
        person.setSalary(1000); // Salário mensal: 1000

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Configura pessoa para não ser válida como MEI
        person = new Person("George", "Harrison", new Date(100, 0, 1), true, true, true);
        person.setSalary(15000); // Salário anual será maior que 130000

        assertFalse(person.isMEI());
    }
}
