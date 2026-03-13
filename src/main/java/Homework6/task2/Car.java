package Homework6.task2;

import javax.persistence.*;

@Entity
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int power;
    private int price;
    private int year;

    public Car() {
    }

    public Car(String model, Type type, int power, int price, int year) {
        this.model = model;
        this.type = type;
        this.power = power;
        this.price = price;
        this.year = year;
    }
}
