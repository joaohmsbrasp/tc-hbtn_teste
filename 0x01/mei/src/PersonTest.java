import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        // Configurando uma pessoa base que não deve se qualificar como MEI
        person = new Person("Paul", "McCartney", LocalDate.of(2000, 1, 1), true, true, true);
    }

    @Test
    public void show_full_name() {
        // Verificando se o método fullName retorna o nome completo correto
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        // Configurando pessoa com todas as condições válidas para ser MEI
        Person validPerson = new Person("John", "Lennon", LocalDate.of(1990, 1, 1), false, false, false);
        validPerson.setSalary(1000); // Salário mensal: 1000

        assertTrue(validPerson.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Configurando pessoa com várias condições que a impedem de ser MEI
        Person invalidPerson = new Person("George", "Harrison", LocalDate.of(1990, 1, 1), true, true, true);
        invalidPerson.setSalary(15000);

        assertFalse(invalidPerson.isMEI());
    }

    @Test
    public void person_is_not_MEI_due_to_salary() {
        // Configurando pessoa com salário acima do limite para ser MEI
        Person invalidSalaryPerson = new Person("Ringo", "Starr", LocalDate.of(1985, 3, 15), false, false, false);
        invalidSalaryPerson.setSalary(12000);

        assertFalse(invalidSalaryPerson.isMEI());
    }
}
