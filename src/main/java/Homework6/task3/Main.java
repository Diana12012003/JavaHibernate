package Homework6.task3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.openSession();

            session.beginTransaction();

            session.persist(new Student("Олена", 20, "Java"));
            session.persist(new Student("Іван", 22, "Python"));

            session.getTransaction().commit();

            int searchId = 1;

            Student foundStudent = session.get(Student.class, searchId);

            System.out.println("студент: " + foundStudent);
        }
    }
}



