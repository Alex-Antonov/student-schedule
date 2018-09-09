<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bean" type="my.antonov.study.web.beans.StudentListBean" scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h1>Привет, ${bean.userAgent}</h1>--%>

<c:choose>
    <c:when test="${not empty bean.students}">
        <table border="2">
            <tbody>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                <th>Email</th>
                <th>Моб. телефон</th>
                <th>Место в общежитии</th>
                <th>Стипендия</th>
                <th>Поток</th>
                <th>Группа</th>
            </tr>
            <c:forEach items="${bean.students}" var="stud">
                <tr>
                    <td><c:out value="${stud.firstName}" escapeXml="true"/></td>
                    <td><c:out value="${stud.secondName}" escapeXml="false"/></td>
                    <td><c:out value="${stud.lastName}" escapeXml="false"/></td>
                    <td><c:out value="${stud.email}" escapeXml="false"/></td>
                    <td><c:out value="${stud.phone}" escapeXml="false"/></td>
                    <td><c:out value="${stud.hostelInh ? 'Да' : 'Нет'}" escapeXml="false"/></td>
                    <td><c:out value="${stud.grants ? 'Да' : 'Нет'}" escapeXml="false"/></td>
                    <td><c:out value="${stud.group == null ? '-' : stud.group.flow.specName}" escapeXml="false"/></td>
                    <td><c:out value="${stud.group.name == null ? '-' : stud.group.name}" escapeXml="false"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>Нет студентов.</p>
    </c:otherwise>
</c:choose>

<p>
    <a href="/students/add">Добавить студента</a>
</p>

</body>
</html>
