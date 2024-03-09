
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WeatherAppPrognosis</title>

</head>
<body>
<h3>Select your city</h3>
<hr>
<form method="post" action="/prognosis">
    <input required name="city">
    <button type="submit">Show</button>
</form>
<br>
<form method="get" action="/start">
    <button type="submit">Start page</button>
</form>

</body>
</html>
