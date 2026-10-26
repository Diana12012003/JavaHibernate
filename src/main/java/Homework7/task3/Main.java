package Homework7.task3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Homework7.task3.Employee.class)
                .addAnnotatedClass(Homework7.task3.Department.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.openSession();

            session.beginTransaction();

            Department dev = new Department("IT / Development", "Software development & DevOps");
            Department hr = new Department("Human Resources", "Recruitment & employee welfare");
            Department marketing = new Department("Marketing", "Brand awareness & PR");
            session.persist(dev);
            session.persist(hr);
            session.persist(marketing);

            Employee emp1 = new Employee("Oleg", 2500);
            Employee emp2 = new Employee("Iryna", 1800);
            Employee emp3 = new Employee("Maxim", 3100);

            emp1.addDepartment(dev);
            emp2.addDepartment(hr);
            emp2.addDepartment(marketing);
            emp3.addDepartment(dev);
            emp3.addDepartment(marketing);

            session.persist(emp1);
            session.persist(emp2);
            session.persist(emp3);

            session.getTransaction().commit();

            session.beginTransaction();

            String hqlDep = "select e from Employee e join e.departments d where d.name = :depName";

            List<Employee> devEmployees = session.createQuery(hqlDep, Employee.class)
                    .setParameter("depName", "IT / Development")
                    .getResultList();

            System.out.println("Працівники відділу IT/Development");
            for (Employee e : devEmployees) {
                System.out.println(e);
            }

            String hqlSalary = "select e from Employee e where e.salary >= :minSalary order by e.name desc";
            List<Employee> highSalaryEmployees = session.createQuery(hqlSalary, Employee.class)
                    .setParameter("minSalary", 2000)
                    .getResultList();

            System.out.println("Працівники із зарплатою >= 2000");
            for (Employee e : highSalaryEmployees) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            session.close();
        }
    }
}
