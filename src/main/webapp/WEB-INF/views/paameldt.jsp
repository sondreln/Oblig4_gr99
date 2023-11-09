<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="deltager" scope="session" type="no.hvl.dat108.Oblig4_gr99.entities.Deltager" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>

	 <p>
		${deltager.fornavn}  <br />
		${deltager.etternavn}  <br />
		${deltager.kjonn} 
	</p>

	<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>