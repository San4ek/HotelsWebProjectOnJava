<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body><style>
    body {
        background-color: #abb1ff;
        font-family: 'Roboto', sans-serif;
        padding-bottom: 70px;
        /*background-image: url(static/images/img_fon.jpg);*/
    }

    h1,
    h2,
    h3,
    h4 {
        font-family: 'Montserrat', sans-serif;
        align-content: center;
        align-items: center;
    }

    a {
        color: #191970;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        color: #0000FF;
        text-decoration: underline;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        margin: 20px 0;
    }

    form input,
    form select,
    form button {
        width: 200px;
        height: 35px;
        margin-bottom: 10px;
        padding: 5px;
    }

    form input[type="submit"],
    form button {
        background-color: #191970;
        color: #fff;
        cursor: pointer;
    }

    form input[type="submit"]:hover,
    form button:hover {
        background-color: #0000FF;
    }

    hr {
        border: none;
        height: 1px;
        background-color: #191970;
        margin: 10px 0;
    }

    header {
        vertical-align: center;
        background-color: #191970;
        text-align: center;
        color: white;
        padding: 0px;
        display: flex;
        /*justify-content: space-between;*/
        align-items: center;
        font-family: 'Montserrat', sans-serif;
    }
    select {
        color: #0007a7;
        background-color: #a389ff;
        text-align: center;
    }

    nav ul {
        display: flex;
        justify-content: flex-end;
    }

    footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        text-align: center;
        background-color: #191970;
        color: #fff;
        padding: 0px;
        font-family: 'Montserrat', sans-serif;
    }</style><header>
    <h1 align="center" >_____________________________________Отели____________________________________</h1>
</header><br><br>
<a href="/">НА ГЛАВНУЮ</a>
<h1 align="center">Компании владельцы</h1><hr>
<h3 align="center">Редактирование компании</h3>
<form action="/company/edit/${company.id}" method="post">
    <p align="center">Название <br><input type="text" value="${company.name}" required name="name"/></p>
    <p align="center">Страна <br><select name="country.id" required >
            <option value="${company.country.id}">${company.country.name}</option>
                <#list companies as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
        </select></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Изменить данные"/>
</form>
<footer>
    <p align="center">Всегда с вами!</p>
    <p align="center">Служба поддержки: +375 (29) 801-50-63</p>
</footer>
</body>
</html>