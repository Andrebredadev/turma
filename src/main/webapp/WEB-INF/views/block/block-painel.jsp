<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div class="container">


		<div class="jumbotron">
		   <h1> <i class="fa fa-tachometer" aria-hidden="true"></i> Aplicacao com springmvc</h1>
		   <h3>Com spring boot</h3>
		</div>

		<div class="d-flex justify-content-between">
			<h1>Painel de Bloco</h1>
			<h3>
				<a class="btn btn-primary" href='<c:url value="/cadastrobloco" />'> Cadastrar novo Bloco </a>
			</h3>
			<a class="btn btn-secondary" href='<c:url value="/" />' >
				<i class="fa fa-chevron-circle-left" aria-hidden="true"></i> 
				Voltar a pagina anterior 
			</a>		

		</div>		
		<table class="table">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nome do Bloco</th>
					<th>Codigo da turma</th>					
					<th>Ações</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="block" items="${block}">

					<tr>
						<td>${block.id}</td>
						<td>${block.name}</td>
						<td>${block.schoolClass.classID}</td>
						<td>					
						<a href='<c:url value="/formedit/block/${block.id}" />'>
								<button type="button" class="btn btn-primary">Editar</button>
 						</a> <a href='<c:url value="/delete/block/${block.id}" />'> 
								<button type="button" class="btn btn-danger" >Excluir</button>
						</a>
						</td>
					</tr>

				</c:forEach>


			</tbody>


		</table>		

	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

</body>
</html>