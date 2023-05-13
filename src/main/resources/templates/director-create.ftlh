<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Directors</h1><hr>
<h3>Adding new director</h3>
<form action="/director/add" method="post">
    Name <input type="text" required name="name"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add director"/>
</form>
</body>
</html>