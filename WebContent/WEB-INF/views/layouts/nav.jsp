
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<link href="https://fonts.googleapis.com/css?family=Niramit"
	rel="stylesheet">


<nav class="navbar navbar-expand-lg nav-top">
	<a class="navbar-brand" href="#"> <img
		src="<c:url value="/resources/images/IMSP_CRDM.png" />"
		style="width: 40px; height: auto;" alt="" />
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor03" aria-controls="navbarColor03"
		aria-expanded="false" aria-label="Toggle navigation">
		<i class="fa fa-bars"></i>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor03">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item" id="home-link"><a class="nav-link"
				href="${pageContext.request.contextPath}/">Home<span class="sr-only">(current)</span></a></li>



			<li class="nav-item" id="new-release-link"><a class="nav-link"
				href="${pageContext.request.contextPath}/sections">Sections</a></li>

		</ul>

		<form class="form-inline ">
			<input class="form-control mr-sm-2"
				placeholder="Search"
				aria-label="Search" type="search" id="search">
			<!-- 			<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button> -->
		</form>

	</div>
</nav>


<style>
.navbar {
	padding-left: 10% !important;
	padding-right: 10% !important;
}
</style>