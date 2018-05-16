<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
	
</script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script language="javascript"
	src="<c:url value="/resources/js/bootstrap.min.js"/>">
	
</script>

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	
	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="#">Contatos</a></li>
	</ul>
	
	
	<form:form cssClass="form-inline" method="POST" action="/ProjetoSpringMVC/buscarContato/${paramBusca}">
		<form:input path="paramBusca" cssClass="form-control mr-sm-2" placeholder="Nome" />
		<button class="btn btn-success" type="submit">Procurar</button>
	</form:form>
</nav>
	
</body>
</html>