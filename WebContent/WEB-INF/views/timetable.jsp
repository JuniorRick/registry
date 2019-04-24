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

	<div class="container-fluid">
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
								<input type="text" class="w-100" id="datepicker2" disabled>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="col-box">
									<h4 class="text-center mt-3">De la:</h4>
								</div>
								<div class="col-box">
									<input type="text" id="from-time" class="timepicker w-100" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="col-box">
									<h4 class="text-center mt-3">Până la:</h4>
								</div>
								<div class="col-box">
									<input type="text" id="to-time" class="timepicker w-100" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="col-box">
									<h4 class="text-center mt-3">
										Interval: <span id="interval-output"></span> min
									</h4>
								</div>
								<div class="col-box">
									<input type="range" min="5" max="120" step="5" value="15"
										id="interval-input" class="form-control-range">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col">

								<div class="col-box">
									<label for="">Doctor:</label><br> <select
										class="selectpicker w-100">
										<option>Mustard</option>
										<option>Ketchup</option>
										<option>Barbecue</option>
									</select>
								</div>
								<div class="col-box">
									<label for="">Investigație:</label><br> <select
										class="selectpicker w-100">
										<option>Mustard</option>
										<option>Ketchup</option>
										<option>Barbecue</option>
									</select>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="col-box">
									<div class="clearfix">
										<hr>
										<button class="btn btn-primary float-right" id="generate">Generare</button>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>

			</div>

			<div class="col" >
				<div id="generation-output"></div>
			</div>
		</div>
	</div>

	<!-- Page footer -->
	<jsp:include page="/WEB-INF/views/layouts/footer.jsp" />

	<script>
		$(document).ready(
				function() {

					$('#datepicker').datepicker({

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

					$(function() {
						$(".timepicker").timepicker({
							timeFormat : 'HH:mm',
							minTime : '6',
							maxTime : '20'
						});
					});
					
					$('#interval-output').text($('#interval-input').val());

					$('#interval-input').change(function() {
						$('#interval-output').text($('#interval-input').val());
					});
					
					
					$('#generate').click( function() {
						from = $('#from-time').val();
						to = $('#to-time').val();
						
						interval = $('#interval-input').val();
						moment.locale('cs');
						time = moment(from, 'HH:mm');
						endTime = moment(to, 'HH:mm');
						
						$('.hour-box').remove();
						
						while(time.isBefore(endTime)) {
							$('#generation-output').append('<div class="hour-box">' + moment(time, 'HH:mm').format('HH:mm') + '</div>');
							time = moment(time, 'HH:mm').add(interval, 'minutes');
						}
					});
					
					$('body').on('click', '.hour-box', function() {
						console.log("clicked");
						$(this).toggleClass('change-color');
					})

				});
	</script>
</body>
</html>
