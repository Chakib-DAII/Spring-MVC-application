<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<h1>Welcome</h1>
<br>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/bank/all">Banks List</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/customer/all">Customer List</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/bank-account/all">Bank Accounts List</a>
    </li>
</ul>

</body>

</html>