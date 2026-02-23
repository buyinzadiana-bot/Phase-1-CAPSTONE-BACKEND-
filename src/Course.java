import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int credits;

    private List<Student> students;

    public Course(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
        this.students = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Getters
    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public List<Student> getStudents() {
        return students;
    }
}