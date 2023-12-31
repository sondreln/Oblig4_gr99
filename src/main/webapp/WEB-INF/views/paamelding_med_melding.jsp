<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
    <script src="js/paamelding.js" defer></script> 
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<p style="color:red;"><span th:text="${errorMessage}"> </span></p>
	<form method="post" action="/paameldt">
		<fieldset>
		
			<label>Fornavn</label>
			<input type="text" name="fornavn" value="" required/>
			
			<label>Etternavn</label>
			<input type="text" name="etternavn" value="" required/>
			
			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" value="" required/>
			
			<label>Passord</label>
			<input type="password" name="passord" required/>
			<label>Passord repetert</label>
			<input type="password" name="passordRepetert" required/>
			
			<label>Kjønn</label> 
			<input type="radio" name="kjonn" value="mann" checked="checked" required />mann
			<input type="radio" name="kjonn" value="kvinne" required/>kvinne
			     
			<br><br>
			<button type="submit">
				Meld meg på
			</button>
		</fieldset>
	</form>
</body>
</html>
