<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
</script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script language="javascript"
	src="<c:url value="/resources/js/bootstrap.min.js"/>">
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Casa</title>
</head>
<body>

	<div class="container">


		<c:import url="../tlds/template.jsp" />

		<h1>Ohayou Sr(a). ${nome} que torce para o ${time}</h1>


	</div>
</body>
</html>