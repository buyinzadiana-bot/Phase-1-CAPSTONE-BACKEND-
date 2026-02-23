public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String name, int age, String studentId) {
        super(name, age, studentId);
    }

    public double calculateTuition() {
        return 5000; // flat rate
    }
}