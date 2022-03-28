package com.evegniy.test_one_to_one;

import com.evegniy.test_one_to_one.entity.Detail;
import com.evegniy.test_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            //save one to one with two setters
            /*Employee employee = Employee.builder()
                    .name("Nikolay")
                    .surname("N")
                    .department("IT")
                    .salary(800)
                    .build();
            Detail detail = Detail.builder()
                    .city("Minsk")
                    .phoneNumber("561651")
                    .email("nik@yandex.by")
                    .build();
            employee.setDetail(detail);
            detail.setEmployee(employee);

            session.beginTransaction();

            session.save(detail);

            session.getTransaction().commit();*/

            //get
            /*session.beginTransaction();

            Detail detail = session.get(Detail.class, 5L);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();*/

            //delete
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 2L);
            detail.getEmployee().setDetail(null);
            session.delete(detail);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
