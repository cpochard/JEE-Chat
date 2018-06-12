<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Le chat</title>
<link rel="stylesheet" href="chat.css"/>
</head>
<body>

    <h1>Bienvenue sur le chat</h1>
  <form action="<%= request.getContextPath() %>/messages" method="post">
       <input type="text" name="user-message">
       <input type="submit" value="envoyer le message">
   </form>
   
    <script src="chat.js"></script>
  
  
</body>
</html>