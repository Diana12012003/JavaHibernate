package Homework6.task4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class);

        try (SessionFactory factory = configuration.buildSessionFactory();
             Session session = factory.openSession()) {

            session.beginTransaction();

            Course javaCourse = new Course("Java Professional", "Hibernate та Spring");
            Course pythonCourse = new Course("Python Data Science", "Аналіз даних та ШІ");
            Course designCourse = new Course("UI/UX Design", "Figma");

            session.persist(javaCourse);
            session.persist(pythonCourse);
            session.persist(designCourse);

            Student s1 = new Student("Олена", 20);
            Student s2 = new Student("Іван", 22);
            Student s3 = new Student("Марія", 19);
            Student s4 = new Student("Максим", 21);
            Student s5 = new Student("Софія", 23);

            s1.addCourse(javaCourse);
            s1.addCourse(designCourse);
            s2.addCourse(pythonCourse);
            s3.addCourse(javaCourse);
            s4.addCourse(pythonCourse);
            s4.addCourse(designCourse);
            s5.addCourse(designCourse);

            session.persist(s1);
            session.persist(s2);
            session.persist(s3);
            session.persist(s4);
            session.persist(s5);

            session.getTransaction().commit();


            System.out.println(" Список ");

            session.createQuery("select s from Student s join s.courses c where c.name = :name", Student.class)
                    .setParameter("name", "Java Professional")
                    .list()
                    .forEach(System.out::println);
        }
    }
}

