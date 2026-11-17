import java.util.ArrayList;
import java.util.Scanner;

// Student class representing individual student details
class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course;
    }
}

// Main Student Management System class
public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 5.");
            }
            System.out.println();
        } while (choice != 5);
        
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    private static void addStudent() {
        int id = getIntInput("Enter Student ID: ");
        
        // Check if ID already exists
        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.println("Error: A student with ID " + id + " already exists!");
                return;
            }
        }

        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        int age = getIntInput("Enter Student Age: ");
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        studentList.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("--- Student Records ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
OAOAOA
OAOAOA    private static void searchStudent() {
        int id = getIntInput("Enter Student ID to search: ");
        boolean found = false;

        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.println("Student Found:\n" + student);
                found = true;
                break;
            }
        }

        if (!found) {
OAOAOA            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void deleteStudent() {
        int id = getIntInput("Enter Student ID to delete: ");
        boolean removed = studentList.removeIf(student -> student.getId() == id);

        if (removed) {
            System.out.println("Student record deleted successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Helper method to safely read integers and handle incorrect inputs
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
}
