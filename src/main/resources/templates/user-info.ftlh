<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>User</h1>
<h4>Information about user</h4>
<b>Login </b>${user.login}<br>
<b>Name </b>${user.name}<br>
<a href="/purchases">Purchases</a>
<br>
    <form action="/user/${user.id}/delete" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Delete user">
    </form>
    <form action="/user/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit user">
    </form>
</body>
</html>