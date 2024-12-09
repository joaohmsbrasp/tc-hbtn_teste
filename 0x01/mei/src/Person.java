import java.time.LocalDate;

public class Person {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, LocalDate birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public String fullName() {
        return name + " " + surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return salary * 12;
    }

    public boolean isMEI() {
        float yearlySalary = calculateYearlySalary();
        int age = calculateAge();

        return yearlySalary < 130000 && age > 18 && !anotherCompanyOwner && !pensioner && !publicServer;
    }

    private int calculateAge() {
        LocalDate today = LocalDate.now();
        return today.getYear() - birthDate.getYear() - (today.getDayOfYear() < birthDate.getDayOfYear() ? 1 : 0);
    }
}
