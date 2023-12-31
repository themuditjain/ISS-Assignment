package mudit;

public class Student {
    // Instance variables
    private String name;
    private int age;
    private char grade;

    // Constructor to initialize the instance variables
    public Student(String name, int age, char grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter methods to access the values of instance variables
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGrade() {
        return grade;
    }

    // Setter methods to modify the values of instance variables
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    // Method to display information about the student
    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Grade: " + grade);
    }

    public static void main(String[] args) {
        // Creating an object of the Student class
        Student student1 = new Student("Mudit Jain", 22, 'S');

        // Calling methods on the object
        student1.displayStudentInfo();

        // Modifying the state using setter methods
        student1.setAge(19);
        student1.setGrade('B');

        // Displaying updated information
        student1.displayStudentInfo();
    }
}


/*
In this example, the Student class has instance variables (name, age, and grade), a constructor to initialize these variables, getter methods to retrieve their values, setter methods to modify their values, and a method (displayStudentInfo) to display information about the student. The main method demonstrates the creation of a Student object, calling methods on the object, and modifying the state using setter methods.*/