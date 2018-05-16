<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
	
</script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>" />
<script src="<c:url value="/resources/js/bootstrap.min.js"/>">
	
</script>

<title>Sistema Mid</title>
</head>
<body>



	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="#">Contatos</a></li>
	</ul>


	<form:form cssClass="form-inline" method="POST"
		action="/ProjetoSpringMVC/buscarContato/"
		modelAttribute="paramBusca">
		<input name="paramBusca" class="form-control mr-sm-2"
			placeholder="Nome" />
		<button class="btn btn-success" type="submit">Procurar</button>
	</form:form> </nav>
	<br />

	<div class="container">

		<form:form method="POST" action="/ProjetoSpringMVC/salvarContato"
			modelAttribute="contato">

			<table class="table table-bordered table-striped table-highlight">
				<tr>
					<td><form:label path="nome"> Nome </form:label></td>
					<td><form:input path="nome" cssClass="form-control" /></td>
				</tr>

				<tr>
					<td><form:label path="endereco"> Endereco </form:label></td>
					<td><form:input path="endereco" cssClass="form-control" /></td>
				</tr>

				<tr>
					<td><form:label path="telefone"> Telefone </form:label></td>
					<td><form:input path="telefone" cssClass="form-control" /></td>
					<td hidden><form:hidden path="id" /></td>

				</tr>

			</table>

			<input type="submit" value="Salvar" class="btn btn-primary" />
		</form:form>

		<br />


		<table class="table table-bordered table-striped">

			<thead class="thead-dark">
				<tr>
					<th>Nome</th>
					<th>Endereço</th>
					<th>Telefone</th>
					<th></th>
				</tr>
			</thead>



			<tbody>
				<c:forEach var="contato" items="${contatos}">
					<form:form method="POST"
						action="/ProjetoSpringMVC/editarContato/${contato.id}"
						modelAttribute="contato">
						<tr>
							<td>${contato.nome}</td>
							<td>${contato.endereco}</td>
							<td>${contato.telefone}</td>
							<td hidden>${contato.id}</td>
							<td><input type="submit" value="Editar" name="edit"
								class="btn btn-link" /> <input type="submit" name="delete"
								value="Excluir" class="btn btn-link" /></td>
						</tr>
					</form:form>

				</c:forEach>
			</tbody>
		</table>




	</div>


</body>
</html>