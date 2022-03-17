<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>Список мероприятий:</h1>
<table style="border:1px solid #cccccc;">
    <c:forEach var="event" items="${events}">
        <tr>
            <td width="30%">
                    ${event.id}
            </td>
            <td>
                <a href="/events/${event.id}">${event.name}</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>