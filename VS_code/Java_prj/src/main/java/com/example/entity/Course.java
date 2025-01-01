package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private int idCourse;

    // Many-to-one relationship with Employee
    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)  // Foreign key in Course table
    private Employee employee;  // Reference to the Employee who took this course

    @Column(nullable = false)
    private String name;

    @Column(name = "number_of_hours", nullable = false)
    private int numberOfHours;

    @Column(nullable = false)
    private double value;

    @Column(name = "graduation_diploma", nullable = false)
    private boolean graduationDiploma;    

    @Column(nullable = false)
    private int year;

    // Default constructor
    public Course() {}

    // Constructor with parameters
    public Course(Employee employee, String name, int numberOfHours, double value, boolean graduationDiploma, int year) {
        this.employee = employee;
        this.name = name;
        this.numberOfHours = numberOfHours;
        this.value = value;
        this.graduationDiploma = graduationDiploma;
        this.year = year;
    }

    // Getters and Setters
    public int getId() {
        return idCourse;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isGraduationDiploma() {
        return graduationDiploma;
    }

    public void setGraduationDiploma(boolean graduationDiploma) {
        this.graduationDiploma = graduationDiploma;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
