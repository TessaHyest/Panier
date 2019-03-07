<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>bienvenue <%= request.getParameter("user")%></title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>Bienvenue dans la boutique des Elastiques</h1>
<% HttpSession sess = request.getSession(true);
 sess.getAttribute("user");
%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SystFiltre"%>

	<p>ici M. <%= sess.getAttribute("user") %> tu trouveras tous les elastiques dont tu rêves!!!</p>
	

	
		<form method="post" action="checkboxtest">
		
			<p>
			merci de faire ton choix parmi ces differentes familles
			</p>
			<%-- 
			<c:forEach items="${filtreFamille}" var="filtre">
			
			<input type="checkbox" name="filtrefamille" value="${filtre.value()}"  ${filtre.valueChecked} >  "${filtre.typeFamille}"</input>
			
			
			</c:forEach>
			
			 --%>
			 <!-- je recupere ma liste de filtre depuis ma class SystFiltre  -->
			 <%   ArrayList<SystFiltre> listeFamille = (ArrayList<SystFiltre>)request.getSession().getAttribute("filtreFamille");
			 
			 // j'affiche ma listre dans les check box 
			 if(listeFamille!= null){
				 
			 
			 for (SystFiltre filtreFamille : listeFamille)  {  %>
			 
	
                    <p><input type="checkbox" name="valueFamille"
                    value="<%=filtreFamille.getId()%>" <%=filtreFamille.getValueChecked()%>>
                    <%=filtreFamille.getTypeFamille()%> </input> </p>
                <%} %>
                <%} %>
			
			<p>et de cliquer <input type="submit" value="ici" name="buttonSubmit">
			</p>
		</form>
	
		<%if(listeFamille!= null){
			 
		 for (SystFiltre filtreFamille : listeFamille)  {
			 if(filtreFamille.Ischecked()){
				 %> 
				 <p>
				 <%=filtreFamille.getTypeFamille()%>
				 </p>
				 <% 
			 }
			 
			 %>
		 
		 <%} %>
		 	<%} %>
		 

</body>
</html>