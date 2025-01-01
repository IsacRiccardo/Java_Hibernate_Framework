package com.example.dao;

import com.example.entity.Course;
import com.example.entity.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class CourseDAO {

    public void addCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        }
    }

    public Course getCourse(int idCourse) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, idCourse);
        }
    }

    public void updateCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        }
    }

    public void deleteCourse(int idCourse) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Course course = session.get(Course.class, idCourse);
            if (course != null) {
                session.delete(course);
            }
            transaction.commit();
        }
    }

    public List<Course> getCoursesForEmployee(int idEmployee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Course where idEmployee = :idEmployee", Course.class)
                    .setParameter("idEmployee", idEmployee)
                    .list();
        }
    }

    public List<Employee> getEmployeesByCourseName(String courseName) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            String hql = "SELECT e FROM Employee e JOIN e.courses c WHERE c.name = :courseName";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("courseName", courseName);
            List<Employee> employees = query.getResultList();
            session.getTransaction().commit();
            return employees;
        }
    }
    
       
}
