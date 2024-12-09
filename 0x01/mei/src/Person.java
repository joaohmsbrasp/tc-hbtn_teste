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

    // Método para retornar o nome completo
    public String fullName() {
        return name + " " + surname;
    }

    // Getter e Setter para o salário
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Calcula o salário anual multiplicando o salário mensal por 12
    public float calculateYearlySalary() {
        return salary * 12;
    }

    // Método para verificar se a pessoa é MEI
    public boolean isMEI() {
        int age = calculateAge();
        return (calculateYearlySalary() < 130000) && age > 18 && !anotherCompanyOwner && !pensioner && !publicServer;
    }

    // Calcula a idade da pessoa com base na data de nascimento
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
