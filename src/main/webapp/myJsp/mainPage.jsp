
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Погодное приложение</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .toolbar {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #3498db;
            padding: 10px 20px;
            display: flex;
            justify-content: flex-start;
            align-items: center;
        }

        .button {
            padding: 5px 10px;
            margin-right: 10px;
            font-size: 14px;
            text-align: center;
            background-color: #2980b9;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #1c638a;
        }
    </style>
</head>
<body>

<div class="toolbar">
    <button class="button">Погода сегодня</button>
    <button class="button">Прогноз на 7 дней</button>
    <button class="button">Уведомления о погоде</button>
</div>

</body>
</html>
