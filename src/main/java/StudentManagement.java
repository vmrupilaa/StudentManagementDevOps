
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        try {

            // OPTION 1: ADD STUDENT
            if (choice == 1) {

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Register Number: ");
                String regNo = sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                Student student = new Student(name, regNo, department);

                String sql = "INSERT INTO students " +
                        "(student_name, register_number, department) " +
                        "VALUES (?, ?, ?)";

                try (Connection con = DBConnection.getConnection();
                     PreparedStatement ps = con.prepareStatement(sql)) {

                    ps.setString(1, student.getName());
                    ps.setString(2, student.getRegisterNumber());
                    ps.setString(3, student.getDepartment());

                    ps.executeUpdate();

                    System.out.println("\nStudent saved successfully in MySQL!");
                }

            }

            // OPTION 2: VIEW ALL STUDENTS
            else if (choice == 2) {

                String sql = "SELECT * FROM students ORDER BY student_id";

                try (Connection con = DBConnection.getConnection();
                     PreparedStatement ps = con.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {

                    System.out.println("\n===== STUDENT RECORDS =====");

                    boolean found = false;

                    while (rs.next()) {

                        found = true;

                        System.out.println(
                                rs.getInt("student_id") + " | " +
                                rs.getString("student_name") + " | " +
                                rs.getString("register_number") + " | " +
                                rs.getString("department")
                        );
                    }

                    if (!found) {
                        System.out.println("No student records found!");
                    }
                }

            }

            // OPTION 3: SEARCH STUDENT
            else if (choice == 3) {

                System.out.print("Enter Register Number to search: ");
                String regNo = sc.nextLine();

                String sql = "SELECT * FROM students WHERE register_number = ?";

                try (Connection con = DBConnection.getConnection();
                     PreparedStatement ps = con.prepareStatement(sql)) {

                    ps.setString(1, regNo);

                    try (ResultSet rs = ps.executeQuery()) {

                        if (rs.next()) {

                            System.out.println("\n===== STUDENT FOUND =====");
                            System.out.println("ID         : " + rs.getInt("student_id"));
                            System.out.println("Name       : " + rs.getString("student_name"));
                            System.out.println("Register No: " + rs.getString("register_number"));
                            System.out.println("Department : " + rs.getString("department"));

                        } else {

                            System.out.println("\nStudent not found!");

                        }
                    }
                }

            }

            else {
                System.out.println("Invalid choice!");
            }

        } catch (IllegalArgumentException e) {

            System.out.println("Validation Error: " + e.getMessage());

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());

        } finally {

            sc.close();

        }
    }
}
