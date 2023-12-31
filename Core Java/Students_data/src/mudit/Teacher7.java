package mudit;

import java.util.*;

class Student7 {
    private int id;
    private String name;

    public Student7(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters (omitted for brevity)

    @Override
    public String toString() {
        return "Student7{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Teacher7 {
    public static void main(String[] args) {
        // List example with primitive type (Integer)
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        System.out.println("List of Integers: " + integerList);

        // List example with custom object (Student7)
        List<Student7> studentList = new ArrayList<>();
        studentList.add(new Student7(101, "Mudit Jain"));
        studentList.add(new Student7(102, "Keshav Varshney"));
        studentList.add(new Student7(103, "Aniket Aggarwal"));

        System.out.println("List of Students: " + studentList);

        // Set example with primitive type (String)
        Set<String> stringSet = new HashSet<>();
        stringSet.add("apple");
        stringSet.add("banana");
        stringSet.add("orange");

        System.out.println("Set of Strings: " + stringSet);

        // Set example with custom object (Student7)
        Set<Student7> studentSet = new HashSet<>();
        studentSet.add(new Student7(101, "Mudit Jain"));
        studentSet.add(new Student7(102, "Keshav Varshney"));
        studentSet.add(new Student7(103, "Aniket Aggarwal"));

        System.out.println("Set of Students: " + studentSet);

        // Map example with primitive types (Integer, String)
        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, "One");
        integerStringMap.put(2, "Two");
        integerStringMap.put(3, "Three");

        System.out.println("Map of Integers to Strings: " + integerStringMap);

        // Map example with custom objects (Student7, Student7)
        Map<Student7, Student7> studentMap = new HashMap<>();
        studentMap.put(new Student7(101, "Mudit Jain"), new Student7(201, "Math"));
        studentMap.put(new Student7(102, "Keshav Varshney"), new Student7(202, "Physics"));
        studentMap.put(new Student7(103, "Aniket Aggarwal"), new Student7(203, "History"));

        System.out.println("Map of Students to Students: " + studentMap);
    }
}

