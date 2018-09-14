<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="stud" type="my.antonov.study.model.Student" scope="request"/>
<jsp:useBean id="groupBean" type="my.antonov.study.web.beans.GroupListBean" scope="request"/>
<html>
<head>
    <title>Редактирование студента</title>
</head>
<body>
<h1>Редактирование студента</h1>
<form action="/students/update/${stud.id}" method="post" enctype="application/x-www-form-urlencoded">
    <p>
        Фамилия: <input type="text" name="secondName" value="${stud.secondName}" text>
    </p>
    <p>
        Имя: <input type="text" name="firstName" value="${stud.firstName}">
    </p>
    <p>
        Отчество: <input type="text" name="lastName" value="${stud.lastName}">
    </p>
    <p>
        Email: <input type="text" name="email" value="${stud.email}">
    </p>
    <p>
        Телефон: <input type="text" name="phone" value="${stud.phone}">
    </p>
    <p>
        Место в общежитии:
        <c:if test="${stud.hostelInh}">
            <input type="checkbox" name="isHostelInh" value="true" checked>
        </c:if>
        <c:if test="${!stud.hostelInh}">
            <input type="checkbox" name="isHostelInh" value="true">
        </c:if>
    </p>
    <p>
        Стипендия:
        <c:if test="${stud.grants}">
            <input type="checkbox" name="isGrants" value="true" checked>
        </c:if>
        <c:if test="${!stud.grants}">
            <input type="checkbox" name="isGrants" value="true">
        </c:if>
    </p>
    <p>
        Группа:
        <select name="groupName">
            <c:if test="${stud.group == null}">
                <option selected="selected">Не распределен</option>
            </c:if>
            <c:if test="${stud.group != null}">
                <option>Не распределен</option>
            </c:if>
            <c:forEach items="${groupBean.groups}" var="group">
                <c:if test="${stud.group != null}">
                    <c:if test="${group.name.equals(stud.group.name)}">
                        <option value="${group.name}" selected="selected">${group.name}</option>
                    </c:if>
                    <c:if test="${!group.name.equals(stud.group.name)}">
                        <option value="${group.name}">${group.name}</option>
                    </c:if>
                </c:if>
                <c:if test="${stud.group == null}">
                    <option value="${group.name}">${group.name}</option>
                </c:if>
            </c:forEach>
        </select>
    </p>
    <p>
        <input type="submit" />
    </p>
</form>

<p>
    <a href="/students/${stud.id}">Отмена</a>
</p>

</body>
</html>
