
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

        System.out.println("\n--- STUDENT DETAILS ---");
        System.out.println("Name       : " + name);
        System.out.println("Register No: " + regNo);
        System.out.println("Department : " + department);

        System.out.println("\nStudent details added successfully!");

        sc.close();
    }
}
