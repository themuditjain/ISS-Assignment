function validateForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if (username === "" || password === "") {
        alert("Both username and password are required.");
        return false;
    }
    return true;
}

function validateRegistration() {
    var newUsername = document.getElementById("newUsername").value;
    var newPassword = document.getElementById("newPassword").value;

    if (newUsername === "" || newPassword === "") {
        alert("Both new username and password are required.");
        return false;
    }
    return true;
}
