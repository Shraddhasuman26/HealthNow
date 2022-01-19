package employees;

public class Employees {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
//    private double salary;

    public Employees(int id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
//        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

//    public double getSalary() {
//        return salary;
//    }
}
