<!DOCTYPE html>
<html>
<head>
    <title>Отели</title>
<#--    <link rel="stylesheet" type="text/css" href="css/test.css">-->
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

    div {
        flex-direction: row;
        align-items: center;
    }
    select {
        color: #0007a7;
        background-color: #a389ff;
        text-align: center;
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
<h1 align="center">Отели</h1><hr>
<h3 align="center">Информация об отеле</h3>
<p align="center"><b>Название </b>${hotel.name}</p>
<p align="center"><b>Страна </b>${hotel.country.name}</p>
<p align="center"><b>Количество звезд </b>${hotel.numberOfStars}</p>
<p align="center"><b>Компания владелец </b><a href="/company/${hotel.company.name}">${hotel.company.name}</a></p>
<p align="center"><b>Работники </b>
    <#list hotel.employees as employee>
<a href="/employee/${employee.id}">${employee.name}</a>
</#list></p>
<p align="center"><b>Главный администратор </b><a href="/director/${hotel.director.id}">${hotel.director.name}</a></p>
<#if user.role==administrator>
    <p align="center">Услуги<br>
        <#if hotel.services??>
            <#list hotel.services as service>
                <b>${service.name}</b><br>
            </#list>
        </#if>
    <form action="/hotel/delete/${hotel.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Удалить отель">
    </form>
    <form action="/hotel/${hotel.id}/edit" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Редактировать отель">
    </form>
    <#else>
        <#if user.role==userRole>
                <form action="/hotel/order/${hotel.id}" method="post">
                    <b>Номера</b><div>
                        <select name="roomId" required>
                            <#if rooms?has_content>
                                <#list rooms as room>
                                    <option value="${room.id}">${room.roomNumb}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                    <b>Дата заселения</b><input type="date" min="" required name="startDate">
                    <b>Дата выселения</b><input type="date" required name="endDate">
                    <p align="center">Услуги<br>
                        <#if hotel.services??>
                            <#list hotel.services as service>
                                <input type="checkbox" name="services" value="${service.id}"><b>${service.name}</b><br>
                            </#list>
                        </#if>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Забронировать отель">
                </form>
                <#if errorMessage??>
                    <h2 style="color: red" align="center">${errorMessage}</h2>
                </#if>
        </#if>
</#if>
<footer>
    <p align="center">Всегда с вами!</p>
    <p align="center">Служба поддержки: +375 (44) 763-61-10    </p>
</footer>
</body>
</html>