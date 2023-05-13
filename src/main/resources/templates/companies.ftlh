<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Companies</h1><hr>
<#if companies?has_content>
    <#list companies as company>
        <a href="/company/${company.id}">${company.id} | ${company.name}</a>
    </#list>
<#else><h3>No companies</h3>
</#if>
<#if user.role==administrator>
    <form action="/company/create" method="get">
        <input type="submit" value="Add company">
    </form>
</#if>
</body>
</html>