<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новый поток</title>
</head>
<body>
<h1>Добавить поток</h1>

<form action="/flow/add" method="post" enctype="application/x-www-form-urlencoded">
    <p>
        Наименование потока: <input type="text" name="specName">
    </p>
    <p>
        <input type="submit" />
    </p>
</form>
</body>
</html>
