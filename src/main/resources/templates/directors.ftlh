<!DOCTYPE html>
<html>
<head>
    <title>TourAgency</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Directors</h1><hr>
<#if directors?has_content>
    <#list directors as director>
        <a href="/director/${director.id}">${director.id} | ${director.name}</a>
    </#list>
<#else><h3>No directors</h3>
</#if>
<#if user.role==administrator>
    <form action="/director/create" method="get">
        <input type="submit" value="Add director">
    </form>
</#if>
</body>
</html>