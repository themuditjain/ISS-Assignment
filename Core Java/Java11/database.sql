-- Create a new database
CREATE DATABASE jdbc_example;

-- Use the newly created database
USE jdbc_example;

-- Create a table to store user information
CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT
);

-- Add an identity specification to the 'id' column
ALTER TABLE users
ALTER COLUMN id INT IDENTITY(1,1);

