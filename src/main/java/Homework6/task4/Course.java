package Homework6.task4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<Student>();



    public Course() {}

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
