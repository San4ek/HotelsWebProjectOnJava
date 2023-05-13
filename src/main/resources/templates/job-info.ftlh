<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Jobs</h1>
<h4>Information about employee</h4>
<b>Name </b>${job.name}<br>
<b>Salary </b>${job.salary}<br>
<#if user.role==administrator>
    <form action="/job/delete/${job.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Delete job">
    </form>
    <form action="/job/${job.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit job">
    </form>
</#if>
</body>
</html>