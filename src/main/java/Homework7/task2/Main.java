package Homework7.task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Homework7.task2.Student.class)
                .addAnnotatedClass(Homework7.task2.Course.class);

                try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.openSession();

            session.beginTransaction();

            Course java = new Course("Java", "Backend dev");
            Course python = new Course("Python", "Data Science");

            session.persist(java);
            session.persist(python);

            Student lilya = new Student("Lilya", 19);
            Student dmytro = new Student("Dmytro", 17);
            Student michael = new Student("Michael", 18);
            Student sam = new Student("Sam", 19);

            lilya.addCourse(java);
            dmytro.addCourse(java);
            dmytro.addCourse(python);
            michael.addCourse(java);
            michael.addCourse(python);
            sam.addCourse(python);

            session.persist(lilya);
            session.persist(dmytro);
            session.persist(michael);
            session.persist(sam);

            session.getTransaction().commit();

            session.beginTransaction();

            String hql = "select s from Student s join s.courses c where c.name = :courseName";

            List<Student> javaStudents = session.createQuery(hql, Student.class)
                    .setParameter("courseName", "Java")
                    .getResultList();

            System.out.println("Студенти Java:");
            for (Student s : javaStudents) {
                System.out.println(s);
            }

            List<Student> pythonStudents = session.createQuery(hql, Student.class)
                    .setParameter("courseName", "Python")
                    .getResultList();

            System.out.println("Студенти Python");
            for (Student s : pythonStudents) {
                System.out.println(s);
            }

            session.getTransaction().commit();

            session.close();

        }


    }

}
