package com.lffblk.tutorials.jpa.services;

import com.lffblk.tutorials.jpa.entities.Employee;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by lffblk on 13.05.2017.
 */
public class EmployeeService extends BaseService {
    public Employee createEmployee(String name, double salary, String deg) {
        entityManager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setDeg(deg);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        return employee;
    }

    public Employee findEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }

    public List<String> getEmployeeNames() {
        Query query = entityManager.createQuery("SELECT UPPER(e.name) FROM Employee e ORDER BY e.name ASC");
        return query.getResultList();
    }

    public double getMaxSalary() {
        Query query = entityManager.createQuery("SELECT MAX(e.salary) FROM Employee e");
        return (double) query.getSingleResult();
    }

    public List<Employee> getEmployeesWithSalaryBounds(double minSalary, double maxSalary) {
        return getEmployeesByQuery("SELECT e FROM Employee e WHERE e.salary BETWEEN "
                + minSalary + " AND " + maxSalary);
    }

    public List<Employee> getEmployeesByNameLike(String likeQuery) {
        return getEmployeesByQuery("SELECT e FROM Employee e WHERE e.name LIKE '" + likeQuery + "'");
    }

    public List<Employee> getEmployeesByDeg(String deg) {
        Query query = entityManager.createNamedQuery("find employee by deg");
        query.setParameter("deg", deg);
        return query.getResultList();
    }

    public List<Employee> getAllEmployees() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        CriteriaQuery<Employee> select = criteriaQuery.select(from);
        select.orderBy(criteriaBuilder.asc(from.get("name")));
        TypedQuery<Employee> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    private List<Employee> getEmployeesByQuery(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    void clearTable() {
        entityManager.getTransaction().begin();

        // clear table
        Query query = entityManager.createQuery("DELETE FROM Employee e");
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

    public static EmployeeService getInstance() {
        if (instance == null) {
            instance = new EmployeeService();
        }
        return (EmployeeService) instance;
    }
}
