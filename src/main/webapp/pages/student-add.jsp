<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Добавление события</h1>

<form action="/students/add" method="post" enctype="application/x-www-form-urlencoded">
    <p>
        Имя: <input type="text" name="firstName">
    </p>
    <p>
        Фамилия: <input type="text" name="secondName">
    </p>
    <p>
        Отчество: <input type="text" name="lastName">
    </p>
    <p>
        Email: <input type="text" name="email">
    </p>
    <p>
        Телефон: <input type="text" name="phone">
    </p>
    <p>
        Место в общежитии: <input type="checkbox" name="isHostelInh" value="true">
    </p>
    <p>
        Стипендия: <input type="checkbox" name="isGrants" value = "true">
    </p>
    <p>
        <input type="submit" />
    </p>
</form>
</body>
</html>