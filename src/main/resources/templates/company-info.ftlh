<!DOCTYPE html>
<html>
<head>
    <title>Company</title>
</head>
<body>
<h1></h1>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Companies</h1><hr>
<h3>Information about company</h3>
<b>Name </b>${company.name}<br>
<b><a href="/countries">Country </a></b>${company.country.name}<br>
<#if user.role==administrator>
    <form action="/company/delete/${company.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Delete company">
    </form>
    <form action="/company/${company.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit company">
    </form>
</#if>
</body>
</html>