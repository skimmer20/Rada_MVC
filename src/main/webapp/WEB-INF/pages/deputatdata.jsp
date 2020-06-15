<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>DeputatData</title>

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

</head>
<body>

<h1>Deputat Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="140">First Name</th>
        <th width="140">Last Name</th>
        <th width="140">Fraction</th>
        <th width="80">Age</th>
    </tr>
        <tr>
            <td>${deputat.id}</td>
            <td>${deputat.firstName}</td>
            <td>${deputat.lastName}</td>
            <td>${deputat.deputatFraction}</td>
            <td>${deputat.age}</td>
        </tr>
</table>
</body>
</html>
