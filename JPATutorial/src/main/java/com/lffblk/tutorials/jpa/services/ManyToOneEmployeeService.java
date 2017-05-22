package com.lffblk.tutorials.jpa.services;

import com.lffblk.tutorials.jpa.entities.relations.manytoone.ManyToOneDepartment;
import com.lffblk.tutorials.jpa.entities.relations.manytoone.ManyToOneEmployee;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class ManyToOneEmployeeService extends BaseService {
    public ManyToOneEmployee createEmployee(String name, double salary, String deg, ManyToOneDepartment department) {
        entityManager.getTransaction().begin();

        ManyToOneEmployee employee = new ManyToOneEmployee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setDeg(deg);
        employee.setDepartment(department);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        return employee;
    }

    public ManyToOneDepartment createDepartment(String name) {
        entityManager.getTransaction().begin();

        ManyToOneDepartment department = new ManyToOneDepartment();
        department.setName(name);
        entityManager.persist(department);

        entityManager.getTransaction().commit();
        return department;
    }

    public List<ManyToOneEmployee> getAllEmployees() {
        Query query = entityManager.createQuery("SELECT e FROM ManyToOneEmployee e ORDER BY e.name ASC");
        return query.getResultList();
    }

    @Override
    void clearTable() {
        entityManager.getTransaction().begin();

        // clear table
        Query query = entityManager.createQuery("DELETE FROM ManyToOneEmployee e");
        query.executeUpdate();

        query = entityManager.createQuery("DELETE FROM ManyToOneDepartment e");
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

    public static ManyToOneEmployeeService getInstance() {
        if (instance == null) {
            instance = new ManyToOneEmployeeService();
        }
        return (ManyToOneEmployeeService) instance;
    }
}
