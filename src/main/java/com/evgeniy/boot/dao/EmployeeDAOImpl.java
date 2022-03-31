package com.evgeniy.boot.dao;

import com.evgeniy.boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        // hibernate
        // Получаем hibernate.session из обёртки jpa.entityManager
//        Session session = entityManager.unwrap(Session.class);
//        return session.createQuery("from Employee", Employee.class)
//                .getResultList();

        // jpa
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(Long id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Employee.class, id);

        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(Long id) {
//        Session session = entityManager.unwrap(Session.class);
//        session.createQuery("delete from Employee e where e.id =:empId")
//                .setParameter("empId", id)
//                .executeUpdate();

        entityManager.createQuery("delete from Employee e where e.id =:empId")
                .setParameter("empId", id)
                .executeUpdate();
    }
}
