<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="groupBean" type="my.antonov.study.web.beans.GroupListBean" scope="request"/>
<html>
<head>
    <title>Группы</title>
</head>
<body>
<h1>Список групп</h1>

<c:choose>
    <c:when test="${not empty groupBean.groups}">
        <table border="2">
            <tbody>
            <tr>
                <th>Наименование группы</th>
                <th>Год начала обучения</th>
                <th>Год окончания обучения</th>
                <th>Поток</th>
            </tr>
            <c:forEach items="${groupBean.groups}" var="group">
                <tr>
                    <td><c:out value="${group.name}" escapeXml="false"/></td>
                    <td><c:out value="${group.startYear}" escapeXml="true"/></td>
                    <td><c:out value="${group.endYear}" escapeXml="false"/></td>
                    <td><c:out value="${group.flow.specName}" escapeXml="false"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>Нет групп.</p>
    </c:otherwise>
</c:choose>

<p>
    <a href="/group/add">Добавить группу</a>
</p>
<p>
    <a href="/main">На главную</a>
</p>
</body>
</html>
