package com.lffblk.tutorials.jpa.services;

import com.lffblk.tutorials.jpa.entities.relations.onetoone.OneToOneDepartment;
import com.lffblk.tutorials.jpa.entities.relations.onetoone.OneToOneEmployee;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class OneToOneEmployeeService extends BaseService {

    public OneToOneEmployee createEmployee(String name, double salary, String deg, OneToOneDepartment department) {
        entityManager.getTransaction().begin();

        OneToOneEmployee employee = new OneToOneEmployee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setDeg(deg);
        employee.setDepartment(department);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        return employee;
    }

    public OneToOneDepartment createDepartment(String name) {
        entityManager.getTransaction().begin();

        OneToOneDepartment department = new OneToOneDepartment();
        department.setName(name);
        entityManager.persist(department);

        entityManager.getTransaction().commit();
        return department;
    }

    public List<OneToOneEmployee> getAllEmployees() {
        Query query = entityManager.createQuery("SELECT e FROM OneToOneEmployee e ORDER BY e.name ASC");
        return query.getResultList();
    }

    public static OneToOneEmployeeService getInstance() {
        if (instance == null) {
            instance = new OneToOneEmployeeService();
        }
        return (OneToOneEmployeeService) instance;
    }

    @Override
    void clearTable() {
        entityManager.getTransaction().begin();

        // clear table
        Query query = entityManager.createQuery("DELETE FROM OneToOneEmployee e");
        query.executeUpdate();

        query = entityManager.createQuery("DELETE FROM OneToOneDepartment e");
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }
}
