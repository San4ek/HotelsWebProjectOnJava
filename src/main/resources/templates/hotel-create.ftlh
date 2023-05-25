<!DOCTYPE html>
<html>
<head>
    <title>Отели</title>
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
    select {
        color: #0007a7;
        background-color: #a389ff;
        text-align: center;
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
    <h1 align="center" >________________________________________Отели________________________________________</h1>
</header><br><br>
<a href="/">НА ГЛАВНУЮ</a>
<h1 align="center">Отели</h1><hr>
<h3 align="center">Добавить новый отель</h3>
<form action="/hotel/add" method="post">
    <p align="center">Название <br><input type="text" required name="name"/></p>
    <p align="center">Количество звезд <br><select name="numberOfStars" required>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
        </select></p>
    <p align="center">Компания владелец <br><select name="company.id" required>
            <#if companies?has_content>
                <#list companies as company>
                    <option value="${company.id}">${company.name}</option>
                </#list>
            </#if>
        </select></p>
    <p align="center">Главный администратор <br><select name="director.id" required>
            <#if directors?has_content>
                <#list directors as director>
                    <option value="${director.id}">${director.name}</option>
                </#list>
            </#if>
        </select></p>
    <p align="center">Страна <br><select name="country.id" required>
            <#if countries?has_content>
                <#list countries as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
            </#if>
        </select></p>
    <p align="center">Количество номеров <br><input type="number" min="1" required name="numbOfRooms"/></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить отель"/>
</form>
<footer>
    <p align="center">Всегда с вами!</p>
    <p align="center">Служба поддержки: +375 (44) 763-61-10    </p>
</footer>
</body>
</html>