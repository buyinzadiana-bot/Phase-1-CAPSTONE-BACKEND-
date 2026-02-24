import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    // Register student
    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("Student registered: " + student.getName());
    }

    // Create course
    public void createCourse(Course course) {
        courses.add(course);
        System.out.println("Course created: " + course.getCourseName());
    }

    // Enroll student in course
    public void enrollStudentInCourse(Student student, Course course)
            throws CourseFullException, StudentAlreadyEnrolledException {

        // Check if already enrolled
        if (course.getStudents().contains(student)) {
            throw new StudentAlreadyEnrolledException("Student already enrolled!");
        }

        // Check if course is full
        if (course.getStudents().size() >= 3) {
            throw new CourseFullException("Course is full!");
        }

        // Enroll student
        course.addStudent(student);
        student.addCourseGrade(course, 0.0);

        System.out.println(student.getName() + " enrolled in " + course.getCourseName());
    }

    // Find top student
    public Student findTopStudent() {
        return students.stream()
                .max(Comparator.comparing(Student::getGpa))
                .orElse(null);
    }

    // ⭐ Calculate average GPA
    public double calculateAverageGpa() {
        return students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0); // return 0.0 if no students
    }
}