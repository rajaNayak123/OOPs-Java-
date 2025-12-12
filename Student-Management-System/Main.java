import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: // Add Student
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();

                    Student s = new Student(id, name, grade);
                    manager.addStudent(s);
                    break;

                case 2: // Remove
                    System.out.print("Enter student ID to remove: ");
                    int removeId = sc.nextInt();
                    manager.removeStudent(removeId);
                    break;

                case 3: // Search
                    System.out.print("Enter student ID to search: ");
                    int searchId = sc.nextInt();
                    Student result = manager.searchStudent(searchId);

                    if (result != null) {
                        System.out.println("Found: " + result);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4: // Display All
                    manager.displayAll();
                    break;

                case 5: // Exit
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
