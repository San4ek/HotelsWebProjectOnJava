<!DOCTYPE html>
<html >
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
        /*align-items: center;*/
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
    select {
        color: #0007a7;
        background-color: #a389ff;
        text-align: center;
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
        color: white; !important;
        padding: 0px;
        display: flex;
        justify-content: space-between;
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
    }
</style>
<#if user.login??>
    <header>
        <h1 align="center" >_____________________________________Отели____________________________________</h1>
    </header>
    <form action="/logout" method="post">
        <p align="center">Добро пожаловать, <a href="/user"><i>${user.login}</i></a><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Выйти"></p>
    </form>
    <hr><br><h2 align="center">Ваше меню</h2>
    <h3 align="center"><a href="/hotels">Отели</a></h3>
    <#if user.role==administrator>
        <h3 align="center"><a href="/companies">Компании</a></h3>
        <h3 align="center"><a href="/countries">Страны</a></h3>
        <h3 align="center"><a href="/employees">Работники</a></h3>
        <h3 align="center"><a href="/jobs">Должности</a></h3>
        <h3 align="center"><a href="/users">Пользователи</a></h3>
        <h3 align="center"><a href="/services">Услуги</a></h3>
        <h3 align="center"><a href="/roomtypes">Комнаты</a></h3>
    </#if>/if>
<#else> <header><h1 align="center">________________________________________Отели________________________________________
    </h1></header><br><br><br><br><br><br><br><br><br>
    <h3 align="center">На нашем сайте вы сможете быстро и удобно забронировать любой отель,<br>
        в котором проведёте незабываемый отпуск!</h3><br><br><br>
    <h2 align="center" ><a href="/login">Войти</a></h2>
</#if>
<footer>
    <p align="center">Всегда с вами!</p>
    <p align="center">Служба поддержки: +375 (29) 801-50-63</p>
</footer>
</body>
</html>