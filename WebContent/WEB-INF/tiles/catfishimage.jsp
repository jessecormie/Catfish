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
	 <div class="row bs-wizard" style="border-bottom:0;">               
                <div class="col-xs-4 bs-wizard-step active">
                  <div class="text-center bs-wizard-stepnum">Step 1</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <span class="bs-wizard-dot"></span>               
                </div>
                <div class="col-xs-4 bs-wizard-step disabled"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Step 2</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <span class="bs-wizard-dot"></span>                 
                </div>               
                <div class="col-xs-4 bs-wizard-step disabled"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Step 3</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <span class="bs-wizard-dot"></span>
                  <span class="bs-wizard-dot"></span>
                </div>                                
            </div>

	<form id="form" method="POST" enctype="multipart/form-data"
		action="catfishimage" class="form-horizontal">
		<fieldset>
			<!-- Form Name -->
			<legend align="center">Upload an Image <a href="#" data-toggle="popover"
				data-content="Upload an image of the person that you suspect to be Catfish. We will extract the location the image was taken as well as use that image to see if that image has been used on any websites across the web"
				data-html="true"><span class="glyphicon glyphicon-question-sign"></span></a></legend>

		<br>
			<div class="form-group" align="center">
				 <label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<input type="file" name="image" required="required">
				</div>
			</div>
<br>
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
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});
</script>