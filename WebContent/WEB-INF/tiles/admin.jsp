<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<br>
<br>
<h3>Authorized Users Only</h3>

<table class="table table-bordered table-stripped">
	<tr>
		<th>Email</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Role</th>
		<th></th>
		
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><a href="${pageContext.request.contextPath}/userprofile/${user.username}"><c:out value="${user.username}"></c:out></a></td>
			<td><c:out value="${user.firstName}"></c:out></td>
			<td><c:out value="${user.lastName}"></c:out></td>
			<td><c:out value="${user.authority}"></c:out></td>
			
			<c:choose>
				<c:when test="${user.enabled}">
					<td><div align="center">
							<form id="form" method="POST" action="${pageContext.request.contextPath}/disableUser/${user.username}">
								<button id="submite" name="singlebutton" class="btn btn-primary"
									type="submit">Disable</button>
							</form>
						</div></td>
				</c:when>
				<c:otherwise>
					<td><div align="center">
							<form id="form" method="POST" action="${pageContext.request.contextPath}/enableUser/${user.username}">
								<button id="submite" name="singlebutton" class="btn btn-primary"
									type="submit">Enable</button>
							</form>
						</div></td>
				</c:otherwise>
			</c:choose>
	</c:forEach>
</table>

