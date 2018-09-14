<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="subjBean" type="my.antonov.study.web.beans.SubjectListBean" scope="request"/>
<html>
<head>
    <title>Новый преподаватель</title>
</head>
<body>
<h1>Новый преподаватель</h1>

<form action="/tutor/add" method="post" enctype="application/x-www-form-urlencoded">
    <p>
        Фамилия: <input type="text" name="secondName">
    </p>
    <p>
        Имя: <input type="text" name="firstName">
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
        Степень: <input type="text" name="degree">
    </p>
    <p>
        Стаж: <input type="text" name="experience">
    </p>
    <p>
        Дисциплины:

        <select name="subjects" multiple="multiple">
            <c:forEach items="${subjBean.subjects}" var="subj">
                <option value="${subj.name}">${subj.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <input type="submit" />
    </p>
</form>
</body>
</html>
