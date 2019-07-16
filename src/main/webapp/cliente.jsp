<!DOCTYPE html>
<%@page import="br.com.projetofinal.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>LISTA DE E-MAILS</h1>

<form method="post" action="cliente">
	E-mail:
	<input type="text" name="email" />
	<input type="submit" value="Save">

</form>

<%
	List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
	for (Cliente c: lista){
		out.print(c.getEmail()+"<br/>");
	}
%>

</body>
</html>