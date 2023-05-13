<!DOCTYPE html>
<html>
<head>
    <title>Hotels</title>
</head>
<body>
<a href="/">НА ГЛАВНУЮ</a>
<h1>Jobs</h1><hr>
<#if jobs?has_content>
    <#list jobs as job>
        <a href="/job/${job.id}">${job.id} | ${job.name}</a>
    </#list>
<#else><h3>No jobs</h3>
</#if>
<#if user.role==administrator>
    <form action="/job/create" method="get">
        <input type="submit" value="Add job">
    </form>
</#if>
</body>
</html>