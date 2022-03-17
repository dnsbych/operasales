<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<p>Список билетов для мероприятия (${event.name}):</p>
<table style="border:1px solid #cccccc;">
    <c:forEach var="ticket" items="${tickets}">
        <tr>
            <td width="30%">
                    ${ticket.id}
            </td>
            <td>
                ${ticket.price}
            </td>
            <td>
                ${ticket.eventName}
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>