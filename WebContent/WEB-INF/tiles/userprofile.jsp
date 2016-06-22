<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<div class="row">
<div class="fb-profile">
	<img align="left" class="fb-image-lg"
		src="http://images.freeimages.com/images/previews/eb8/grunge-photos-grey-1142280.jpg"
		alt="Profile image example" />
	<c:choose>
		<c:when test="${user.encodedImage != null}">
			<img align="left" style="width: 180px; height: 200px"
				class="fb-image-profile thumbnail"
				src="data:image/jpeg;base64,${user.encodedImage}"
				alt="Profile image example" />
		</c:when>
		<c:otherwise>
			<img align="left" style="width: 180px; height: 200px"
				class="fb-image-profile thumbnail"
				src="http://www.cenpatico.com/files/2014/01/noprofile.gif"
				alt="Profile image example" />

		</c:otherwise>
	</c:choose>
	<div class="fb-profile-text">
		<h1>${user.firstName} ${user.lastName}</h1>

	</div>
</div>
</div>
<div class="container">
	<div class="row">
<div class="col-md-6">
		<ul class="list-group">
			<li class="list-group-item text-muted">Profile</li>
			<li class="list-group-item text-right"><span class="pull-left"><strong>Email</strong></span>${user.username}</li>
			<c:choose> <c:when test="${!user.gender.isEmpty()}">
			<li class="list-group-item text-right"><span class="pull-left"><strong>Gender</strong></span>${user.gender}</li>
			</c:when>
			<c:otherwise></c:otherwise>
			</c:choose>
			<c:choose> <c:when test="${!user.dateOfBirth.isEmpty()}">
			<li class="list-group-item text-right"><span class="pull-left"><strong>Date
						of Birth</strong></span>${user.dateOfBirth}</li>
						</c:when>
			<c:otherwise></c:otherwise>
			</c:choose>
			<c:choose> <c:when test="${!user.about.isEmpty()}">
			<li class="list-group-item text-right"><span class="pull-left"><strong>About</strong></span>${user.about}</li>
			</c:when>
			<c:otherwise></c:otherwise>
			</c:choose>
		</ul>
</div>
<div class="col-md-6">
		<c:choose>
			<c:when test="${forum.isEmpty()}"></c:when>
			<c:otherwise>
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
	</div>


	</div>

</div>

<style>
.fb-profile img.fb-image-lg{
    z-index: 0;
    width: 100%;  
    height: 180px;
    margin-bottom: 10px;
}

.fb-image-profile
{
    margin: -90px 10px 0px 50px;
    z-index: 9;
    width: 20%; 
}

@media (max-width:768px)
{
    
.fb-profile-text>h1{
    font-weight: 700;
    font-size:16px;
}

.fb-image-profile
{
    margin: -45px 10px 0px 25px;
    z-index: 9;
    width: 20%; 
}
</style>