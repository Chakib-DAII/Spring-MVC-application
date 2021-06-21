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
        <th>Account Number</th>
        <th>Creation Date</th>
        <th>Type</th>
        <th>Balance</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bankAccounts}" var="ba">
        <tr>
            <td>${ba.id}</td>
            <td>${ba.accountNumber}</td>
            <td>${ba.creationDate}</td>
            <td>${ba.type}</td>
            <td>${ba.balance}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>