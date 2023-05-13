<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Countries</h1><hr>
<h3>Editing country</h3>
<form action="/country/edit/${country.id}" method="post">
    Name <input type="text" value="${country.name}" required name="name"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Update country"/>
</form>
</body>
</html>