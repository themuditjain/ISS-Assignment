package mudit;


//Interface
interface Exam {
void takeExam();
}

//Abstract class with encapsulation
abstract class Person {
private String name;

public Person(String name) {
   this.name = name;
}

public String getName() {
   return name;
}

// Abstract method
public abstract void displayDetails();
}

//Inheritance
class Student5 extends Person implements Exam {
private int age;
private char grade;

public Student5(String name, int age, char grade) {
   super(name);
   this.age = age;
   this.grade = grade;
}

// Polymorphism and method overriding
@Override
public void displayDetails() {
   System.out.println("Student Name: " + getName());
   System.out.println("Student Age: " + age);
   System.out.println("Student Grade: " + grade);
}

// Polymorphism through interface implementation
@Override
public void takeExam() {
   System.out.println(getName() + " is taking the exam.");
}
}

//Main class
public class Teacher5 {
public static void main(String[] args) {
   // Creating a Student5 object
   Student5 student = new Student5("Mudit Jain", 22, 'S');

   // Using methods from the Person class (inheritance)
   System.out.println("Person's name: " + student.getName());

   // Using methods from the Student5 class
   student.displayDetails();

   // Using methods from the Exam interface
   student.takeExam();
}
}

/*
 In this example:

There's a Person abstract class with encapsulation (private variable with a getter method).
The Student5 class extends Person, implements the Exam interface, and overrides the displayDetails method.
The Exam interface declares the takeExam method.
The Main class is the entry point and demonstrates the use of inheritance, overriding, polymorphism, abstraction, encapsulation, and interfaces.
*/
