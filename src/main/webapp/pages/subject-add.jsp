<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Новый предмет</title>
</head>
<body>
<h1>Новая дисциплина</h1>

<form action="/subject/add" method="post" enctype="application/x-www-form-urlencoded">
    <p>
        Наименование дисциплины: <input type="text" name="subjName">
    </p>
    <p>
        <input type="submit" />
    </p>
</form>
</body>
</html>
