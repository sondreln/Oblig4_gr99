<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p style="color:red;"><span th:text="${errorMessage}"></span></p>
	<form method="post" action="/innlogging">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			<label for="passord">Passord:</label> <input type="password" name="passord" />
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	</form>

</body>
</html>