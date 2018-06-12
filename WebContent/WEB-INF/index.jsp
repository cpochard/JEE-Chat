<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page accueil</title>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href="style_index.css">
</head>
<body>
	<h1> Le super menu</h1>
	<nav>
		<ul id="menu">
			<li><a href="<%=request.getContextPath()%>/login">Login</a></li>
			<li><a href="<%=request.getContextPath()%>/register">Inscription</a></li>
			<li><a href="<%=request.getContextPath()%>/chat">Chat</a></li>
		</ul>
	</nav>
	
</body>
</html>