<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Purchases</h1>
<h4>Information about purchase</h4>
<b>Hotel name </b>${purchase.hotel.name}<br>
<form action="/purchase/delete/${purchase.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Delete purchase">
</form>
</body>
</html>