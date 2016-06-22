<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<br>
<div class="container">
	<div class="row bs-wizard" style="border-bottom: 0;">
		<div class="col-xs-4 bs-wizard-step complete">
			<div class="text-center bs-wizard-stepnum">Step 1</div>
			<div class="progress">
				<div class="progress-bar"></div>
			</div>
			<span class="bs-wizard-dot"></span>
		</div>
		<div class="col-xs-4 bs-wizard-step active">
			<!-- complete -->
			<div class="text-center bs-wizard-stepnum">Step 2</div>
			<div class="progress">
				<div class="progress-bar"></div>
			</div>
			<span class="bs-wizard-dot"></span>
		</div>
		<div class="col-xs-4 bs-wizard-step disabled">
			<!-- complete -->
			<div class="text-center bs-wizard-stepnum">Step 3</div>
			<div class="progress">
				<div class="progress-bar"></div>
			</div>
			<span class="bs-wizard-dot"></span> <span class="bs-wizard-dot"></span>
		</div>
	</div>

	<form id="form" method="POST" enctype="multipart/form-data"
		action="catfishreverseimage" class="form-horizontal">
		<fieldset>
			<legend align="center">
				Select the Images where you see the Suspect <a href="#"
					data-toggle="popover"
					data-content="These are images that we found online that are visually similar to the image you uploaded. Selecting with images which the suspected catfish is in will help us determine a probability for you!"
					data-html="true"><span
					class="glyphicon glyphicon-question-sign"></span></a>
			</legend>
			<br>
			<!-- Text input-->
			<div class="form-group" align="center">
				<label for="images">
				
				<img src="${reverseImagePics.get(0)}"
					style="width: 120px; height: 120px"> 
				<input type="checkbox"
					onclick="checkimage1()" data-toggle="checkbox-x"
					data-enclosed-label="true" name="image1" id="image1"
					value="${reverseImagePics.get(0)}"> 
				<input
					id="image1Hidden" name="image1" type="hidden" value="no"> 
					
				<img
					src="${reverseImagePics.get(1)}"
					style="width: 120px; height: 120px"> 
				<input type="checkbox"
					onclick="checkimage2()" data-toggle="checkbox-x"
					data-enclosed-label="true" name="image2" id="image2"
					value="${reverseImagePics.get(1)}"> 
				<input
					id="image2Hidden" name="image2" type="hidden" value="no"> 
					
				<img
					src="${reverseImagePics.get(2)}"
					style="width: 120px; height: 120px"> 
				<input type="checkbox"
					onclick="checkimage3()" data-toggle="checkbox-x"
					data-enclosed-label="true" name="image3" id="image3"
					value="${reverseImagePics.get(2)}"> 
				<input
					id="image3Hidden" name="image3" type="hidden" value="no"> 
					
				<img
					src="${reverseImagePics.get(3)}"
					style="width: 120px; height: 120px"> 
				<input type="checkbox"
					onclick="checkimage4()" data-toggle="checkbox-x"
					data-enclosed-label="true" name="image4" id="image4"
					value="${reverseImagePics.get(3)}"> 
				<input
					id="image4Hidden" name="image4" type="hidden" value="no"> 
					
				<img
					src="${reverseImagePics.get(4)}"
					style="width: 120px; height: 120px"> 
				<input type="checkbox"
					onclick="checkimage5()" data-toggle="checkbox-x"
					data-enclosed-label="true" name="image5" id="image5"
					value="${reverseImagePics.get(4)}"> 
				<input
					id="image5Hidden" name="image5" type="hidden" value="no"><br>
					<br> 
					
				Suspect in no pictures <input type="checkbox"
					onclick="check()" data-toggle="checkbox-x"
					data-enclosed-label="true" name="noImage" id="noImage"
					value="noImage" checked="checked"> 
				<input
					id="noImageHidden" name="noImage" type="hidden" value="no">
				<input type="hidden" value="${reverseImageWebsites}"
					name="reverseImageWebsites"></label>
					
			</div>
			<!-- Button -->
			<div class="form-group" align="center">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="submite" name="singlebutton" class="btn btn-primary"
						type="submit">Enter</button>
				</div>
			</div>
		</fieldset>
	</form>
</div>

<script>
/* if (document.getElementById("image1").checked) {
	document.getElementById('image1Hidden').disabled = true;
}
if (document.getElementById("image2").checked) {
	document.getElementById('image2Hidden').disabled = true;
}
if (document.getElementById("image3").checked) {
	document.getElementById('image3Hidden').disabled = true;
}
if (document.getElementById("image4").checked) {
	document.getElementById('image4Hidden').disabled = true;
}
if (document.getElementById("image5").checked) {
	document.getElementById('image5Hidden').disabled = true;
}
if (document.getElementById("noImage").checked) {
	document.getElementById("image1").checked = false;
	document.getElementById("image2").checked = false;
	document.getElementById("image3").checked = false;
	document.getElementById("image4").checked = false;
	document.getElementById("image5").checked = false;
	document.getElementById('noImageHidden').disabled = true;
	checkRefresh();
} */
 	function check() {
		if (document.getElementById("noImage").checked == true) {
			document.getElementById("image1").checked = false;
			document.getElementById("image2").checked = false;
			document.getElementById("image3").checked = false;
			document.getElementById("image4").checked = false;
			document.getElementById("image5").checked = false;
			document.getElementById('noImageHidden').disabled = true;			
		}
	}
	function checkimage1() {
		if (document.getElementById("image1").checked == true) {			
			document.getElementById("noImage").checked = false;
			document.getElementById('image1Hidden').disabled = true;
		}
	}
	function checkimage2() {
		if (document.getElementById("image2").checked == true) {
			document.getElementById("noImage").checked = false;
			document.getElementById('image2Hidden').disabled = true;
		}
	}
	function checkimage3() {
		if (document.getElementById("image3").checked == true) {
			document.getElementById("noImage").checked = false;
			document.getElementById('image3Hidden').disabled = true;
		}
	}
	function checkimage4() {
		if (document.getElementById("image4").checked == true) {
			document.getElementById("noImage").checked = false;
			document.getElementById('image4Hidden').disabled = true;
		}
	}
	function checkimage5() {
		if (document.getElementById("image5").checked == true) {
			document.getElementById("noImage").checked = false;
			document.getElementById('image5Hidden').disabled = true;
		}
	} 
</script>
<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});
</script>