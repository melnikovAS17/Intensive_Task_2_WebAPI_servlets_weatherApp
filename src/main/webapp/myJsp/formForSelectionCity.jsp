
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WeatherApp</title>

</head>
<body>
<h3>Select your city</h3>
<hr>
<form method="post" action="/weather">
    <input required name="city">
    <button type="submit">Show</button>
</form>
</body>
</html>
