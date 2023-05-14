<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Users</h1><hr>
<#if users?has_content>
    <#list users as user>
        ${user.id} | ${user.name}
        <form action="/user/${user.id}/set-role" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Set director">
        </form>
    </#list>
<#else><h3>No users</h3>
</#if>
</body>
</html>