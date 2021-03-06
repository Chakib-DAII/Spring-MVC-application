<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>All customers</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>

<body>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>CIN</th>
        <th>Birth Date</th>
        <th>E-mail</th>
        <th>Telephone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.firstName}</td>
            <td>${c.lastName}</td>
            <td>${c.cin}</td>
            <td>${c.birthDate}</td>
            <td>${c.email}</td>
            <td>${c.telephone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>