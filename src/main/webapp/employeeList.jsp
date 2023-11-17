<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>

<h2>Employee List</h2>

<table border="1">
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Joining Date</th>
        <th>Total Vacation Leave</th>
        <th>Total Sick Leave</th>
        <th>Calculated Vacation Leave</th>
        <th>Calculated Sick Leave</th>
    </tr>

    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.getFormattedDOB()}</td>
            <td>${employee.email}</td>
            <td>${employee.getFormattedJoiningDate()}</td>
            <td>${employee.totalVacationLeave}</td>
            <td>${employee.totalSickLeave}</td>
            <td>${employee.calculateLeave()}</td>
            <td>${employee.calculateSickLeave()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
