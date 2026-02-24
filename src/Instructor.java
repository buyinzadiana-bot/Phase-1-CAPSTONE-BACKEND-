public class Instructor extends Person {
    private String department;

    public Instructor(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public double calculateTuition() {
        return 0.0; // instructors don't pay tuition
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}