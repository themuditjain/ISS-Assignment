package mudit;

public class Student2 {
    // Instance variables
    private final String studentName;  // Final variable
    private int age;
    private static int totalStudents;  // Static variable

    // Constants
    public static final String SCHOOL_NAME = "VIT, Vellore";  // Final variable

    // Constructors
    public Student2(String name, int age) {
        this.studentName = name;
        this.age = age;
        totalStudents++;
    }

    // Getter methods
    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    // Setter method
    public void setAge(int age) {
        this.age = age;
    }

    // Method to display information about the student
    public void displayStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age: " + age);
        System.out.println("School Name: " + SCHOOL_NAME);
        System.out.println("Total Students: " + totalStudents);
    }

    public static void main(String[] args) {
        // Creating objects of the Student class
        Student2 student1 = new Student2("Mudit Jain", 21);
        Student2 student2 = new Student2("Keshav Varshney", 22);

        // Calling methods on the objects
        student1.displayStudentInfo();
        student2.displayStudentInfo();

        // Modifying the state using setter methods
        student1.setAge(22);

        // Displaying updated information
        student1.displayStudentInfo();

        // Accessing static variable using class name
        System.out.println("Total Students across all objects: " + Student2.getTotalStudents());
    }
}
