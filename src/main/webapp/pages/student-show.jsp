<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="stud" type="my.antonov.study.model.Student" scope="request"/>
<html>
<head>
    <title>Студент</title>
</head>
<body>
<h1>Студент</h1>
<p>
    Фамилия: ${stud.secondName}
</p>
<p>
    Имя: ${stud.firstName}
</p>
<p>
    Отчество: ${stud.lastName}
</p>
<p>
    Email: ${stud.email}
</p>
<p>
    Телефон: ${stud.phone}
</p>
<p>
    Место в общежитии: ${stud.hostelInh}
</p>
<p>
    Стипендия: ${stud.grants}
</p>
<p>
    Группа: ${stud.group.name}
</p>
<p>
    <a href="/students/edit/${stud.id}">Редактировать</a>
</p>
<p>
    <a href="/students/delete/${stud.id}">Удалить</a>
</p>
<p>
    <a href="/students/all">К списку студентов</a>
</p>
</body>
</html>
