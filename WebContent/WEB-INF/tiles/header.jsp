<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">

<br>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="height: 85px">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value = '/'/>"><img
				src="${pageContext.request.contextPath}/static/images/Drawing1.png"
				alt="..."></a>
		</div>
		<div class="collapse navbar-collapse" 
			id="bs-example-navbar-collapse-1" >
			<br>
			<ul class="nav navbar-nav navbar-right">
			
				<li><a href="${pageContext.request.contextPath}/profile"><img
				src="${pageContext.request.contextPath}/static/images/Profile.png"
				alt="..."></a></li>
				<li><a data-toggle="dropdown"><img
				src="${pageContext.request.contextPath}/static/images/Forums.png"
				alt="..."></a><ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/forum">View Forums</a></li>
          <li><a href="${pageContext.request.contextPath}/createforum">Create Forum</a></li>
        
        </ul></li>
				<li><a href="<c:url value = '/catfishform'/>"><img
				src="${pageContext.request.contextPath}/static/images/CatfishChecker.png"
				alt="..."></a></li>
				<li><sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="<c:url value = '/admin'/>"><img
				src="${pageContext.request.contextPath}/static/images/Admin.png"
				alt="..."></a>
					</sec:authorize></li>
				<li><sec:authorize access="!isAuthenticated()">
						<a class="login" href="<c:url value = '/login'/>"><img
				src="${pageContext.request.contextPath}/static/images/Login.png"
				alt="..."></a>
					</sec:authorize> <sec:authorize access="isAuthenticated()">
						<a class="login"
							href="<c:url value = '/j_spring_security_logout'/>"><img
				src="${pageContext.request.contextPath}/static/images/LogOut.png"
				alt="..."></a>
					</sec:authorize></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
<%-- 
<a class="title" href="<c:url value = '/'/>"><img align="middle"
	src="https://themindlessphilosopher.files.wordpress.com/2012/12/catfish-the-tv-show-logo.jpg"
	alt="Catfish" style="width: 310px; height: 80px;"></a> --%>

