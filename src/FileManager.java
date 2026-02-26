import java.io.*;
import java.util.List;

public class FileManager {

    // Save data to file
    public static void saveData(List<Student> students, List<Course> courses, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(students);
            out.writeObject(courses);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    public static void loadData(UniversityManager manager, String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Student> students = (List<Student>) in.readObject();
            List<Course> courses = (List<Course>) in.readObject();

            // Add to manager
            for (Student s : students) manager.registerStudent(s);
            for (Course c : courses) manager.createCourse(c);

            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}