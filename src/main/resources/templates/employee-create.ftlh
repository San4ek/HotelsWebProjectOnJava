<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Employees</h1><hr>
<h3>Adding new employee</h3>
<form action="/employee/add" method="post">
    Name <input type="text" required name="name"/><br><br>
    Hotel <p><select name="hotel.id" required>
            <#if hotels?has_content>
                <#list hotels as hotel>
                    <option value="${hotel.id}">${hotel.name}</option>
                </#list>
            </#if>
        </select></p><br>
    Job <p><select name="job.id" required>
            <#if jobs?has_content>
                <#list jobs as job>
                    <option value="${job.id}">${job.name}</option>
                </#list>
            </#if>
        </select></p><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add employee"/>
</form>
</body>
</html>