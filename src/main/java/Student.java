
public class Student {

    private String name;
    private String registerNumber;
    private String department;

    public Student(String name, String registerNumber,
                   String department) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }

        if (registerNumber == null || registerNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Register number cannot be empty");
        }

        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }

        this.name = name;
        this.registerNumber = registerNumber;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getDepartment() {
        return department;
    }
}
