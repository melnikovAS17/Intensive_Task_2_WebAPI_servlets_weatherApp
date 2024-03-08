
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WeatherApp</title>
</head>
<body>
<h1>Weather</h1>

<hr/>



<p>Temperature: <%= (double) request.getAttribute("temp") %> &#8451; </p>
<p>Temperature feels like: <%= (double) request.getAttribute("feels_like") %> &#8451; </p>
<p>Pressure: <%= (int) request.getAttribute("pressure") %> hPa </p>
<p>Humidity: <%= (int) request.getAttribute("humidity") %> %</p>
<p>Wind speed: <%= (double) request.getAttribute("wind") %> m/s </p>

<hr/>
<form method="get" action="/weather">
    <button type="submit">Search page</button>
</form>

</body>
</html>