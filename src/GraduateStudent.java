public class GraduateStudent extends Student {

    public GraduateStudent(String name, int age, String studentId) {
        super(name, age, studentId);
    }

    public double calculateTuition() {
        return getCourseGrades().size() * 1000 + 2000;
    }
}