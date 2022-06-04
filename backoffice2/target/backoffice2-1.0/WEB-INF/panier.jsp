<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panier</title>
    </head>
    <body>
        <h1>Voici le contenu de mon Panier</h1>
        
        
        <ul>
        <c:forEach items="${ panier }" var="panierItem">
            <li>Numero du Matelas: ${panierItem.getMatelasId()} Quantité : ${panierItem.quantite}  </li> 
             
        </c:forEach>
        </ul>
       
        <a href="index">Retour au magasin</a>
        
    </body>
</html>
