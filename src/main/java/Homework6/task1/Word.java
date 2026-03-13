package Homework6.task1;

import javax.persistence.*;


@Entity
@Table(name = "words")

public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private String value;

    public Word() {}

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
