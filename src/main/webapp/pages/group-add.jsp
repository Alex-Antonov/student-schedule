<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="flowBean" type="my.antonov.study.web.beans.FlowListBean" scope="request"/>
<html>
<head>
    <title>Новая группа</title>
</head>
<body>
<h1>Добавить группу</h1>

<form action="/group/add" method="post" enctype="application/x-www-form-urlencoded">
    <p>
        Наименование группы: <input type="text" name="name">
    </p>
    <p>
        Год начала обучения: <input type="text" name="startYear">
    </p>
    <p>
        Год окончания обучения: <input type="text" name="endYear">
    </p>
    <p>
        Поток:
        <select name="flowSpecName">
            <c:forEach items="${flowBean.flows}" var="flow">
                <option value="${flow.specName}">${flow.specName}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <input type="submit"/>
    </p>
</form>
</body>
</html>
