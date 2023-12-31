--1
-- The Need for a Database:
-- A database serves as a structured and efficient storage solution for organizing and managing large volumes of data.
-- It provides a centralized repository that supports data integrity, security, and efficient retrieval.
-- Databases enable businesses to store, retrieve, and manipulate data in a systematic manner, facilitating data-driven decision-making.
-- The use of databases also ensures data consistency, reduces redundancy, and supports concurrent access by multiple users.
-- In summary, databases play a crucial role in modern information systems by providing a reliable and scalable foundation for managing and leveraging data.

--2
-- Create the database
CREATE DATABASE EmployeeManagement;

-- Use the created database
USE EmployeeManagement;

-- Create the Employees table
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10, 2)
);

-- Insert some sample data
INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
VALUES
    (1, 'John', 'Doe', 'HR', 50000),
    (2, 'Jane', 'Smith', 'IT', 60000),
    (3, 'Bob', 'Johnson', 'Finance', 55000),
    (4, 'Alice', 'Williams', 'Marketing', 52000),
    (5, 'Charlie', 'Brown', 'IT', 65000);

-- Select all records from the Employees table
SELECT * FROM Employees;

-- Select distinct departments from the Employees table
SELECT DISTINCT Department FROM Employees;

-- Select employees from the IT department with a salary greater than 60000
SELECT * FROM Employees WHERE Department = 'IT' AND Salary > 60000;

-- Select employees from the Finance department or with a salary greater than 60000
SELECT * FROM Employees WHERE Department = 'Finance' OR Salary > 60000;

-- Select employees and order the result by salary in descending order
SELECT * FROM Employees ORDER BY Salary DESC;

-- Insert a new employee
INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary) VALUES (6, 'Eva', 'Green', 'Marketing', 58000);

-- Update the salary of employees in the IT department
UPDATE Employees SET Salary = 70000 WHERE Department = 'IT';

-- Delete the employee with EmployeeID 4
DELETE FROM Employees WHERE EmployeeID = 4;

