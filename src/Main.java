import java.util.List;

public class Main {
    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();

        // 🔹 Load previous data (if exists)
        FileManager.loadData(manager, "data.dat");

        // 🔹 Create students
        Student s1 = new UndergraduateStudent("Alice", 20, "S001", 3.8);
        Student s2 = new GraduateStudent("Bob", 24, "S002", 3.5);

        // 🔹 Create courses
        Course c1 = new Course("Java Programming", 3);
        Course c2 = new Course("Data Structures", 4);

        // 🔹 Register students
        manager.registerStudent(s1);
        manager.registerStudent(s2);

        // 🔹 Create courses
        manager.createCourse(c1);
        manager.createCourse(c2);

        // 🔹 Enroll students
        try {
            manager.enrollStudentInCourse(s1, c1);
            manager.enrollStudentInCourse(s2, c1);
            manager.enrollStudentInCourse(s2, c2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 🔹 Display student info
        System.out.println("\n=== STUDENT RECORDS ===");
        for (Student s : manager.getStudents()) {
            System.out.println("Name: " + s.getName());
            System.out.println("GPA: " + s.getGpa());
            System.out.println("Courses: " + s.getCourseGrades().keySet());
            System.out.println("----------------------");
        }

        // 🔹 Top student
        Student topStudent = manager.findTopStudent();
        if (topStudent != null) {
            System.out.println("🏆 Top Student: " + topStudent.getName());
        }

        // 🔹 Average GPA
        System.out.println("📊 Average GPA: " + manager.calculateAverageGpa());

        // 🔹 Dean's List (extra marks feature ⭐)
        System.out.println("\n=== DEAN'S LIST (GPA >= 3.5) ===");
        for (Student s : manager.getStudents()) {
            if (s.getGpa() >= 3.5) {
                System.out.println(s.getName() + " - GPA: " + s.getGpa());
            }
        }

        // 🔹 Save data before exit
        FileManager.saveData(manager.getStudents(), manager.getCourses(), "data.dat");

        System.out.println("\nProgram finished successfully!");
    }
}