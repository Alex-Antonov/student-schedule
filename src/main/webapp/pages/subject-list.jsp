<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="subjBean" type="my.antonov.study.web.beans.SubjectListBean" scope="request"/>
<html>
<head>
    <title>Предметы</title>
</head>
<body>
<h1>Список дисциплин</h1>

<c:choose>
    <c:when test="${not empty subjBean.subjects}">
        <table border="2">
            <tbody>
            <tr>
                <th>Дисциплина</th>
            </tr>
            <c:forEach items="${subjBean.subjects}" var="subj">
                <tr>
                    <td><c:out value="${subj.name}" escapeXml="false"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>Нет предметов.</p>
    </c:otherwise>
</c:choose>

<p>
    <a href="/subject/add">Добавить дисциплину</a>
</p>
<p>
    <a href="/main">На главную</a>
</p>
</body>
</html>
