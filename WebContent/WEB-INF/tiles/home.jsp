<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/js"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/js/bootstrap.min.js">
<link href='https://fonts.googleapis.com/css?family=Slabo+27px'
	rel='stylesheet' type='text/css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<br>
<br>
<br>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<div id="carousel-example-generic" class="carousel slide"
	data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0"
			class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner">
		<div class="item active">
			<img
				src="${pageContext.request.contextPath}/static/images/Catfish4.jpg"
				alt="...">
			<!-- <div class="carousel-caption">
				<h3>Caption Text</h3>
			</div> -->
		</div>
		<div class="item">
			<img
				src="${pageContext.request.contextPath}/static/images/Catfish5.jpg"
				alt="...">
			<!-- <div class="carousel-caption">
				<h3>Caption Text</h3>
			</div> -->
		</div>
		<div class="item">
			<img
				src="${pageContext.request.contextPath}/static/images/Catfish6.jpg"
				alt="...">
			<!-- <div class="carousel-caption">
				<h3>Caption Text</h3>
			</div> -->
		</div>
	</div>

	<!-- Controls -->
	<a class="left carousel-control" href="#carousel-example-generic"
		role="button" data-slide="prev"> <span
		class="glyphicon glyphicon-chevron-left"></span>
	</a> <a class="right carousel-control" href="#carousel-example-generic"
		role="button" data-slide="next"> <span
		class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>

<script type="text/javascript">
	var tag = document.createElement('script');

	tag.src = "https://www.youtube.com/iframe_api";
	var firstScriptTag = document.getElementsByTagName('script')[0];
	firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

	var player;
	var playerModal = $('#playerModal');

	function onYouTubeIframeAPIReady() {
		player = new YT.Player('player', {
			height : '390',
			width : '640',
			videoId : 'BuE98oeL-e0'
		});
	}

	playerModal.on('show.bs.modal', function(e) {
		player.playVideo();
	});

	playerModal.on('hidden.bs.modal', function(e) {
		player.pauseVideo();
		player.stopVideo();
	});
</script>



<div class="modal fade" id='playerModal' role='dialog' tabindex='-1'>
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" aria-label='Close' data-dismiss='modal'
					type='button'>
					<span aria-hidden='true'>×</span>
				</button>
				<h4 class="modal-title">Catfish Documentary</h4>
			</div>
			<div class="modal-body">
				<div class="embed-responsive embed-responsive-16by9">
					<div id="player" class="embed-responsive-item"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss='modal' type='button'>Close</button>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="row">
		<!-- <div class="well"> -->
		<h1 class="text-center">What is a Catfish?</h1>
		<div class="list-group">
			<!-- <a href="#" class="list-group-item active"> -->
			<div class="media col-md-3">
				<figure class="pull-left">
					<img class="media-object img-rounded img-responsive"
						src="${pageContext.request.contextPath}/static/images/CatfishTrailer.jpg"
						alt="catfishTrailer">
				</figure>
			</div>
			<div class="col-md-6">
				<h4 class="list-group-item-heading">Background</h4>
				<p class="list-group-item-text">For centuries, a catfish was
					merely a type of fish with a distinctive face. Then, in 2010, Ariel
					Schulman released Catfish, a documentary about his brother Nev's
					experiences with a woman who pretended to be someone else online.
					(The movie was popular enough to spawn a television show by the
					same title.) In the documentary, the woman's husband explained the
					title with an anecdote about how fishermen transporting live cod
					used to put catfish in with the cod on long-haul shipments to keep
					the desirable cod active and alert until arrival. The man implied
					that his wife was like those catfish, keeping the lives of others
					fresh and interesting.</p>
				<br>
				<p align="center">

					<a href='#myModal' class='btn btn-primary btn-lg'
						data-toggle='modal' data-target='#playerModal'> YouTube Video
					</a>
				</p>
			</div>

			<div class="col-md-3 text-center">
				<img class="media-object img-rounded img-responsive"
					src="${pageContext.request.contextPath}/static/images/CatfishTheTVShow.jpg"
					alt="catfishTrailer">

			</div>
		</div>
	</div>
</div>


<br>

<!--Get image for link-->

<div class="row">
	<div class="col-lg-12">
		<div id="myDiv">
			<img border="5"
				src="${pageContext.request.contextPath}/static/images/Catfish7.jpg"
				align="left"
				onmouseover="this.src='${pageContext.request.contextPath}/static/images/photo1.jpg'"
				onmouseout="this.src='${pageContext.request.contextPath}/static/images/Catfish7.jpg'"
				width=33.33% height=250 />
		</div>
		<div id="myDiv2">
			<img
				src="${pageContext.request.contextPath}/static/images/Catfish1.jpg"
				align="right"
				onmouseover="this.src='${pageContext.request.contextPath}/static/images/photo3.jpg'"
				onmouseout="this.src='${pageContext.request.contextPath}/static/images/Catfish1.jpg'"
				width=33.33% height=250 />
		</div>
		<div id="myDiv3">
			<img border="5"
				src="${pageContext.request.contextPath}/static/images/Catfish3.jpg"
				align="left"
				onmouseover="this.src='${pageContext.request.contextPath}/static/images/photo2.jpg'"
				onmouseout="this.src='${pageContext.request.contextPath}/static/images/Catfish3.jpg'"
				width=33.33% height=250 />
		</div>


	</div>
</div>
<!--Code to make image a link-->
<script>
	var a = document.createElement('a');
	a.href = '${pageContext.request.contextPath}/forum';//link that the picture will bring the user to
	var image = document.getElementById('myDiv').getElementsByTagName('img')[0];//gets the image that is being used as the link
	b = a.appendChild(image);
	document.getElementById('myDiv').appendChild(a);
</script>
<script>
	var a = document.createElement('a');
	a.href = '${pageContext.request.contextPath}/createforum';
	var image = document.getElementById('myDiv2').getElementsByTagName('img')[0];
	b = a.appendChild(image);
	document.getElementById('myDiv2').appendChild(a);
</script>
<script>
	var a = document.createElement('a');
	a.href = '<c:url value = '/catfishform'/>';
	var image = document.getElementById('myDiv3').getElementsByTagName('img')[0];
	b = a.appendChild(image);
	document.getElementById('myDiv3').appendChild(a);
</script>