<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<br>
<br>


<article class="row">
	<div class="col-md-2 col-sm-2 hidden-xs" onload="myFunction()">
		<figure class="thumbnail">
			<c:choose>
				<c:when test="${user.encodedImage != null}">
					<img src="data:image/jpeg;base64,${user.encodedImage}"
						style="width: 200px; height: 180px">
				</c:when>
				<c:otherwise>
					<img src="http://www.cenpatico.com/files/2014/01/noprofile.gif"
						style="width: 200px; height: 180px">
				</c:otherwise>
			</c:choose>
			<figcaption class="text-center">
				<c:out value="${user.firstName}"></c:out>
				<c:out value="${user.lastName}"></c:out>
			</figcaption>
		</figure>
	</div>


	<table class="table table-bordered table-stripped">
		<tr>
			<th>Profile Picture</th>
			<td><form enctype="multipart/form-data" method="post"
					action="${pageContext.request.contextPath}/updateProfilePic">
					<div class="col-md-4">
						<input type="file" name="image">
					</div></td>
			<td><label class="col-md-4 control-label" for="singlebutton"></label>

				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Update</button>
				</form></td>
		</tr>

		<tr>
			<th>First Name</th>
			<td><form method="post"
					action="${pageContext.request.contextPath}/updateFirstName">
					<input class="form-control input-md" value="${user.firstName}"
						name="firstName" type="text" /></td>
			<td><label class="col-md-4 control-label" for="singlebutton"></label>
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Update</button>
				</form></td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td><form method="post"
					action="${pageContext.request.contextPath}/updateLastName">
					<input class="form-control input-md" value="${user.lastName}"
						name="lastName" type="text" /></td>
			<td><label class="col-md-4 control-label" for="singlebutton"></label>
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Update</button>
				</form></td>
		</tr>

		<tr>
			<th>Date of Birth</th>
			<td><form method="post"
					action="${pageContext.request.contextPath}/updateDob">
					<input value="${user.dateOfBirth}" id="dateOfBirth"
						name="dateOfBirth" type="text" class="form-control input-md" /></td>
			<td><label class="col-md-4 control-label" for="singlebutton"></label>
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Update</button>
				</form></td>
		</tr>
		<tr>
			<th>Gender</th>
			<td><form method="post"
					action="${pageContext.request.contextPath}/updateGender">
					<label for="male">Male</label> <input type="radio" name="gender"
						id="male" value="Male" checked="checked"> <label
						for="female">Female</label> <input type="radio" name="gender"
						id="female" value="Female"></td>
			<td><label class="col-md-4 control-label" for="singlebutton"></label>
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Update</button>
				</form></td>
		</tr>
		<tr>
			<th>About</th>
			<td><form method="post"
					action="${pageContext.request.contextPath}/updateAbout">
					<input class="form-control input-md" value="${user.about}"
						name="about" type="text" /></td>
			<td><label class="col-md-4 control-label" for="singlebutton"></label>
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Update</button>
				</form></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><form method="post"
					action="${pageContext.request.contextPath}/updatePassword">
					<input class="form-control input-md" name="password" required="required"
						type="password" placeholder="&#8226&#8226&#8226&#8226&#8226&#8226&#8226&#8226&#8226&#8226&#8226"/></td>
			<td><label class="col-md-4 control-label" for="singlebutton"></label>
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">Update</button>
				</form></td>
		</tr>
	</table>


	<c:choose>
		<c:when test="${forum.isEmpty()}"></c:when>
		<c:otherwise>
			<h3>User Forums</h3>
			<table class="table table-bordered table-stripped">
				<tr>
					<th>Date</th>
					<th>Title</th>
					<th>Likes</th>
				</tr>
				<c:forEach var="forum" items="${forum}">
					<tr>
						<td>${forum.date}</td>
						<td><a
							href="${pageContext.request.contextPath}/forum/${forum.id}">${forum.forumTitle}</a>
						</td>
						<td>${forum.count}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</article>

<script type="text/javascript">
	var gender = "${user.gender}";
	if (gender == "Female") {
		document.getElementById("female").checked = true;
	} else {
		document.getElementById("male").checked = true;
	}
</script>