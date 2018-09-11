<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="tutorBean" type="my.antonov.study.web.beans.TutorListBean" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Преподаватели</title>
</head>
<body>
<h1>Список преподавателей</h1>

<c:choose>
    <c:when test="${not empty tutorBean.tutors}">
        <table border="2">
            <tbody>
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Email</th>
                <th>Моб. телефон</th>
                <th>Степень</th>
                <th>Стаж</th>
            </tr>
            <c:forEach items="${tutorBean.tutors}" var="totur">
                <tr>
                    <td><c:out value="${totur.secondName}" escapeXml="false"/></td>
                    <td><c:out value="${totur.firstName}" escapeXml="true"/></td>
                    <td><c:out value="${totur.lastName}" escapeXml="false"/></td>
                    <td><c:out value="${totur.email}" escapeXml="false"/></td>
                    <td><c:out value="${totur.phone}" escapeXml="false"/></td>
                    <td><c:out value="${totur.degree}" escapeXml="false"/></td>
                    <td><c:out value="${totur.experience}" escapeXml="false"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>Нет преподавателей.</p>
    </c:otherwise>
</c:choose>

<p>
    <a href="/tutor/add">Добавить преподавателя</a>
</p>
<p>
    <a href="/main">На главную</a>
</p>
</body>
</html>
