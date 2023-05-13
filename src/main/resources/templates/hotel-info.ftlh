<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Hotels</h1>
<h4>Information about hotel</h4>
<b>Name </b>${hotel.name}<br>
<b>Country </b>${hotel.country.name}<br>
<b>Number of stars </b>${hotel.numberOfStars}<br>
<b>Company </b><a href="/company/${hotel.company.name}">${hotel.company.name}</a><br>
<b>Employees </b><br><#list hotel.employees as employee>
<a href="/employee/${employee.id}">${employee.name}</a><br>
</#list>
<b>Director </b><a href="/director/${hotel.director.id}">${hotel.director.name}</a><br>
<hr>
<#if user.role==administrator>
    <form action="/hotel/delete/${hotel.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Delete hotel">
    </form>
    <form action="/hotel/${hotel.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit hotel">
    </form>
    <#else>
        <#if user.role==userRole>
            <form action="/hotel/order/${hotel.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Order hotel">
            </form>
        </#if>
</#if>

</body>
</html>