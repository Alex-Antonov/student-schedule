<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="flowBean" type="my.antonov.study.web.beans.FlowListBean" scope="request"/>
<html>
<head>
    <title>Потоки</title>
</head>
<body>
<h1>Потоки</h1>

<c:choose>
    <c:when test="${not empty flowBean.flows}">
        <table border="2">
            <tbody>
            <tr>
                <th>Поток</th>
            </tr>
            <c:forEach items="${flowBean.flows}" var="flow">
                <tr>
                    <td><a href="/flow/${flow.specName}"><c:out value="${flow.specName}" escapeXml="false"/></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>Нет потоков.</p>
    </c:otherwise>
</c:choose>

<p>
    <a href="/flow/add">Добавить поток</a>
</p>
<p>
    <a href="/main">На главную</a>
</p>

</body>
</html>
