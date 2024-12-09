import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        LocalDate birthDate = LocalDate.of(2000, 1, 1); // Data de nascimento: 01/01/2000
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
        LocalDate birthDate = LocalDate.of(1990, 1, 1); // Data de nascimento: 01/01/1990
        person = new Person("John", "Lennon", birthDate, false, false, false);
        person.setSalary(1000); // Salário mensal: 1000

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Configura pessoa para não ser válida como MEI
        LocalDate birthDate = LocalDate.of(1990, 1, 1); // Data de nascimento: 01/01/1990
        person = new Person("George", "Harrison", birthDate, true, true, true);
        person.setSalary(15000); // Salário anual será maior que 130000

        assertFalse(person.isMEI());
    }
}
