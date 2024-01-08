package mudit;

import java.util.*;

class Student7_1 implements Comparable<Student7_1> {
    private int id;
    private String name;

    public Student7_1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters (omitted for brevity)

    @Override
    public String toString() {
        return "Student7_1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Implementing Comparable interface for natural ordering
    @Override
    public int compareTo(Student7_1 other) {
        return Integer.compare(this.id, other.id);
    }

    // Correcting the method name
    public String getName() {
        return name;
    }
}

public class Teacher7_1 {
    public static void main(String[] args) {
        // List example with primitive type (Integer)
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);

        // Sorting using natural ordering
        Collections.sort(integerList);
        System.out.println("Sorted List of Integers: " + integerList);

        // List example with custom object (Student7_1)
        List<Student7_1> studentList = new ArrayList<>();
        studentList.add(new Student7_1(101, "Mudit Jain"));
        studentList.add(new Student7_1(103, "Keshav Varshney"));
        studentList.add(new Student7_1(102, "Aniket Aggarwal"));

        // Sorting using natural ordering (Comparable)
        Collections.sort(studentList);
        System.out.println("Sorted List of Students (by ID): " + studentList);

        // Sorting using a custom Comparator (by Name)
        studentList.sort(Comparator.comparing(Student7_1::getName));
        System.out.println("Sorted List of Students (by Name): " + studentList);
    }
}


