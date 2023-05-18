<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Hotels</h1><hr>
<h3>Add new hotel</h3>
<form action="/hotel/add" method="post">
    <p>Name <input type="text" required name="name"/></p><br>
    <p>Number of stars <select name="numberOfStars" required>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
        </select></p><br>
    <p>Company <select name="company.id" required>
            <#if companies?has_content>
                <#list companies as company>
                    <option value="${company.id}">${company.name}</option>
                </#list>
            </#if>
        </select></p><br>
    <p>Director <select name="director.id" required>
            <#if directors?has_content>
                <#list directors as director>
                    <option value="${director.id}">${director.name}</option>
                </#list>
            </#if>
        </select></p><br>
    <p>Country <p><select name="country.id" required>
            <#if countries?has_content>
                <#list countries as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
            </#if>
        </select></p><br>
    <p>Numb of rooms <input type="number" min="1" required name="numbOfRooms"/></p><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add hotel"/>
</form>
</body>
</html>