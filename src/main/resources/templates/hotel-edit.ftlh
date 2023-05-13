<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Hotels</h1><hr>
<h3>Editing hotel</h3>
<form action="/hotel/edit/${hotel.id}" method="post">
    Name <input type="text" value="${hotel.name}" required name="name"/><br><br>
    Number of stars <p><select name="numberOfStars" required>
            <option value="${hotel.numberOfStars}">${hotel.numberOfStars}</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select></p><br>
    Company <p><select name="company.id" required>
            <option value="${hotel.company.id}">${hotel.company.name}</option>
                <#list companies as company>
                    <option value="${company.id}">${company.name}</option>
                </#list>
        </select></p><br>
    Company <p><select name="director.id" required>
            <option value="${hotel.director.id}">${hotel.director.name}</option>
                <#list directors as director>
                    <option value="${director.id}">${director.name}</option>
                </#list>
        </select></p><br>
    Country <p><select name="country.id" required>
            <option value="${hotel.country.id}">${hotel.country.name}</option>
                <#list countries as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
        </select></p><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Update hotel"/>
</form>
</body>
</html>