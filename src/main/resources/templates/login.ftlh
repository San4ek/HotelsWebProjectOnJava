<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<h4>Authorisation</h4>
<form action="/login" method="post">
    Login <input type="text" required name="username"><br><br>
    Password <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Enter"/>
</form><br>
<a href="/registration">Registration</a>
</body>
</html>