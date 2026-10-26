package Homework7.task1;

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

            session.persist(new Student("Lilya", 19, "Java"));
            session.persist(new Student("Dmytro", 17, "Python"));
            session.persist(new Student("Anna", 21, "QA manual"));
            session.persist(new Student("Solomia", 24, "Java"));

            session.getTransaction().commit();

            session.beginTransaction();
            Student student = session.get(Student.class, 1);
            System.out.println(student);
            session.getTransaction().commit();

            session.close();

        }


    }

}
