
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WeatherApp</title>

</head>
<body>
<h3>Main page</h3>
<form method="get" action="/weather">
    <button type="submit">Get current weather</button>
</form>
<br>
<form method="get" action="/prognosis">
    <button type="submit">Get 5 day forecast</button>
</form>


</body>
</html>
