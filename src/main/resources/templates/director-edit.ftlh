<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Directors</h1><hr>
<h3>Editing director</h3>
<form action="/director/edit/${director.id}" method="post">
    Name <input type="text" value="${director.name}" required name="name"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Update director"/>
</form>
</body>
</html>