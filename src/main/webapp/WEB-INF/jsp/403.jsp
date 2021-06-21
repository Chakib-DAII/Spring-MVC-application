<%@page session="false"%>
<html>
<head>
    <title>Access Denied</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="d-flex justify-content-center" style="margin-top: 10%">
    <div class="col-md-6 col-md-offset-3">
        <div class= "panel panel-primary">
            <div class="panel-body">
                <div class="text-danger">
                    ${message}
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>