<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Purchases</h1><hr>
<#if purchases?has_content>
    <#list purchases as purchase>
        <a href="/purchase/${purchase.id}">${purchase.id} | ${purchase.hotel.name}</a>
    </#list>
<#else><h3>No purchases</h3>
</#if>
</body>
</html>