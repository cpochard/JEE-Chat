<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login en JSP</title>
</head>
<body>
	<h2>Se connecter</h2>
	<form method="post" action="<%=request.getContextPath()%>/login">
		<label for="login">Login : </label>
   		<input id="login" type="text" name="pseudo">
    
    	<label for="motdepasse">Mot de passe : </label>
    	<input id="motdepasse" type="password" name="mdp">
    
    	<input type="submit" value="Se connecter"/>
    </form>
</body>
</html>