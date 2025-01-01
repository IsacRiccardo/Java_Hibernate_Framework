package com.example;

import com.example.dao.EmployeeDAO;
import com.example.dao.CourseDAO;
import com.example.entity.Employee;
import com.example.entity.Course;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CourseDAO courseDAO = new CourseDAO();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add an Employee");
            System.out.println("2. Search for an Employee");
            System.out.println("3. Update an Employee");
            System.out.println("4. Delete an Employee");
            System.out.println("5. Add a Course");
            System.out.println("6. Search for a Course");
            System.out.println("7. Update a Course");
            System.out.println("8. Delete a Course");
            System.out.println("9. Display All Employees in a Firm");
            System.out.println("10. Display Employees with Employment Duration Greater Than a Value");
            System.out.println("11. Display Employees Who Took a Specified Course");
            System.out.println("12. Exit");
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();

            // Consume the leftover newline character from nextInt()
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("\nEnter Employee Name: ");
                    String name = scanner.nextLine(); // Now uses nextLine() for full name
                    System.out.print("Enter Firm: ");
                    String firm = scanner.nextLine(); // Now uses nextLine() for full firm name
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine(); // Now uses nextLine() for full position
                    System.out.print("Enter Date of Employment (yyyy-MM-dd): ");
                    String dateStr = scanner.nextLine(); // Now uses nextLine() for full date string
                    Date date = sdf.parse(dateStr);
                    Employee employee = new Employee(name, firm, position, date);
                    employeeDAO.addEmployee(employee);
                    System.out.println("\n=== Employee Added Successfully ===");
                    System.out.println("Employee Name: " + name);
                    System.out.println("Firm: " + firm);
                    System.out.println("Position: " + position);
                    System.out.println("Date of Employment: " + dateStr);
                    break;

                case 2:
                    // Search for Employee
                    System.out.print("\nEnter Employee ID: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();  // Consume the leftover newline character
                    Employee foundEmployee = employeeDAO.getEmployee(empId);
                    if (foundEmployee != null) {
                        System.out.println("\n=== Employee Found ===");
                        System.out.println("Employee ID: " + foundEmployee.getId());
                        System.out.println("Employee Name: " + foundEmployee.getName());
                        System.out.println("Firm: " + foundEmployee.getFirm());
                        System.out.println("Position: " + foundEmployee.getPosition());
                        System.out.println("Date of Employment: " + sdf.format(foundEmployee.getDateOfEmployment()));
                    } else {
                        System.out.println("\nEmployee not found!");
                    }
                    break;

                case 3:
                    // Update Employee
                    System.out.print("\nEnter Employee ID to Update: ");
                    int updateEmpId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Employee updateEmployee = employeeDAO.getEmployee(updateEmpId);
                    if (updateEmployee != null) {
                        System.out.print("Enter New Name: ");
                        updateEmployee.setName(scanner.nextLine()); // Now uses nextLine()
                        System.out.print("Enter New Firm: ");
                        updateEmployee.setFirm(scanner.nextLine()); // Now uses nextLine()
                        System.out.print("Enter New Position: ");
                        updateEmployee.setPosition(scanner.nextLine()); // Now uses nextLine()
                        employeeDAO.updateEmployee(updateEmployee);
                        System.out.println("\n=== Employee Updated Successfully ===");
                    } else {
                        System.out.println("\nEmployee not found!");
                    }
                    break;

                case 4:
                    // Delete Employee
                    System.out.print("\nEnter Employee ID to Delete: ");
                    int delEmpId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    employeeDAO.deleteEmployee(delEmpId);
                    System.out.println("\n=== Employee Deleted Successfully ===");
                    break;

                case 5:
                    // Add Course
                    System.out.print("\nEnter Employee ID: ");
                    int idEmployee = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Employee courseEmployee = employeeDAO.getEmployee(idEmployee);  // Fetch Employee object
                    if (courseEmployee == null) {
                        System.out.println("\nEmployee not found!");
                        break;
                    }
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine(); // Now uses nextLine()
                    System.out.print("Enter Number of Hours: ");
                    int hours = scanner.nextInt();
                    System.out.print("Enter Course Value: ");
                    double value = scanner.nextDouble();
                    System.out.print("Enter Graduation Diploma (true/false): ");
                    boolean diploma = scanner.nextBoolean();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();

                    // Create Course object with Employee reference
                    Course course = new Course(courseEmployee, courseName, hours, value, diploma, year);
                    courseDAO.addCourse(course);
                    System.out.println("\n=== Course Added Successfully ===");
                    break;

                case 6:
                    // Search for Course
                    System.out.print("\nEnter Course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Course foundCourse = courseDAO.getCourse(courseId);
                    if (foundCourse != null) {
                        System.out.println("\n=== Course Found ===");
                        System.out.println("Course ID: " + foundCourse.getId());
                        System.out.println("Course Name: " + foundCourse.getName());
                        System.out.println("Number of Hours: " + foundCourse.getNumberOfHours());
                        System.out.println("Value: " + foundCourse.getValue());
                        System.out.println("Graduation Diploma: " + (foundCourse.isGraduationDiploma() ? "Yes" : "No"));
                        System.out.println("Year: " + foundCourse.getYear());
                    } else {
                        System.out.println("\nCourse not found!");
                    }
                    break;

                case 7:
                    // Update Course
                    System.out.print("\nEnter Course ID to Update: ");
                    int updateCourseId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Course updateCourse = courseDAO.getCourse(updateCourseId);
                    if (updateCourse != null) {
                        System.out.print("Enter New Course Name: ");
                        updateCourse.setName(scanner.nextLine()); // Now uses nextLine()
                        System.out.print("Enter New Number of Hours: ");
                        updateCourse.setNumberOfHours(scanner.nextInt());
                        System.out.print("Enter New Course Value: ");
                        updateCourse.setValue(scanner.nextDouble());
                        System.out.print("Enter Graduation Diploma (true/false): ");
                        updateCourse.setGraduationDiploma(scanner.nextBoolean());
                        System.out.print("Enter New Year: ");
                        updateCourse.setYear(scanner.nextInt());
                        courseDAO.updateCourse(updateCourse);
                        System.out.println("\n=== Course Updated Successfully ===");
                    } else {
                        System.out.println("\nCourse not found!");
                    }
                    break;

                case 8:
                    // Delete Course
                    System.out.print("\nEnter Course ID to Delete: ");
                    int delCourseId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    courseDAO.deleteCourse(delCourseId);
                    System.out.println("\n=== Course Deleted Successfully ===");
                    break;

                case 9:
                    // Display Employees by Firm
                    System.out.print("\nEnter Firm Name: ");
                    String firmName = scanner.nextLine(); // Now uses nextLine()
                    List<Employee> employees = employeeDAO.getEmployeesByFirm(firmName);
                    if (employees.isEmpty()) {
                        System.out.println("\nNo employees found in the specified firm.");
                    } else {
                        System.out.println("\n=== Employees in Firm: " + firmName + " ===");
                        employees.forEach(emp -> System.out.println("Employee Name: " + emp.getName()));
                    }
                    break;

                case 10:
                    // Display Employees by Employment Duration
                    System.out.print("\nEnter Duration (in years): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    List<Employee> employeesByDuration = employeeDAO.getEmployeesWithEmploymentDurationGreaterThan(duration);
                    if (employeesByDuration.isEmpty()) {
                        System.out.println("\nNo employees found with more than " + duration + " years of employment.");
                    } else {
                        System.out.println("\n=== Employees with More Than " + duration + " Years of Employment ===");
                        employeesByDuration.forEach(emp -> System.out.println("Employee Name: " + emp.getName()));
                    }
                    break;

                case 11:
                    // Display Employees Who Took a Specified Course
                    System.out.print("\nEnter Course Name: ");
                    String specifiedCourse = scanner.nextLine(); // Now uses nextLine()
                    System.out.println("\nSearching for employees who took the course: " + specifiedCourse);
                    
                    // Fetch the employees who took the specified course
                    List<Employee> employeesByCourse = courseDAO.getEmployeesByCourseName(specifiedCourse);
                    if (employeesByCourse.isEmpty()) {
                        System.out.println("\nNo employees found for the specified course.");
                    } else {
                        System.out.println("\n=== Employees Who Took the Course: " + specifiedCourse + " ===");
                        employeesByCourse.forEach(emp -> System.out.println("Employee Name: " + emp.getName()));
                    }
                    break;

                case 12:
                    // Exit
                    System.out.println("\n=== Exiting... Thank you for using the application! ===");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        }
    }
}
