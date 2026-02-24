public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String name, int age, String studentId, double gpa) {
        super(name, age, studentId, gpa);
    }

    public double calculateTuition() {
        return 5000; // flat rate
    }
}