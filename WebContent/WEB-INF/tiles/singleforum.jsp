<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<br>
<br>
<br>
<c:forEach var="forum" items="${forumList}">
	<article class="row">

		<div class="col-md-2 col-sm-2 hidden-xs">
			<figure class="thumbnail">
				<c:choose>
					<c:when test="${forum.user.encodedImage != null}">
						<img class="img-responsive"
							src="data:image/jpeg;base64,${forum.user.encodedImage}"
							style="width: 200px; height: 180px">
					</c:when>
					<c:otherwise>
						<img class="img-responsive"
							src="http://www.cenpatico.com/files/2014/01/noprofile.gif"
							style="width: 200px; height: 180px">
					</c:otherwise>
				</c:choose>
				<figcaption class="text-center">
					<a href="${pageContext.request.contextPath}/userprofile/${forum.user.username}">
						<c:out value="${forum.user.firstName}"></c:out> <c:out
							value="${forum.user.lastName}"></c:out>
					</a>
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
								<div class="media-left">
									<div class="vote-wrap">

										<div class="vote up">
											<form
												action="${pageContext.request.contextPath}/addForumLike/${forum.id}">
												<button class="glyphicon glyphicon-menu-up"></button>
											</form>
										</div>
										<div class="vote inactive">
											<form
												action="${pageContext.request.contextPath}/addForumUnlike/${forum.id}">
												<button class="glyphicon glyphicon-menu-down"></button>
											</form>
										</div>
									</div>
									<!-- vote-wrap -->
								</div>

								<div class="media-body">
									<p>${forum.forumContent}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
	</article>
</c:forEach>

