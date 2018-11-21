<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de Connection</title>
	</head>
	<body>
		<h1>Voici un jeu de devinette !!</h1>
                
                <c:choose>
                    <c:when test="${nbJoueur==null}">
                        <hr>
                            <h2>Il n'y a pas de joueurs connecté</h2>
                        <hr>
                    </c:when>    
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${nbJoueur==1}">
                                <hr>
                                    <h2>Il y a ${nbJoueur} joueurs connecté</h2>
                                <hr>
                            </c:when>
                            <c:otherwise>
                                <hr>
                                    <h2>Il y a ${nbJoueur} joueurs connectés</h2>
                                <hr>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>

	<form method="POST">
		<label>Ton prénom : <input name="name"></label>
		<input name="action" value="Connexion" type="SUBMIT">
	</form>
        <c:if test="${message!=null}">
            <hr>
                <h4>${message}</h4>
            </hr>
        </c:if>
    </body>
</html>
