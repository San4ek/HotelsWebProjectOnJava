<!DOCTYPE html>
<html>
<head>
    <title>TourAgency</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Hotels</h1><hr>
    <#if hotels?has_content>
        <#list hotels as hotel>
            <a href="/hotel/${hotel.id}">${hotel.id} | ${hotel.name}</a>
        </#list>
        <#else>
            <h3>No hotels</h3>
    </#if>
            <#if user.role==administrator>
                <form action="/hotel/create" method="get">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Add hotel">
                </form>

    </#if>
</body>
</html>