<!DOCTYPE html>
<html>
<head>
    <title>TourAgency</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Countries</h1><hr>
<#if countries?has_content>
    <#list countries as country>
        <a href="/country/${country.id}">${country.id} | ${country.name}</a><br>
    </#list>
<#else><h3>No countries</h3>
</#if>
<#if user.role==administrator>
    <form action="/country/create" method="get">
        <input type="submit" value="Add country">
    </form>
</#if>
</body>
</html>