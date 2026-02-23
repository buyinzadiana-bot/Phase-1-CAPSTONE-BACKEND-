import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private String studentId;
    private double gpa;

    // Stores courses and grades
    private Map<Course, Double> courseGrades;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = 0.0;
        this.courseGrades = new HashMap<>();
    }

    // Add course and grade
    public void addCourseGrade(Course course, double grade) {
        courseGrades.put(course, grade);
        calculateGPA();
    }

    // Calculate GPA
    private void calculateGPA() {
        double total = 0;
        for (double grade : courseGrades.values()) {
            total += grade;
        }
        if (!courseGrades.isEmpty()) {
            gpa = total / courseGrades.size();
        }
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }
}