CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,        -- Unique identifier for each employee
    name VARCHAR(100) NOT NULL,               -- Employee's full name
    firm VARCHAR(100) NOT NULL,               -- The firm the employee works at
    position VARCHAR(100) NOT NULL,           -- Employee's position in the firm
    date_of_employment DATE NOT NULL          -- Date of employment
);
