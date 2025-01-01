package com.example.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firm;

    @Column(nullable = false)
    private String position;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_employment", nullable = false)
    private Date dateOfEmployment;

    // One-to-many relationship with Course
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Course> courses;


    public Employee() {}

    public Employee(String name, String firm, String position, Date dateOfEmployment) {
        this.name = name;
        this.firm = firm;
        this.position = position;
        this.dateOfEmployment = dateOfEmployment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
