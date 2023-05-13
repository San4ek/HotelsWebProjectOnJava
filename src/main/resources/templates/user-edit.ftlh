<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h4>Editing information about user</h4>
<form action="/user/update" method="post">
    Email <input type="text" value="${user.getName}" required name="name"><br><br>
    Login <input type="text" value="${user.login}" required name="login"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Update"/>
</form>
</body>
</html>