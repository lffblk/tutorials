package com.lffblk.tutorials.jpa.services;

import com.lffblk.tutorials.jpa.entities.relations.onetomany.OneToManyDepartment;
import com.lffblk.tutorials.jpa.entities.relations.onetomany.OneToManyEmployee;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class OneToManyEmployeeService extends BaseService {
    public OneToManyEmployee createEmployee(String name, double salary, String deg) {
        entityManager.getTransaction().begin();

        OneToManyEmployee employee = new OneToManyEmployee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setDeg(deg);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        return employee;
    }

    public OneToManyDepartment createDepartment(String name, List<OneToManyEmployee> employees) {
        entityManager.getTransaction().begin();

        OneToManyDepartment department = new OneToManyDepartment();
        department.setName(name);
        department.setEmployeelist(employees);
        entityManager.persist(department);

        entityManager.getTransaction().commit();
        return department;
    }

    public List<OneToManyEmployee> getAllEmployees() {
        Query query = entityManager.createQuery("SELECT e FROM OneToManyEmployee e ORDER BY e.name ASC");
        return query.getResultList();
    }

    public List<OneToManyDepartment> getAllDepartments() {
        Query query = entityManager.createQuery("SELECT d FROM OneToManyDepartment d ORDER BY d.name ASC");
        return query.getResultList();
    }

    public static OneToManyEmployeeService getInstance() {
        if (instance == null) {
            instance = new OneToManyEmployeeService();
        }
        return (OneToManyEmployeeService) instance;
    }

    @Override
    void clearTable() {
        entityManager.getTransaction().begin();

        // clear table
        Query query = entityManager.createQuery("DELETE FROM OneToManyEmployee e");
        query.executeUpdate();

        query = entityManager.createQuery("DELETE FROM OneToManyDepartment e");
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }
}
