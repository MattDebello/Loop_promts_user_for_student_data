import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentDataEntry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Student> studentList = new LinkedList<>();

        // Prompt the user for student data entry
        while (true) {
            System.out.println("Enter student data or type 'exit' to finish:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Address: ");
            String address = scanner.nextLine();

            double GPA;
            while (true) {
                System.out.print("GPA: ");
                String input = scanner.nextLine();
                try {
                    GPA = Double.parseDouble(input);
                    // Validate GPA
                    if (GPA >= 0 && GPA <= 4.0) {
                        break;
                    } else {
                        System.out.println("Invalid GPA. GPA must be between 0 and 4.0.");

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numeric GPA.");

                }
            }

            // Create a new Student object and add it to the linked list
            studentList.add(new Student(name, address, GPA));

        }
        // Sort the linked list by name using an ArrayList
        ArrayList<Student> studentArrayList = new ArrayList<>(studentList);


        // Output the contents of the sorted ArrayList to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_data.txt"))) {
            for (Student student : studentArrayList) {
                writer.write("Name: " + student.getName() + "\n");
                writer.write("Address: " + student.getAddress() + "\n");
                writer.write("GPA: " + student.getGPA() + "\n");
                writer.write("\n");
            }

            System.out.println("Student data has been written to student_data.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());

        }
    }
}
