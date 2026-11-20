
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("STUDENT MANAGEMENT SYSTEM");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Register Number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        try {

            Student student = new Student(name, regNo, department);

            System.out.println("\n--- STUDENT DETAILS ---");
            System.out.println("Name       : " + student.getName());
            System.out.println("Register No: " + student.getRegisterNumber());
            System.out.println("Department : " + student.getDepartment());

            System.out.println("\nStudent added successfully!");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }

        sc.close();
    }
}
