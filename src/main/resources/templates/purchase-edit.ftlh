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

    div {
        flex-direction: row;
        align-items: center;
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
    select {
        color: #0007a7;
        background-color: #a389ff;
        text-align: center;
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
<h1 align="center">Заявка на бронь</h1><hr>
<p align="center">Отель ${purchase.hotel.name}
    <form action="/purchase/${purchase.id}/edit" method="post">
<p align="center"><b>Номера</b><div>
    <select name="roomId" required>
        <#if rooms?has_content>
            <#list rooms as room>
                <option value="${room.id}">${room.roomNumb}</option>
            </#list>
        </#if>
    </select>
</div>
    <p align="center"><b>Дата заселения</b><input type="date" min="" required name="startDate" value="${purchase.startDate}">
    <p align="center"><b>Дата выселения</b><input type="date" required name="endDate" value="${purchase.endDate}">
<p align="center">Услуги<br>
    <#if purchase.hotel.services??>
        <#list purchase.hotel.services as service>
            <input type="checkbox" name="services" value="${service.id}"><b>${service.name}</b><br>
        </#list>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Забронировать отель">
    </form>
    <#if errorMessage??>
<h2 style="color: red" align="center">${errorMessage}</h2>
</#if>
<footer>
    <p align="center">Всегда с вами!</p>
    <p align="center">Служба поддержки: +375 (44) 763-61-10    </p>
</footer>
</body>
</html>