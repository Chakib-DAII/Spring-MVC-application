<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
                                 integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container d-block" style="margin-top: 10%">

    <div class="d-flex justify-content-center">
        <h1 style="margin-left: 30px">Login</h1>
    </div>
    <!-- /login?error=true -->
    <c:if test="${param.error == 'true'}">
        <div class="d-flex justify-content-center" style="color:red;margin:10px 0px;">

            Login Failed!!!<br />
            Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

        </div>
    </c:if>
<div class="d-flex justify-content-center">
    <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</div>

</div>
</body>
</html>