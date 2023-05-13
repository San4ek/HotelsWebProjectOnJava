<!DOCTYPE html>
<html>
<head>
    <title>TourAgency</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Employees</h1><hr>
<#if employees?has_content>
    <#list employees as employee>
        <a href="/employee/${employee.id}">${employee.id} | ${employee.name}</a>
    </#list>
<#else><h3>No employees</h3>
</#if>
<#if user.role==administrator>
    <form action="/employee/create" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Add employee">
    </form>
</#if>
</body>
</html>