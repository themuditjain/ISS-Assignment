import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    private static final String JDBC_URL = "jdbc:mysql://your_database_url:3306/jdbc_example";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();

            // Inserting data
            insertData(statement, "Mudit Jain", 22);

            // Querying data
            queryData(statement);

            // Updating data
            updateData(statement, 1, "Updated Name");

            // Querying data after update
            queryData(statement);

            // Deleting data
            deleteData(statement, 1);

            // Querying data after delete
            queryData(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Statement statement, String name, int age) throws SQLException {
        String insertQuery = "INSERT INTO users (name, age) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        }
    }

    private static void queryData(Statement statement) throws SQLException {
        String selectQuery = "SELECT * FROM users";
        try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
            System.out.println("Query Result:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
            System.out.println();
        }
    }

    private static void updateData(Statement statement, int id, String newName) throws SQLException {
        String updateQuery = "UPDATE users SET name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        }
    }

    private static void deleteData(Statement statement, int id) throws SQLException {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        }
    }
}
