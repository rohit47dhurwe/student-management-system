import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {
    // ArrayList to store our students - this is our "database" for now
    private static ArrayList<Student> students = new ArrayList<>();
    private static int nextId = 1; // To automatically generate student IDs

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            // Handle the user's choice
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // METHOD TO ADD A NEW STUDENT
    private static void addStudent(Scanner scanner) {
        System.out.println("\n--- Add New Student ---");

        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();

        // Create new student object
        Student newStudent = new Student(nextId, name, age, marks);
        students.add(newStudent);

        System.out.println("✅ Student added successfully! ID: " + nextId);
        nextId++; // Increase ID for next student
    }

    // METHOD TO VIEW ALL STUDENTS
    private static void viewAllStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found. The list is empty.");
        } else {
            for (Student student : students) {
                student.displayInfo();
            }
            System.out.println("Total students: " + students.size());
        }
    }

    // METHOD TO UPDATE STUDENT INFORMATION
    private static void updateStudent(Scanner scanner) {
        System.out.println("\n--- Update Student ---");

        if (students.isEmpty()) {
            System.out.println("No students to update. The list is empty.");
            return;
        }

        // First, show all students so user can see IDs
        viewAllStudents();

        System.out.print("Enter the ID of student to update: ");
        int id = scanner.nextInt();

        // Find the student with this ID
        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToUpdate = student;
                break;
            }
        }

        if (studentToUpdate == null) {
            System.out.println("❌ Student with ID " + id + " not found!");
            return;
        }

        scanner.nextLine(); // Clear buffer

        System.out.println("Updating student: ");
        studentToUpdate.displayInfo();

        System.out.print("Enter new name (current: " + studentToUpdate.getName() + "): ");
        String newName = scanner.nextLine();

        System.out.print("Enter new age (current: " + studentToUpdate.getAge() + "): ");
        int newAge = scanner.nextInt();

        System.out.print("Enter new marks (current: " + studentToUpdate.getMarks() + "): ");
        double newMarks = scanner.nextDouble();

        // Update the student - we need to add setters to Student class!
        studentToUpdate.setName(newName);
        studentToUpdate.setAge(newAge);
        studentToUpdate.setMarks(newMarks);

        System.out.println("✅ Student updated successfully!");
    }

    // METHOD TO DELETE A STUDENT
    private static void deleteStudent(Scanner scanner) {
        System.out.println("\n--- Delete Student ---");

        if (students.isEmpty()) {
            System.out.println("No students to delete. The list is empty.");
            return;
        }

        // First, show all students so user can see IDs
        viewAllStudents();

        System.out.print("Enter the ID of student to delete: ");
        int id = scanner.nextInt();

        // Find the student with this ID
        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete == null) {
            System.out.println("❌ Student with ID " + id + " not found!");
            return;
        }

        System.out.println("About to delete this student: ");
        studentToDelete.displayInfo();

        System.out.print("Are you sure? (1 for YES, 0 for NO): ");
        int confirm = scanner.nextInt();

        if (confirm == 1) {
            students.remove(studentToDelete);
            System.out.println("✅ Student deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}