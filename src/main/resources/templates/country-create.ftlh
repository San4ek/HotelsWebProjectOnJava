<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Countries</h1><hr>
<h3>Adding new country</h3>
<form action="/country/add" method="post">
    Name <input type="text" required name="name"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add company"/>
</form>
</body>
</html>