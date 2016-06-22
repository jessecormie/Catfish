<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<br>
<script type="text/javascript">
	$(document).ready(function() {
		document.f.j_username.focus();
	});
</script>

<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Login</h3>
				</div>
				<div class="panel-body">
					<c:if test="${param.error != null}">
						<p class="error">Login failed. Check that your email and
							password are correct.</p>
					</c:if>		
					
					<h4>Email</h4>
					<form name='f'
						action='${pageContext.request.contextPath}/j_spring_security_check'
						method='POST' accept-charset="UTF-8">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="yourmail@example.com"
									name="j_username" type="text" value="${user.username}">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password"
									name="j_password" type="password" value="${user.password}">
							</div>
							<div class="checkbox">
								<label> <input name="_spring_security_remember_me"
									type="checkbox" value="Remember Me"> Remember Me
								</label>
							</div>
							<input class="btn btn-lg btn-success btn-block" type="submit"
								value="Login">
						</fieldset>
					</form>

					<center>
						<h4>OR</h4>
					</center>

					<form action="<c:url value="/newaccount"/>">
						<input type=submit value="Register"
							class="btn btn-lg btn-primary btn-block">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>