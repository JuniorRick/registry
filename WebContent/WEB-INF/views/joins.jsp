<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/layouts/header.jsp" />
<title>Atribuire investigatii</title>
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
			</button>


			<div class="collapse show"
				id="collapseInput">
				<div class="card-body">
					<form:form action="joins/filter" modelAttribute="relation" method="GET">

						<div class="form-group row">

							<label class="col-sm-2 col-form-label" for="">Doctor</label>
							<div class="col-sm-6">
								<select id="doctor_id" name="doctor_id" class="form-control">
									<option value="NONE">-- Selectati doctor --</option>
									<c:forEach items="${doctors}" var="doctor">
										<option value="${doctor.id}" >${doctor.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">

							<label class="col-sm-2 col-form-label" for="">Secție</label>
							<div class="col-sm-6">
								<select id="section_id" name="section_id" class="form-control">
									<option value="NONE">-- Selectati Secția --</option>
									<c:forEach items="${sections}" var="section">
										<option value="${section.id}" ${section_id == section.id ? 'selected' : '' }>${section.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="clearfix">
							<hr>
							<input type="submit" class="btn btn-primary float-right"
								value="Filtrare"> <a
								href="${pageContext.request.contextPath}/joins"
								class="btn float-right mr-2 btn-info">Anulare</a>
						</div>
					</form:form>

				</div>
			</div>
		</div>

		<div class="mt-2"></div>

		<div class="card">
			<div class="card-header" data-toggle="collapse">
				<h4>${ doctor != null ? doctor.name : ''}</h4>
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
							<c:forEach var="investigation" items="${investigations}" varStatus="loop">

								<tr>
									<th class="custom-action-width" scope="row">${loop.index + 1}</th>
									<td>${investigation.name}</td>
									<c:set var="contains" value="false" />
									<c:forEach var="item" items="${doctor.investigations}">
									  <c:if test="${item.id eq investigation.id}">
									    <c:set var="contains" value="true" />
									  </c:if>
									</c:forEach>
									<td class="custom-action-width">
										<button class="btn btn-sm toggle-investigation ${ contains ? 'btn-warning' : 'btn-primary' }"
											data-id = "${investigation.id}">
											${ contains ? 'Elimină' : 'Adaugă' }
										</button></td>
								</tr>

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
	
	<script>
		$(document).ready( function() {
			$('.toggle-investigation').click( function() {
				button = $(this);
				id = button.data('id');
				$.ajax({
					type : 'GET',
					url : '${pageContext.request.contextPath}/joins/assign/' + id,
					success : function(data) {
						if(data == "removed") {							
							button.text("Adauga");
							button.toggleClass("btn-primary btn-warning");
						} else {
							button.text("Elimina");
							button.toggleClass("btn-primary btn-warning");
						}
						
					},
					failure : function(errMsg) {
						alert(errMsg);
					}
				});
			})
		})
	</script>
</body>
</html>
