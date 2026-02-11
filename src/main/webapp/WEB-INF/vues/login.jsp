<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Connexion</title>
</head>
<body>

<h1>Connexion</h1>

<form method="POST" action="connexion">

  <label>
    Login :
    <input type="text" name="login" required>
  </label>
  <br><br>

  <label>
    Mot de passe :
    <input type="password" name="password" required>
  </label>
  <br><br>

  <button type="submit">Se connecter</button>

</form>

</body>
</html>
