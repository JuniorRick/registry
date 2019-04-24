<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/layouts/header.jsp" />


<title>sections</title>
</head>
<body>

	<!-- Navigation menu -->
	<jsp:include page="/WEB-INF/views/layouts/nav.jsp" />


	<div class="container-fluid ">

		<div class="row">
			<div class="col" style="max-width: 300px">
				<div class="row ">
					<div class="col bg-white">
						<div class="row">
							<div class="col">
								<div id="datepicker"></div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<input type="text" id="datepicker2" disabled>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="col-box">
									<h4 class="text-center mt-3">Filtre</h4>
								</div>
								<div class="col-box">
									<label for="">Doctor:</label><br> 
									<select class="selectpicker w-100">
										<option>Mustard</option>
										<option>Ketchup</option>
										<option>Barbecue</option>
									</select>
								</div>
								<div class="col-box">
									<label for="">Investigație:</label><br> 
									<select	class="selectpicker w-100">
										<option>Mustard</option>
										<option>Ketchup</option>
										<option>Barbecue</option>
									</select>
								</div>
							</div>
						</div>

					</div>
				</div>

			</div>
			<div class="col bg-white">
				<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Data</th>
							<th scope="col">Ora</th>
							<th scope="col">Doctor</th>
							<th scope="col">Examen</th>
							<th scope="col">Sectie</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${doctors}" var="doctor">
							<c:forEach items="${doctor.investigations}" var="investigation">
							<c:if test="${investigation.section.name == section.name}">
								<tr>
									<td></td>
									<td><fmt:formatDate value="${now}" pattern="dd-MM-yyyy" /> ${now }</td>
									<td><fmt:formatDate value="${now}" pattern="HH:mm:ss" /> ${now } </td>
									<td>${doctor.name}</td>
									<td>${investigation.name}</td>
									<td>${investigation.section.name}</td>
									
								</tr>							
							</c:if>
							</c:forEach>
						</c:forEach>						
					</tbody>

				</table>
			</div>
		</div>

	</div>

	<!-- Page footer -->
	<jsp:include page="/WEB-INF/views/layouts/footer.jsp" />



	<script>
		/** Days to be disabled as an array */
		var disableddates = [ "4-3-2019", "4-11-2019", "4-25-2019", "4-20-2019" ];

		function DisableSpecificDates(date) {

			var m = date.getMonth();
			var d = date.getDate();
			var y = date.getFullYear();

			// First convert the date in to the mm-dd-yyyy format 
			// Take note that we will increment the month count by 1 
			var currentdate = (m + 1) + '-' + d + '-' + y;

			// We will now check if the date belongs to disableddates array 
			for (var i = 0; i < disableddates.length; i++) {

				// Now check if the current date is in disabled dates array. 
				if ($.inArray(currentdate, disableddates) != -1) {
					return [ false ];
				}
			}

			// In case the date is not present in disabled array, we will now check if it is a weekend. 
			// We will use the noWeekends function
			var weekenddate = $.datepicker.noWeekends(date);
			return weekenddate;

		}

		$(document).ready(
				function() {
					$('#datepicker').datepicker(
							{
								beforeShowDay : DisableSpecificDates,
								inline : true,
								onSelect : function(dateText) {
									$('#datepicker2').datepicker("setDate",
											$(this).datepicker("getDate"));
								}
							});

					$(function() {
						$("#datepicker2").datepicker({

						});
					});
				});
	</script>
</body>
</html>