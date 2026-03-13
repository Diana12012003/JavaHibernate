package Homework6.task3;

import javax.persistence.*;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_name")
    private String name;
    private int age;
    private String course;

    public Student() {}

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", course='" + course + "'}";
    }
}
