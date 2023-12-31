package mudit;

import java.util.Scanner;

public class Student3 {
    // Instance variables
    private String studentName;
    private int age;
    private char grade;

    // Constructor
    public Student3(String name, int age, char grade) {
        this.studentName = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter methods
    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public char getGrade() {
        return grade;
    }

    // Setter methods
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    // Method to display information about the student
    public void displayStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age: " + age);
        System.out.println("Student Grade: " + grade);
    }

    // Method to check if the student is eligible for promotion
    public void checkPromotionEligibility() {
        if (grade == 'S' || grade == 'A') {
            System.out.println(studentName + " is eligible for promotion.");
        } else {
            System.out.println(studentName + " is not eligible for promotion.");
        }
    }

    public static void main(String[] args) {
        // Creating an array of Student3 objects
        Student3[] students = new Student3[3];
        Scanner scanner = new Scanner(System.in);

        // Taking input for each student
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            System.out.print("Grade: ");
            char grade = scanner.next().charAt(0);
            scanner.nextLine();  // Consume the newline character

            students[i] = new Student3(name, age, grade);
        }

        // Displaying information about each student
        for (Student3 student : students) {
            student.displayStudentInfo();
            student.checkPromotionEligibility();
            System.out.println("-----------------------------");
        }

        scanner.close();
    }
}


/*
In this example:

The checkPromotionEligibility method uses a decision-making construct (if-else) to determine whether a student is eligible for promotion based on their grade.
The main method includes a loop (for) to create an array of Student3 objects and takes input for each student using the Scanner class.
It then uses a loop (for-each) to display information about each student and check their promotion eligibility.
*/