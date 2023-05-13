<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Jobs</h1><hr>
<h3>Editing job</h3>
<form action="/job/edit/${job.id}" method="post">
    Name <input type="text" value="${job.name}" required name="name"/><br><br>
    Salary <input type="number" value="${job.salary}" required name="salary"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Update job"/>
</form>
</body>
</html>