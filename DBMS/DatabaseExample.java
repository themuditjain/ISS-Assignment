package DBMS;

import java.math.BigDecimal;
import java.sql.*;

public class DatabaseExample {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/SQLQuery1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mudit";

    public static void main(String[] args) {
        try {
            // Establish a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Example of Callable Statement
            CallableStatement callableStatement = connection.prepareCall("{call getEmployeeCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            int employeeCount = callableStatement.getInt(1);
            System.out.println("Total Employees: " + employeeCount);

            // Example of Prepared Statement
            String department = "IT";
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employees WHERE Department = ?");
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("EmployeeID"));
                System.out.println("First Name: " + resultSet.getString("FirstName"));
                System.out.println("Last Name: " + resultSet.getString("LastName"));
                System.out.println("Department: " + resultSet.getString("Department"));
                System.out.println("Salary: " + resultSet.getBigDecimal("Salary"));
                System.out.println("------------------------");
            }

            // Example of Stored Procedure
            CallableStatement storedProcedure = connection.prepareCall("{call updateEmployeeSalary(?, ?)}");
            storedProcedure.setInt(1, 1); // EmployeeID
            storedProcedure.setBigDecimal(2, new BigDecimal("75000.00")); // New Salary
            storedProcedure.execute();

            // Close resources
            resultSet.close();
            preparedStatement.close();
            storedProcedure.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
