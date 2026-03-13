package Homework6.task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.openSession();

            session.beginTransaction();

            session.persist(new Car("BMW M5", Type.GASOLINE, 600, 95000, 2023));
            session.persist(new Car("Tesla Model Y", Type.ELECTRIC, 450, 55000, 2022));
            session.persist(new Car("Toyota Land Cruiser", Type.DIESEL, 249, 85000, 2021));
            session.persist(new Car("BMW i8", Type.HYBRID, 374, 120000, 2020));
            session.persist(new Car("Volkswagen Golf", Type.GASOLINE, 150, 25000, 2019));

            session.getTransaction().commit();
            System.out.println("Cars created");

        }
    }
}