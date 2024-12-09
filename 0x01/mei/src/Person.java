import java.util.Date;
import java.util.Calendar;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    // Construtor
    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    // Método que retorna o nome completo
    public String fullName() {
        return name + " " + surname;
    }

    // Getter e Setter do salário
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Método que calcula o salário anual
    public float calculateYearlySalary() {
        return salary * 12;
    }

    // Método que verifica se é MEI
    public boolean isMEI() {
        float yearlySalary = calculateYearlySalary();
        int age = calculateAge();

        return yearlySalary < 130000 && age > 18 && !anotherCompanyOwner && !pensioner && !publicServer;
    }

    // Método auxiliar para calcular a idade
    private int calculateAge() {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
}
