<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<h1>Hotels</h1><hr>
<#if user.login??>
    <form action="/logout" method="post">
        <p>User <a href="/user/${user.id}"><i>${user.login}</i></a>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Выйти"></p>
    </form>
    <p></p>
    <hr>
    <a href="/hotels">Hotels</a>
    <a href="/directors">Directors</a>
    <a href="/companies">Companies</a>
    <a href="/countries">Countries</a>
    <a href="/employees">Employees</a>
    <a href="/jobs">Jobs</a>
<#else><h1><a href="/login">Enter</a></h1>
</#if>
</body>
</html>