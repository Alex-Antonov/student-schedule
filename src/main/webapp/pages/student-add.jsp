<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="groupBean" type="my.antonov.study.web.beans.GroupListBean" scope="request"/>
<html>
<head>
    <title>Новый студент</title>
</head>
<body>
<h1>Добавление студента</h1>

<form action="/students/add" method="post" enctype="application/x-www-form-urlencoded">
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
        Место в общежитии: <input type="checkbox" name="isHostelInh" value="true">
    </p>
    <p>
        Стипендия: <input type="checkbox" name="isGrants" value = "true">
    </p>
    <p>
        Группа:
        <select name="groupName">
            <c:forEach items="${groupBean.groups}" var="group">
                <option value="${group.name}">${group.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <input type="submit" />
    </p>
</form>
</body>
</html>