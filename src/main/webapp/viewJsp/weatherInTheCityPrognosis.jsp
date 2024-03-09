
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WeatherApp</title>
</head>

<body>
<h1>Weather</h1>
<hr/>
<% double[] temp = (double[]) request.getAttribute("temp"); %>
<% double[] tempFeelsLike = (double[]) request.getAttribute("feels_like"); %>
<% int[] pressure = (int[]) request.getAttribute("pressure"); %>
<% int[] humidity = (int[]) request.getAttribute("humidity"); %>
<% double[] wind = (double[]) request.getAttribute("wind"); %>
<table>
    <tr>
        <td>&nbsp;</td>
        <td>Monday</td>
        <td>Tuesday</td>
        <td>Wednesday</td>
        <td>Thursday</td>
        <td>Friday</td>
    </tr>
    <tr>
        <td>Temperature  &#8451; </td>
        <td><%= temp[0]%></td>
        <td><%= temp[1]%></td>
        <td><%= temp[2]%></td>
        <td><%= temp[3]%></td>
        <td><%= temp[4]%></td>
    </tr>
    <tr>
        <td>Temp fells like  &#8451; </td>
        <td><%= tempFeelsLike[0]%></td>
        <td><%= tempFeelsLike[1]%></td>
        <td><%= tempFeelsLike[2]%></td>
        <td><%= tempFeelsLike[3]%></td>
        <td><%= tempFeelsLike[4]%></td>
    </tr>
    <tr>
        <td>Pressure  hPa </td>
        <td><%= pressure[0]%></td>
        <td><%= pressure[1]%></td>
        <td><%= pressure[2]%></td>
        <td><%= pressure[3]%></td>
        <td><%= pressure[4]%></td>
    </tr>
    <tr>
        <td>Humidity  % </td>
        <td><%= humidity[0]%></td>
        <td><%= humidity[1]%></td>
        <td><%= humidity[2]%></td>
        <td><%= humidity[3]%></td>
        <td><%= humidity[4]%></td>
    </tr>
    <tr>
        <td>Wind speed  m/s </td>
        <td><%= wind[0]%></td>
        <td><%= wind[1]%></td>
        <td><%= wind[2]%></td>
        <td><%= wind[3]%></td>
        <td><%= wind[4]%></td>
    </tr>
</table>

<hr/>
<form method="get" action="/prognosis">
    <button type="submit">Search page</button>
</form>

</body>
</html>
