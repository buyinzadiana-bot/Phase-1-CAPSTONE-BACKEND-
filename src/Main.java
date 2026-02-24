public class Main {
    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();

        Student s1 = new Student("Alice", 20, "S001", 3.8);
        Student s2 = new Student("Bob", 22, "S002", 3.5);

        Course c1 = new Course("Java Programming", 3);

        manager.registerStudent(s1);
        manager.registerStudent(s2);

        manager.createCourse(c1);

        try {
            manager.enrollStudentInCourse(s1, c1);
            manager.enrollStudentInCourse(s2, c1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Top Student: " + manager.findTopStudent().getName());
        System.out.println("Average GPA: " + manager.calculateAverageGpa());
    }
}