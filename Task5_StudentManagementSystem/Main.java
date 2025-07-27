import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    String roll = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    if (name.isEmpty() || roll.isEmpty() || grade.isEmpty()) {
                        System.out.println("All fields are required.");
                        break;
                    }

                    sms.addStudent(new Student(name, roll, grade));
                    System.out.println("Student added.");
                    break;

                case "2":
                    System.out.print("Enter Roll Number to remove: ");
                    String rollToRemove = scanner.nextLine();
                    sms.removeStudent(rollToRemove);
                    System.out.println("Student removed (if found).");
                    break;

                case "3":
                    System.out.print("Enter Roll Number to search: ");
                    String rollToSearch = scanner.nextLine();
                    Student found = sms.searchStudent(rollToSearch);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case "4":
                    sms.displayAllStudents();
                    break;

                case "5":
                    System.out.print("Enter Roll Number to edit: ");
                    String rollToEdit = scanner.nextLine();
                    Student studentToEdit = sms.searchStudent(rollToEdit);
                    if (studentToEdit != null) {
                        System.out.print("Enter new name (leave blank to keep current): ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new grade (leave blank to keep current): ");
                        String newGrade = scanner.nextLine();

                        if (!newName.isEmpty()) studentToEdit.setName(newName);
                        if (!newGrade.isEmpty()) studentToEdit.setGrade(newGrade);
                        sms.saveToFile();
                        System.out.println("Student updated.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case "6":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
