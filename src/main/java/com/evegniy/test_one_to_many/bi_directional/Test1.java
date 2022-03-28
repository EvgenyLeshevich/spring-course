package com.evegniy.test_one_to_many.bi_directional;


import com.evegniy.test_one_to_many.bi_directional.entity.Department;
import com.evegniy.test_one_to_many.bi_directional.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            //save
            /*Department department = Department.builder()
                    .name("IT")
                    .minSalary(600)
                    .maxSalary(6000)
                    .build();
            Employee employee1 = Employee.builder()
                    .name("Evgeniy")
                    .surname("L")
                    .salary(900)
                    .build();
            Employee employee2 = Employee.builder()
                    .name("Nina")
                    .surname("L")
                    .salary(750)
                    .build();

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();

            session.save(department);

            session.getTransaction().commit();*/

            //get
            session.beginTransaction();

            Department department = session.get(Department.class, 3L);

            System.out.println(department);
            System.out.println(department.getEmployeeList());

            session.getTransaction().commit();

            //delete
            /*session.beginTransaction();

            Employee employee = session.get(Employee.class, 1L);
            session.delete(employee);

            session.getTransaction().commit();*/

        } finally {
            sessionFactory.close();
        }
    }
}
