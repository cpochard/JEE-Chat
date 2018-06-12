<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire</title>
</head>
<body>
	<h2>Ma page d'inscription</h2>
	<form action="/chat/register" method="post">
    <label for="nom">nom : </label>
    <input id="nom" type="text" name="champs_name">
    
    <label for="prenom">prenom : </label>
    <input id="prenom" type="text" name="champs_firstname">
    
    <label for="pseudo">pseudo : </label>
    <input id="pseudo" type="text" name="champs_login">
    
    <label for="motdepasse">Mot de passe : </label>
    <input id="motdepasse" type="password" name="champs_password">
    
    <input type="submit" value="S'enregistrer">
</form>
</body>
</html>