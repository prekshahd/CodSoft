import java.util.Scanner;
public class StudentGradeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) 
        {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            while (marks < 0 || marks > 100) 
            {
                System.out.print("Invalid input! Marks should be between 0 and 100. Try again: ");
                marks = scanner.nextInt();
            }

            totalMarks += marks;
        }
        double average = (double) totalMarks / numSubjects;
        String grade;
        if (average >= 90) 
        {
            grade = "A+";
        } 
        else if (average >= 80) 
        {
            grade = "A";
        } 
        else if (average >= 70) 
        {
            grade = "B";
        } 
        else if (average >= 60) 
        {
            grade = "C";
        } 
        else if (average >= 50) 
        {
            grade = "D";
        } 
        else 
        {
            grade = "F";
        }
        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
