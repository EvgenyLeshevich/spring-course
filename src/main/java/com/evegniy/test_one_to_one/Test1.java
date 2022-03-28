package com.evegniy.test_one_to_one;

import com.evegniy.test_one_to_one.entity.Employee;
import com.evegniy.test_one_to_one.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            //save
            /*Employee employee = Employee.builder()
                    .name("Nina")
                    .surname("L")
                    .department("IT")
                    .salary(750)
                    .build();
            Detail detail = Detail.builder()
                    .city("Homel")
                    .phoneNumber("8569358")
                    .email("nina.leshevich@yandex.by")
                    .build();
            employee.setDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();*/

            // get
            /*session.beginTransaction();

            Employee employee = session.get(Employee.class, 10L);
            System.out.println(employee.getDetail());

            session.getTransaction().commit();*/

            //delete
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1L);
            session.delete(employee);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
