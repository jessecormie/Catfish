<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<br>
<br>
<div class="container">
	<h2>Catfish Forums</h2>
	<div class="col-md-8">
		<p>
			Catfish forums provide you with a place to share experiences with one
			another whether you have been catfished or even are the catfish.
			These forums aim to inform you on how to identify catfish, and offer
			a supportive community for people who have been victims of catfishing
			or simply provide an interesting read if you're someone who is
			intrigued by the catfishing phenomenon. Everyone is expected to
			follow the <a href="#" data-toggle="popover" title="Rules"
				data-content="<ul><li>Be nice to each other</li>
				<li>Vote based on quality, not personal opinion</li>
				<li>Posting 'Is this a catfish?' With just a few pictures isn't very helpful to us and will make it very difficult to find help you. Tell us your story, how did you meet? How long have you been speaking? What makes you think this is a catfish?</li>
				</ul>"
				data-html="true"> rules.</a>
		</p>
	</div>
</div>
<div class="comments-nav">
	<ul class="nav nav-pills">
		<li role="presentation" class="dropdown"><a
			class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
			aria-haspopup="true" aria-expanded="false"> ${fn:length(forum)}
				forums <span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="${pageContext.request.contextPath}/forum">Date</a></li>
				<li><a href="${pageContext.request.contextPath}/likes">Likes</a></li>
			</ul></li>
	</ul>
</div>


<c:forEach var="forum" items="${forum}">
	<article class="row">
		<div class="col-md-2 col-sm-2 hidden-xs">
			<figure class="thumbnail">
				<c:choose>
					<c:when test="${forum.user.encodedImage != null}">
						<img class="img-responsive"
							src="data:image/jpeg;base64,${forum.user.encodedImage}"
							style="width: 100px; height: 100px">
					</c:when>
					<c:otherwise>
						<img class="img-responsive"
							src="http://www.cenpatico.com/files/2014/01/noprofile.gif"
							style="width: 100px; height: 100px">
					</c:otherwise>
				</c:choose>
				<figcaption class="text-center">
					<c:out value="${forum.user.firstName}"></c:out>
					<c:out value="${forum.user.lastName}"></c:out>
				</figcaption>
			</figure>
		</div>
		<header class="text-left">
			<div class="media">
				<div class="col-md-10 col-sm-10">
					<div class="panel panel-default arrow left">
						<div class="panel-body">
							<div class="media">
								<font size="5"><b><c:out value="${forum.forumTitle}"></c:out></b></font>
								<div class="media-heading">
									<span class="label label-info">${forum.count}</span>
									${forum.date}
								</div>
								<!-- <div class="media-left"></div> -->

								<div class="media-body">
									<p>
										<font size="4"><a
											href="${pageContext.request.contextPath}/forum/${forum.id}">Read
												more...</a></font>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
	</article>
</c:forEach>
<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});
</script>