<div class="container">
	<div class="post-comments">

		<c:forEach var="forum" items="${forumList}">
			<form method="post"
				action="${pageContext.request.contextPath}/docreateComment/${forum.id}">
				<div class="form-group">
					<label for="comment">Your Comment</label>
					<textarea name="comment" class="form-control" rows="3"></textarea>
				</div>
				<button type="submit" class="btn btn-default">Send</button>
			</form>
		</c:forEach>


		<c:forEach var="forum" items="${forumList}">

			<div class="comments-nav">
				<ul class="nav nav-pills">
					<li role="presentation" class="dropdown"><a
						class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false">
							${fn:length(forum.comments)} comments <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/forum/${forum.id}">Date</a></li>
							<li><a
								href="${pageContext.request.contextPath}/likes/${forum.id}">Likes</a></li>
						</ul></li>
				</ul>
			</div>
		</c:forEach>
		<c:forEach var="forum" items="${forumList}">
			<c:forEach var="comments" items="${forum.comments}" varStatus="i2">
				<div class="row">

					<div class="media">
						<!-- first comment -->

						<div class="media-heading">
							<button class="btn btn-default btn-xs" type="button"
								data-toggle="collapse"
								data-target="#<c:out value="${(i2.index)+3000}"/>"
								aria-expanded="false" aria-controls="collapseExample">
								<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
							</button>
							<span class="label label-info">${comments.count}</span>
							${comments.user.firstName} ${comments.user.lastName} -
							${comments.date}
						</div>

						<div class="panel-collapse collapse in"
							id="<c:out value="${(i2.index)+3000}"/>">

							<div class="media-left">
								<div class="vote-wrap">
									<!-- <div class="save-post"> -->
									<!--  <a href="#"><span class="glyphicon glyphicon-star"
											aria-label="Save"></span></a>  -->
									<!-- </div> -->
									<div class="vote up">
										<form
											action="${pageContext.request.contextPath}/addLike/${comments.id}/${forum.id}">
											<button class="glyphicon glyphicon-menu-up"></button>
										</form>
									</div>
									<div class="vote inactive">
										<form
											action="${pageContext.request.contextPath}/addUnlike/${comments.id}/${forum.id}">
											<button class="glyphicon glyphicon-menu-down"></button>
										</form>
									</div>
								</div>
								<!-- vote-wrap -->
							</div>
							<!-- media-left -->

							<div class="media-body">
								<p>${comments.content}</p>
								<div class="comment-meta">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										
									</sec:authorize>
									<span> <a class="" role="button" data-toggle="collapse"
										href="#<c:out value="${(i2.index)+1000} "/>"
										aria-expanded="false" aria-controls="collapseExample">reply</a>
									</span>
									<div class="collapse" id="<c:out value="${(i2.index)+1000}"/>">
										<form
											action="${pageContext.request.contextPath}/reply/${comments.id}/${forum.id}">
											<div class="form-group">
												<label for="comment">Your Comment</label>
												<textarea name="comment" class="form-control" rows="3"></textarea>
											</div>
											<button type="submit" class="btn btn-default">Send</button>
										</form>
									</div>
								</div>
								<!-- comment-meta -->
								<c:forEach var="r" items="${comments.replies}" varStatus="i">
									<div class="media">
										<!-- answer to the first comment -->
										<div class="media-heading">
											<button class="btn btn-default btn-collapse btn-xs"
												type="button" data-toggle="collapse"
												data-target="#<c:out value="${(i.index)+2000}"/>"
												aria-expanded="false" aria-controls="collapseExample">
												<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
											</button>
											<span class="label label-info">${r.count}</span>
											${r.user.firstName} ${r.user.lastName} - ${r.date}
										</div>


										<div class="panel-collapse collapse in"
											id="<c:out value="${(i.index)+2000}"/>">

											<div class="media-left">
												<div class="vote-wrap">
													<div class="save-post">
														<!-- <a href="#"><span class="glyphicon glyphicon-star"
															aria-label="Save"></span></a> -->
													</div>
													<div class="vote up">
														<form
															action="${pageContext.request.contextPath}/addReplyLike/${comments.id}/${forum.id}/${r.id}">
															<button class="glyphicon glyphicon-menu-up"></button>
														</form>
													</div>
													<div class="vote inactive">
														<form
															action="${pageContext.request.contextPath}/addReplyUnlike/${comments.id}/${forum.id}/${r.id}">
															<button class="glyphicon glyphicon-menu-down"></button>
														</form>
													</div>
												</div>
												<!-- vote-wrap -->
											</div>
											<!-- media-left -->


											<div class="media-body">
												<p>${r.content}</p>
												<div class="comment-meta">
													<sec:authorize access="hasRole('ROLE_ADMIN')">
														<span><a href="#">delete</a></span>
													</sec:authorize>
													<div class="collapse"
														id="<c:out value="${(i.index+5000)}"/>">
														<form>
															<div class="form-group">
																<label for="comment">Your Comment</label>
																<textarea name="comment" class="form-control" rows="3"></textarea>
															</div>
															<button type="submit" class="btn btn-default">Send</button>
														</form>
													</div>
												</div>
												<!-- comment-meta -->
											</div>
										</div>
										<!-- comments -->
									</div>
								</c:forEach>
								<!-- answer to the first comment -->
							</div>
						</div>
						<!-- comments -->
					</div>
				</div>
			</c:forEach>
		</c:forEach>
	</div>
	<!-- post-comments -->
</div>

<script>
	$('[data-toggle="collapse"]')
			.on(
					'click',
					function() {
						var $this = $(this), $parent = typeof $this
								.data('parent') !== 'undefined' ? $($this
								.data('parent')) : undefined;
						if ($parent === undefined) {
							$this.find('.glyphicon').toggleClass(
									'glyphicon-plus glyphicon-minus');
							return true;
						}
						var currentIcon = $this.find('.glyphicon');
						currentIcon
								.toggleClass('glyphicon-plus glyphicon-minus');
						$parent.find('.glyphicon').not(currentIcon)
								.removeClass('glyphicon-minus').addClass(
										'glyphicon-plus');
					});
</script>