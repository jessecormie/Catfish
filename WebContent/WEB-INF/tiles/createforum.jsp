<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
	<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<br>
<br>
<div class="container" >
	<div class="row">
		<div class="col-md-4 col-md-offset-4">

			<sf:form method="post"
				action="${pageContext.request.contextPath}/docreate"
				commandName="forum" role="form" >
				<br style="clear: both">
				<h3 style="margin-bottom: 25px; text-align: left;">Create a Forum</h3>
				<div class="form-group">
					<sf:input class="form-control" path="forumTitle" name="forumTitle"
						type="text" placeholder="Title" />
					<br />
					<sf:errors path="forumTitle" cssClass="error"></sf:errors>
				</div>
				<div class="form-group">
					<sf:textarea class="form-control" path="forumContent"
						name="forumContent" rows="10" cols="20" placeholder="Content"></sf:textarea>
					<br />
					<sf:errors path="forumContent" cssClass="error"></sf:errors>
				</div>
				<button type="submit" id="submit" name="submit"
					class="btn btn-primary pull-right">Save Forum</button>
			</sf:form>
		</div>
	</div>
</div>