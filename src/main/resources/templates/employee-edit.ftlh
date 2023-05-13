<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Employees</h1><hr>
<h3>Editing employee</h3>
<form action="/employee/edit/${employee.id}" method="post">
    Name <input type="text" value="${employee.name}" required name="name"/><br><br>
    Hotel <p><select name="hotel.id" required>
            <option value="${employee.hotel.id}">${employee.hotel.name}</option>
                <#list hotels as hotel>
                    <option value="${hotel.id}">${hotel.name}</option>
                </#list>
        </select></p><br>
    Job <p><select name="job.id" required>
            <option value="${employee.job.id}">${employee.job.name}</option>
                <#list jobs as job>
                    <option value="${job.id}">${job.name}</option>
                </#list>
        </select></p><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Update employee"/>
</form>
</body>
</html>