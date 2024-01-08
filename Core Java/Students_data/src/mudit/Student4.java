package mudit;

import java.util.Arrays;

public class Student4 {
    // Instance variables
    private String studentName;
    private int age;
    private char[] grades;

    // Constructor
    public Student4(String name, int age, char[] grades) {
        this.studentName = name;
        this.age = age;
        this.grades = grades;
    }

    // Getter methods
    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public char[] getGrades() {
        return grades;
    }

    // Setter methods
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrades(char[] grades) {
        this.grades = grades;
    }

    // Method to display information about the student
    public void displayStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age: " + age);
        System.out.println("Grades: " + Arrays.toString(grades));
    }

    public static void main(String[] args) {
        // Creating an array of grades for a student
        char[] grades1 = {'S', 'B', 'S', 'S', 'S', 'S'};
        char[] grades2 = {'B', 'S', 'C', 'B', 'A', 'A'};

        // Creating Student4 objects
        Student4 student1 = new Student4("Mudit Jain", 22, grades1);
        Student4 student2 = new Student4("Sanket Jain", 22, grades2);

        // Displaying information about each student
        System.out.println("Information for Student 1:");
        student1.displayStudentInfo();

        System.out.println("-----------------------------");

        System.out.println("Information for Student 2:");
        student2.displayStudentInfo();
    }
}

/*
In this example:

The grades variable is an array of characters representing the grades of a student.
The displayStudentInfo method uses the Arrays.toString method to display the grades array.
The main method creates two Student4 objects, each with an array of grades, and displays information about each student.
*/