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
        calendar.set(2000, Calendar.JANUARY, 1); // Configurando a data de nascimento para 01/01/2000
        Date birthDate = calendar.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        // Verifica se o método fullName retorna o nome completo correto
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        // Configura salário mensal e verifica se o cálculo do salário anual está correto
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        // Altera atributos para um cenário válido para ser MEI
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();
        
        Person validPerson = new Person("John", "Lennon", birthDate, false, false, false);
        validPerson.setSalary(1000);

        assertTrue(validPerson.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Configura cenário inválido (ou salário acima do limite, ou pessoa com características impeditivas)
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();

        Person invalidPerson = new Person("George", "Harrison", birthDate, true, true, true);
        invalidPerson.setSalary(15000);

        assertFalse(invalidPerson.isMEI());
    }
}
