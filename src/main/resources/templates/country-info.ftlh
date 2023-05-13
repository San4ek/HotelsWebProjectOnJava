<!DOCTYPE html>
<html>
<head>
    <title>Country</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Countries</h1>
<h4>Information about country</h4>
<b>Name </b>${country.name}<br>
<#if user.role==administrator>
    <form action="/country/delete/${country.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Delete country">
    </form>
    <form action="/country/${country.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit country">
    </form>
</#if>
</body>
</html>