import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static List<Enrollment> enrollments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Course Management System!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new course");
            System.out.println("3. Enroll a student in a course");
            System.out.println("4. Display all students");
            System.out.println("5. Display all courses");
            System.out.println("6. Display all enrollments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudent();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    displayCourses();
                    break;
                case 6:
                    displayEnrollments();
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student newStudent = new Student(id, name);
        students.add(newStudent);
        System.out.println("Student added successfully: " + newStudent);
    }

    private static void addCourse() {
        System.out.print("Enter course ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter max capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Course newCourse = new Course(id, name, capacity);
        courses.add(newCourse);
        System.out.println("Course added successfully: " + newCourse);
    }

    private static void enrollStudent() {
        System.out.print("Enter student ID to enroll: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course ID to enroll in: ");
        String courseId = scanner.nextLine();

        Student studentToEnroll = findStudentById(studentId);
        Course courseToEnrollIn = findCourseById(courseId);

        if (studentToEnroll != null && courseToEnrollIn != null) {
            Enrollment newEnrollment = new Enrollment(studentToEnroll, courseToEnrollIn);
            enrollments.add(newEnrollment);
            System.out.println("Enrollment successful: " + newEnrollment);
        } else {
            System.out.println("Error: Student or Course not found.");
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        System.out.println("--- All Students ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses in the system.");
            return;
        }
        System.out.println("--- All Courses ---");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void displayEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments in the system.");
            return;
        }
        System.out.println("--- All Enrollments ---");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    // Helper methods to find objects by ID
    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseById(String id) {
        for (Course course : courses) {
            if (course.getCourseId().equals(id)) {
                return course;
            }
        }
        return null;
    }
}
