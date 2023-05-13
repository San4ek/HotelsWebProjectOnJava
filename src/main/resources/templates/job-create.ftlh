<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Jobs</h1><hr>
<h3>Add new job</h3>
<form action="/job/add" method="post">
    Name <input type="text" required name="name"/><br><br>
    Salary <input type="number" required name="salary"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add job"/>
</form>
</body>
</html>