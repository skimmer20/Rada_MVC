<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Deputats Page</title>
</head>
<body>
<style type="text/css">
    .tg {
        border-collapse: collapse;
        border-spacing: 0;
        border-color: #ccc;
    }

    .tg td {
        font-family: Arial, sans-serif;
        font-size: 14px;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #fff;
    }

    .tg th {
        font-family: Arial, sans-serif;
        font-size: 14px;
        font-weight: normal;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #f0f0f0;
    }

    .tg .tg-4eph {
        background-color: #f9f9f9
    }
</style>

<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Deputat List</h1>

<c:if test="${!empty listDeputats}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="140">First Name</th>
            <th width="140">Last Name</th>
            <th width="140">Fraction</th>
            <th width="80">Age</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDeputats}" var="deputat">
            <tr>
                <td>${deputat.id}</td>
                <td><a href="/deputatdata/${deputat.id}" target="_blank">${deputat.firstName}</a></td>
                <td>${deputat.lastName}</td>
                <td>${deputat.deputatFraction}</td>
                <td>${deputat.age}</td>
                <td><a href="<c:url value='/edit/${deputat.id}'/>"> Edit</a></td>
                <td><a href="<c:url value='/remove/${deputat.id}'/>"> Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Deputat</h1>

<c:url var="addAction" value="/deputats/add"/>

    <form:form action="${addAction}" modelAttribute="deputat">
        <table>
            <c:if test="${!empty deputat.firstName}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="firstName">
                        <spring:message text="First Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="firstName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="lastName">
                        <spring:message text="Last Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="lastName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="deputatFraction">
                        <spring:message text="Fraction"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="deputatFraction"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="age">
                        <spring:message text="Age"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="age"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty deputat.firstName}">
                        <input type="submit"
                               value="<spring:message text="Edit Deputat"/>"/>
                    </c:if>
                    <c:if test="${empty deputat.firstName}">
                        <input type="submit"
                               value="<spring:message text="Add Deputat"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
