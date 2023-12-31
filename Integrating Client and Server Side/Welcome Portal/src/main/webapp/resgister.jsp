<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <script type="text/javascript" src="validation.js"></script>
</head>
<body>
    <form action="RegisterServlet" method="post" onsubmit="return validateRegistration()">
        <label for="newUsername">New Username:</label>
        <input type="text" id="newUsername" name="newUsername" required><br>

        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
