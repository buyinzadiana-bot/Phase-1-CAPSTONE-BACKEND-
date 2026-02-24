public class GraduateStudent extends Student {

    public GraduateStudent(String name, int age, String studentId, double gpa) {
        super(name, age, studentId,gpa);
    }

    public double calculateTuition() {
        return getCourseGrades().size() * 1000 + 2000;
    }
}