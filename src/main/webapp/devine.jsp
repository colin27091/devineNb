<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Devine un nombre</title>
	</head>
	<body>
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

                 
                <c:if test="${essai != null}">
                    <h3>Vous en etes a ${essai} essai(s)</h3>
                </c:if>
		
                <c:if test="${bas != null || haut != null}">
                    <c:choose>
                        <c:when test="${bas != null}">
                            <h3>Le nombre a deviner est plus petit que ${choix}</h3>
                        </c:when>
                        <c:otherwise>
                            <h3>Le nombre a deviner est plus grand ${choix}</h3>
                        </c:otherwise>
                    </c:choose> 
                </c:if>
                                
		<h2>Le nombre est compris entre 0 et 100</h2>
		<form name="guessForm" method="POST" accept-charset="UTF-8" >
			<label>Ta proposition : <input type="number" min="0" max="100" required name="proposition"></label> 
			<input type="SUBMIT" name="action" value="Deviner"><br/>
		</form>
		<form method="POST">
			<input type="SUBMIT" name="action" value="Déconnexion">
		</form>

		<hr>
		
                <c:if test="${bestEssai != null && bestName != null}">
                    <h3>Score à battre : ${bestEssai} essais par ${bestName}</h3>
                </c:if>
			
				
	</body>
</html>