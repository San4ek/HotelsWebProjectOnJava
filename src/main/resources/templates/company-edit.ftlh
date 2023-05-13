<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Companies</h1><hr>
<h3>Editing company</h3>
<form action="/company/edit/${company.id}" method="post">
    Name <input type="text" value="${company.name}" required name="name"/><br><br>
    Country <p><select name="country.id" required >
            <option value="${company.country.id}">${company.country.name}</option>
                <#list companies as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
        </select></p><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Update company"/>
</form>
</body>
</html>