package Homework6.task4;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_name")
    private String name;
    private int age;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        this.courses.add(course);
    }


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age;
    }
}

