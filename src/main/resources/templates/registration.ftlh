<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<h1>Hotels</h1><hr>
<h4>Registration</h4>
<form action="/registration" method="post">
    Email <input type="email" required name="email"><br><br>
    Login <input type="text" required name="login"><br><br>
    Password <input type="password" required name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Registration"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>