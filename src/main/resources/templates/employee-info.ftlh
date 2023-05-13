<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Employees</h1>
<h4>Information about employee</h4>
<b>Name </b>${employee.name}<br>
<b>Hotel </b>${employee.hotel.name}<br>
<b>Job </b>${employee.job.name}<br>
<#if user.role==administrator>
    <form action="/employee/delete/${employee.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Delete employee">
    </form>
    <form action="/employee/${employee.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit employee">
    </form>
</#if>
</body>
</html>