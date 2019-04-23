<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/layouts/header.jsp" />
<title>doctors</title>
</head>
<body>

	<!-- Navigation menu -->
	<jsp:include page="/WEB-INF/views/layouts/nav.jsp" />

	<div class="generic-container sm-container">
		<div class="card">
			<button class="card-header text-left" type="button"
				data-toggle="collapse" data-target="#collapseInput" role="button"
				aria-expanded="false" aria-controls="collapseInput"
				style="cursor: pointer;">
				<c:choose>
					<c:when test="${doctor.id != null}">
						Modificare
					</c:when>
					<c:otherwise>
						Adaugare
					</c:otherwise>
				</c:choose>
			</button>


			<div class="collapse ${doctor.id != null ? 'show' : ''}"
				id="collapseInput">
				<div class="card-body">
					<form:form action="doctors/save" modelAttribute="doctor" method="POST">


						<form:hidden path="id" />
						<div class=" form-group row">
							<label class="col-sm-2 col-form-label" for="">Sectie</label>
							<div class="col-sm-6">
								<form:input path="name" class="form-control"
									placeholder="Section name" required="required" />
							</div>
						</div>
						<div class="clearfix">
							<hr>
							<input type="submit" class="btn btn-primary float-right"
								value="${doctor.id != null ? 'Actualizare' : 'Salvare' }">
							<a href="list" class="btn float-right mr-2 btn-info">Anulare</a>
						</div>
					</form:form>

				</div>
			</div>
		</div>

		<div class="mt-2"></div>

		<div class="card">
			<div class="card-header" data-toggle="collapse">
				Sections
			</div>
			<div class="card-body">

				<div class="row">
					<table class="table ">
						<thead class=" col-6">
							<tr>
								<th scope="col">#</th>
								<th scope="col">Sectie</th>
								<th class="custom-action-width" scope="col">Actiuni</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="doctor" items="${doctors}" varStatus="loop">

								<c:url var="update" value="/doctors/update">
									<c:param name="Id" value="${doctor.id}" />
								</c:url>

								<c:url var="delete" value="/doctors/delete">
									<c:param name="Id" value="${doctor.id}" />
								</c:url>

								<tr>
									<th class="custom-action-width" scope="row">${loop.index + 1}</th>
									<td>${doctor.name}</td>

									<td class="custom-action-width"><a href="${update}"
										class="btn btn-warning btn-sm">Editare</a>
										<button class="btn btn-danger btn-sm" data-toggle="modal"
											data-target="#confirmModal${doctor.id}">
											Stergere
										</button></td>
								</tr>


								<div class="modal fade" id="confirmModal${doctor.id}">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">
													Stergere
												</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												Delete <span class="text-danger font-weight-bold">${doctor.name}</span>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">
													Anulare
												</button>
												<a href="${delete}" class="btn btn-danger">Confirmare</a>
											</div>
										</div>
									</div>
								</div>

							</c:forEach>
						</tbody>
					</table>

				</div>
				<!-- <div class="card-footer text-muted">2 days ago</div> -->
			</div>

		</div>
	</div>

	<!-- Page footer -->
	<jsp:include page="/WEB-INF/views/layouts/footer.jsp" />
</body>
</html>
