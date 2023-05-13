<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Companies</h1><hr>
<h3>Adding new company</h3>
<form action="/company/add" method="post">
    Name <input type="text" required name="name"/><br><br>
    Country <p><select name="country.id" required>
            <#if companies?has_content>
                <#list companies as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
            </#if>
        </select></p><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add company"/>
</form>
</body>
</html>