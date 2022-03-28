package com.evegniy.test;

import com.evegniy.test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestGetHql {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            /*List<Employee> employeeList = session.createQuery("from Employee")
                            .getResultList();*/

            /*List<Employee> employeeList = session.createQuery("from Employee e where e.name='Evgeniy'")
                            .getResultList();*/

            List<Employee> employeeList = session.createQuery("from Employee e where e.department='IT' and  e.salary > 800")
                    .getResultList();

            employeeList.forEach(System.out::println);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
