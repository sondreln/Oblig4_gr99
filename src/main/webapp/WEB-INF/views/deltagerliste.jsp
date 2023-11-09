<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="deltager" scope="session" type="no.hvl.dat108.Oblig4_gr99.entities.Deltager" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value='/css/simple.css'/>">
    <title>Deltagerliste</title>
</head>

<body>
    <p>Innlogget som: ${deltager.mobil} / ${deltager.fornavn} ${deltager.etternavn} </p>
    <h2>Deltagerliste</h2>
    <table>
        <tr>
            <th>Kjønn</th>
            <th>Navn</th>
            <th>Mobil</th>
        </tr>
        <c:forEach var="d" items="${alleDeltagere}">
            <tr class="${d.mobil == deltager.mobil ? 'highlight' : ''}">
                <td>${d.kjonn == 'mann' ? '&#9794;' : '&#9792;'}</td>
                <td>${d.fornavn} ${d.etternavn}</td>
                <td>${d.mobil}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action="<c:url value='/utlogging'/>" method="post">
        <button type="submit">Logg ut</button>
    </form>
</body>

</html>
