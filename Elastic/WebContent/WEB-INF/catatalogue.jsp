<%@page import="service.LigneFiltre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<!-- initialisation de la jstl via la taglib -->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!-- on peut maintenant utiliser les tags de la jstl -->

<!-- gestion des imports -->
<%@page import="service.User" %>
<%@page import="service.BlocFiltre" %>
<%@page import="java.util.List" %>
<%@page import="service.LigneFiltre" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>le catatalogue</title>
	<link rel="stylesheet" href = "../style.css">
</head>
<body>
	<h1>Bienvenue à toi oh ${sessionScope.user.user}</h1>
	
	<p>veuillez cliquer sur les petites cases à cocher pour pouvoir afficher 
	les elastiques que vous voulez ( en fait ce sont des filtres)
	</p>
	
	<!-- on affiche les filtres avec EL pour voir la gueule qu'ils ont -->
	<p>${sessionScope.tabfiltres }
	</p>
	<p>${sessionScope.tabfiltres[5].nomBF }
	</p>
	<!-- on créé un objet ligneFiltre pour pourvoir recuperer les elements lignes filtre de mon tableau de filtre -->
	<% 
	//creation d'un objet de type liste de BlocFiltre 'lBf' afin de recuperer l'attribut tabfiltres de la session
		List<BlocFiltre> lBf = (List<BlocFiltre>) request.getSession().getAttribute("tabfiltres");
	%>
	<c:out value="lBf.nomBF"/>
	
	<!-- je crée une tableau pour pouvoir y ajouter mes filtres -->
	<table>
		<thead>
			<tr>nom du tableau</tr>
		</thead>
		<tbody>
		
		<!-- pour chaques elements du tableau,  -->
		<c:forEach items="${sessionScope.tabfiltres}" var="bloc">
			<p>bip<br/></p>
		</c:forEach>
		
		
		
		</tbody>
	
	
	</table>


</body>
</html>