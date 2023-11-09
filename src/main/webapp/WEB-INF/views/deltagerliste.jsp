<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="no.hvl.dat108.Oblig4_gr99.entities.Deltager" %>
<jsp:useBean id="deltager" scope="session" type="no.hvl.dat108.Oblig4_gr99.entities.Deltager" />
<jsp:useBean id="alleDeltagere" scope="request" type="java.util.List" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
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
        <% 
            for (Object o : (List<?>) request.getAttribute("alleDeltagere")) {
                Deltager d = (Deltager) o;
                String highlight = d.getMobil().equals(deltager.getMobil()) ? "highlight" : "";
        %>
            <tr class="<%= highlight %>">
                <td><%= d.getKjonn().equals("mann") ? "&#9794;" : "&#9792;" %></td>
                <td><%= d.getFornavn() %> <%= d.getEtternavn() %></td>
                <td><%= d.getMobil() %></td>
            </tr>
        <% 
            } 
        %>
    </table>
    <br>
    <form action="/utlogging" method="post">
        <button type="submit">Logg ut</button>
    </form>
</body>
</html>
