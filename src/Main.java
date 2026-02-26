import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        FileManager.loadData(manager, "data.dat"); // load previous data

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== UNIVERSITY MENU ===");
            System.out.println("1. Register Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. View Student Record");
            System.out.println("4. Dean's List");
            System.out.println("5. Save & Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Register Student
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

                    Student s = new Student(name, age, id, gpa);
                    manager.registerStudent(s);
                    break;

                case 2: // Enroll in Course
                    System.out.print("Enter student ID: ");
                    String sid = scanner.nextLine();
                    Student student = manager.findStudentById(sid);

                    System.out.print("Enter course name: ");
                    String cname = scanner.nextLine();
                    Course course = manager.findCourseByName(cname);

                    if (student != null && course != null) {
                        try {
                            manager.enrollStudentInCourse(student, course);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Student or course not found!");
                    }
                    break;

                case 3: // View Record
                    System.out.print("Enter student ID: ");
                    String sid2 = scanner.nextLine();
                    Student sRec = manager.findStudentById(sid2);
                    if (sRec != null) {
                        System.out.println("Student: " + sRec.getName());
                        System.out.println("GPA: " + sRec.getGpa());
                        System.out.println("Courses: " + sRec.getCourseGrades().keySet());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4: // Dean's List
                    System.out.println("=== Dean's List ===");
                    for (Student st : manager.getStudents()) {
                        if (st.getGpa() >= 3.5) {
                            System.out.println(st.getName() + " - GPA: " + st.getGpa());
                        }
                    }
                    break;

                case 5: // Save & Exit
                    FileManager.saveData(manager.getStudents(), manager.getCourses(), "data.dat");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }
}