<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Purchases</h1><hr>
<#if purchases?has_content>
    <#list purchases as purchase>
        ${purchase.id} | ${purchase.user.name} | ${purchase.hotel.name} | ${purchase.purchaseStatus.name()} | ${purchase.room.roomNumb}
        <#if user.role==directorRole>
            <#if purchase.isWait()>
                <form action="/purchase/${purchase.id}/except" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Except purchase">
                </form>
                <form action="/purchase/${purchase.id}/reject" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Reject purchase">
                </form>
            </#if>
            <#if purchase.isExcepted()>
                <form action="/purchase/${purchase.id}/inhabited" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Inhabit">
                </form>
            </#if>
            <#if purchase.isInhabited()>
                <form action="/purchase/${purchase.id}/evicted" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Evict">
                </form>
            </#if>
        </#if><br>
    </#list>
<#else><h3>No purchases</h3>
</#if>
</body>
</html>