<%@page import="model.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>mon catalogue</title>
	</head>
	<body>
	
	<%@page import="service.User" %>
		<p>Bonjour <%= ((Utilisateur)request.getSession().getAttribute("user")).getUser() %> </p>
	
	
    
		<%@page import="service.BlocFiltre" %>
		<%@page import="service.LigneFiltre" %>
		<%@page import="java.util.List" %>
		
		
		<%
		//creation d'un objet de type liste de BlocFiltre 'lBf' afin de recuperer l'attribut tabfiltres de la session
		List<BlocFiltre> lBF = (List<BlocFiltre>) request.getSession().getAttribute("tabfiltres");
		
		if (lBF == null ) System.out.println("pas d attribut tabfiltres");
		for (BlocFiltre blocEnCours :  lBF) {
		
			%>		
			<p> <%=blocEnCours.getNomBF() %> </p>
			<%
				// Affichage des lignes de CB
				for (LigneFiltre lfEnCours : blocEnCours.getLignesFiltre()) {
					%>
					<input type="checkbox" <%= lfEnCours.getEtatHTML() %>> <%= lfEnCours.getLibelle() %></input><br>
					<%
				}%>
			<br><br>
			<% 
		}
		
		
		
 		// pour chaque bloc de filtre
		
		
		 %>
				
		
	</body>
</html>