<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Liste des Matières</h1>
<table>

<c:forEach items = "${list}" var="m">
<tr> <td> ${m.Titre} </td>
	 <td> ${m.Niveau} </td>
	 <td> ${m.Nbre_Heures} </td>
</tr>
</c:forEach>

</table>

</body>
</html>