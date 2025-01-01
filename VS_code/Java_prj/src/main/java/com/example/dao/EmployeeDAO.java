package com.example.dao;

import com.example.entity.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import java.util.Date;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public Employee getEmployee(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    public void updateEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    public void deleteEmployee(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        }
    }

    public List<Employee> getEmployeesByFirm(String firm) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee where firm = :firm", Employee.class)
                    .setParameter("firm", firm)
                    .list();
        }
    }

    public List<Employee> getEmployeesWithEmploymentDurationGreaterThan(int years) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Employee where year(current_date()) - year(dateOfEmployment) > :years";
            return session.createQuery(hql, Employee.class)
                    .setParameter("years", years)
                    .list();
        }
    }
}
