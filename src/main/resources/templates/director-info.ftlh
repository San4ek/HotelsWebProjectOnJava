<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Directors</h1>
<h4>Information about director</h4>
<b>Name </b>${director.name}<br>
<b>Hotel <#if director.hotel?has_content>
    </b>${director.hotel.name}<br>
</#if>
<#if user.role==administrator>
    <form action="/director/delete/${director.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Delete director">
    </form>
    <form action="/director/${director.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit director">
    </form>
</#if>
</body>
</html>