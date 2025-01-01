-- Create the 'employees' table if it doesn't exist
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,        -- Unique identifier for each employee
    name VARCHAR(100) NOT NULL,               -- Employee's full name
    firm VARCHAR(100) NOT NULL,               -- The firm the employee works at
    position VARCHAR(100) NOT NULL,           -- Employee's position in the firm
    date_of_employment DATE NOT NULL          -- Date of employment
);

-- Insert sample data into the 'employees' table
INSERT INTO employees (name, firm, position, date_of_employment)
VALUES
    ('John Doe', 'TechCorp', 'Software Engineer', '2020-05-15'),
    ('Jane Smith', 'HealthInc', 'Project Manager', '2019-08-01'),
    ('Michael Brown', 'FinanceLLC', 'Accountant', '2021-01-10'),
    ('Emily Davis', 'TechCorp', 'Data Analyst', '2022-03-20'),
    ('David Wilson', 'HealthInc', 'HR Manager', '2018-11-30');

-- Create the 'courses' table if it doesn't exist
CREATE TABLE IF NOT EXISTS courses (
    id_course INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for each course
    id_employee INT,                           -- Foreign key to the employees table
    name VARCHAR(100) NOT NULL,                -- Name of the course
    number_of_hours INT NOT NULL,              -- Number of hours required for the course
    value DOUBLE NOT NULL,                     -- Value or cost of the course
    graduation_diploma BOOLEAN NOT NULL,       -- If the course provides a graduation diploma
    year INT NOT NULL,                         -- Year the course was taken
    FOREIGN KEY (id_employee) REFERENCES employees(id) ON DELETE CASCADE  -- Foreign key constraint
);

-- Insert sample data into the 'courses' table
INSERT INTO courses (id_employee, name, number_of_hours, value, graduation_diploma, year)
VALUES
    (1, 'Java Programming', 40, 500.00, TRUE, 2023),
    (2, 'Project Management', 35, 600.00, TRUE, 2023),
    (3, 'Accounting Basics', 30, 400.00, FALSE, 2022),
    (4, 'Data Science with Python', 45, 700.00, TRUE, 2023),
    (5, 'Human Resources Management', 40, 650.00, TRUE, 2023);