-- SQL Injection (Note: This is a security vulnerability and should be avoided)
-- Assume input is from a user
DECLARE @input NVARCHAR(100);
SET @input = 'IT';
EXEC('SELECT * FROM Employees WHERE Department = ''' + @input + '''');

-- Select the top 3 highest-paid employees
SELECT TOP 3 * FROM Employees ORDER BY Salary DESC;

-- Select employees with a first name starting with 'J'
SELECT * FROM Employees WHERE FirstName LIKE 'J%';

-- Select employees with a last name containing 'son'
SELECT * FROM Employees WHERE LastName LIKE '%son%';

-- Select employees in the IT or Finance department
SELECT * FROM Employees WHERE Department IN ('IT', 'Finance');

-- Select employees with a salary between 50000 and 60000
SELECT * FROM Employees WHERE Salary BETWEEN 50000 AND 60000;

-- Use aliases to rename columns in the result
SELECT EmployeeID AS ID, FirstName + ' ' + LastName AS FullName, Salary AS MonthlySalary FROM Employees;


-- Create a new table for Departments
CREATE TABLE Departments (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);

-- Insert some sample data into the Departments table
INSERT INTO Departments (DepartmentID, DepartmentName)
VALUES
    (1, 'HR'),
    (2, 'IT'),
    (3, 'Finance'),
    (4, 'Marketing');

-- Perform INNER JOIN to retrieve employees with their department names
SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, Employees.Salary, Departments.DepartmentName FROM Employees INNER JOIN Departments 
ON Employees.Department = Departments.DepartmentName;

-- Perform LEFT JOIN to retrieve all employees and their department names
SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, Employees.Salary, Departments.DepartmentName FROM Employees
LEFT JOIN Departments ON Employees.Department = Departments.DepartmentName;

-- Perform RIGHT JOIN to retrieve all departments and their associated employees
SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, Employees.Salary, Departments.DepartmentName FROM Employees
RIGHT JOIN Departments ON Employees.Department = Departments.DepartmentName;

-- Perform FULL JOIN to retrieve all employees and all departments
SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, Employees.Salary, Departments.DepartmentName FROM Employees
FULL JOIN Departments ON Employees.Department = Departments.DepartmentName;

-- Create the Customers table
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20),
    Address VARCHAR(255)
);

-- Create the NewEmployee table
CREATE TABLE NewEmployee (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10, 2)
);

-- Insert data into the Customers table
INSERT INTO Customers (CustomerID, FirstName, LastName, Email, Phone, Address)
VALUES
    (1, 'John', 'Doe', 'john.doe@email.com', '555-1234', '123 Main St'),
    (2, 'Jane', 'Smith', 'jane.smith@email.com', '555-5678', '456 Oak St'),
    (3, 'Bob', 'Johnson', 'bob.johnson@email.com', '555-9876', '789 Pine St');

-- Insert data into the NewEmployee table
INSERT INTO NewEmployee (EmployeeID, FirstName, LastName, Department, Salary)
VALUES
    (101, 'Alice', 'Williams', 'HR', 55000),
    (102, 'Charlie', 'Brown', 'IT', 60000),
    (103, 'Eva', 'Green', 'Marketing', 58000);

-- Union: Combine the results of two SELECT statements
SELECT FirstName, LastName FROM Employees UNION
SELECT FirstName, LastName FROM Customers;

-- Select Into: Create a new table and insert data into it
SELECT FirstName, LastName INTO NewEmployees FROM Employees;

-- Insert data into the NewEmployee table from the Employees table
INSERT INTO NewEmployee (EmployeeID, FirstName, LastName, Department, Salary)
SELECT EmployeeID, FirstName, LastName, Department, Salary
FROM Employees;


-- Create a new database
CREATE DATABASE AnotherDatabase;

-- Create a new table with constraints
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    CONSTRAINT FK_CustomerOrders FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    CONSTRAINT CHK_OrderDate CHECK (OrderDate >= '2023-01-01'),
    TotalAmount DECIMAL(10, 2) DEFAULT 0
);

-- Add a NOT NULL constraint to an existing column
ALTER TABLE Orders
ALTER COLUMN OrderDate DATE NOT NULL;

-- Add a UNIQUE constraint to an existing column
ALTER TABLE Customers ADD CONSTRAINT UC_Email UNIQUE (Email);

-- Add a FOREIGN KEY constraint with a different name
ALTER TABLE Orders
ADD CONSTRAINT FK_CustomerOrdersNewName FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID);

-- Add a CHECK constraint to an existing column
ALTER TABLE Employees
ADD CONSTRAINT CHK_Salary CHECK (Salary >= 0);

-- Set a default value for the TotalAmount column in the Orders table
ALTER TABLE Orders
ADD CONSTRAINT DF_TotalAmount DEFAULT 0.00 FOR TotalAmount;

-- Create an index on the LastName column in the Employees table
CREATE INDEX IX_LastName ON Employees(LastName);

-- Drop the previously created index on the LastName column in the Employees table
DROP INDEX IX_LastName ON Employees;

-- Modify the data type of the Salary column in the Employees table
ALTER TABLE Employees
ALTER COLUMN Salary DECIMAL(12, 2);

-- Create a view to display employees with a salary greater than 55000
CREATE VIEW HighSalaryEmployees AS
SELECT EmployeeID, FirstName, LastName, Salary
FROM Employees
WHERE Salary > 55000;

-- Update the Department column in the Employees table to allow NULL values
ALTER TABLE Employees
ALTER COLUMN Department VARCHAR(50) NULL;

-- Count the number of employees in each department with a salary greater than 50000
SELECT Department, COUNT(*) AS EmployeeCount
FROM Employees
WHERE Salary > 50000
GROUP BY Department
HAVING COUNT(*) > 1;

-- Replace NULL values in the Department column with 'Not Assigned'
UPDATE Employees
SET Department = 'Not Assigned'
WHERE Department IS NULL;

-- Create a new table with an identity column
CREATE TABLE NewEmployeeData (
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10, 2)
);

-- Insert data from the existing Employees table into the new table
INSERT INTO NewEmployeeData (FirstName, LastName, Department, Salary)
SELECT FirstName, LastName, Department, Salary
FROM Employees;

-- Drop the existing Employees table
DROP TABLE Employees;

-- Rename the new table to Employees
EXEC sp_rename 'NewEmployeeData', 'Employees';


--4 Normalization Example

CREATE DATABASE NewEmployeeManagement;

-- Use the created database
USE NewEmployeeManagement;

--Original Denormalized Structure
CREATE TABLE EmployeeManagement (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10, 2),
    OrderID INT,
    OrderDate DATE,
    ProductName VARCHAR(50),
    Quantity INT,
    TotalAmount DECIMAL(10, 2),
    CustomerID INT,
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20),
    Address VARCHAR(255),
    DepartmentID INT,
    DepartmentName VARCHAR(50)
);

--Normalized Structure:
--Departments Table
CREATE TABLE Departments (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);

--Employees Table:
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DepartmentID INT,
    Salary DECIMAL(10, 2),
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);

--Orders Table
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    EmployeeID INT,
    OrderDate DATE,
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);

--Customers Table
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20),
    Address VARCHAR(255)
);


--EmployeeDepartment Table (to represent the many-to-many relationship between Employees and Departments):
CREATE TABLE EmployeeDepartment (
    EmployeeID INT,
    DepartmentID INT,
    PRIMARY KEY (EmployeeID, DepartmentID),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);
