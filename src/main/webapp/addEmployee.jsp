<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<form action="addEmployee" method="post">
    <label for="employeeId">Employee ID:</label>
    <input type="text" id="employeeId" name="employeeId" required><br>

    <label for="employeeName">Employee Name:</label>
    <input type="text" id="employeeName" name="employeeName" required><br>

    <label for="dob">Date of Birth (dd/MM/yyyy):</label>
    <input type="text" id="dob" name="dob" required><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br>

    <label for="joiningDate">Joining Date (dd/MM/yyyy):</label>
    <input type="text" id="joiningDate" name="joiningDate" required><br>

    <input type="submit" value="Add Employee">
</form>
</body>
</html>
