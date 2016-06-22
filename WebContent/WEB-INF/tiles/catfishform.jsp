<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	

<br>

<div class="container">
	 <div class="row bs-wizard" style="border-bottom:0;">                
                <div class="col-xs-4 bs-wizard-step complete">
                  <div class="text-center bs-wizard-stepnum">Step 1</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <span class="bs-wizard-dot"></span>           
                </div>               
                <div class="col-xs-4 bs-wizard-step complete"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Step 2</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <span class="bs-wizard-dot"></span>                
                </div>               
                <div class="col-xs-4 bs-wizard-step active"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">Step 3</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <span class="bs-wizard-dot"></span>
                  <span class="bs-wizard-dot"></span>
                </div>
           </div>

<form id="form" method="POST" enctype="multipart/form-data"
	action="catfishform" class="form-horizontal">
	<fieldset>
		<!-- Form Name -->
		<legend align="middle">Catfish Form <a href="#" data-toggle="popover" 
				data-content="Fill out this form using information that you have about the suspected catfish"
				data-html="true"><span class="glyphicon glyphicon-question-sign"></span></a></legend>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">First
				name</label>
			<div class="col-md-4">
				<input class="form-control input-md" placeholder="John"
					name="catFirstName" type="text" required="required">
			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Last
				name</label>
			<div class="col-md-4">
				<input class="form-control input-md" name="catLastName" type="text"
					placeholder="Smith" required="required">
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="email">E-mail</label>
			<div class="col-md-4">
				<input class="form-control input-md" name="catEmail" type="email"
					placeholder="john@email.com" required="required"/>
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Address</label>
			<div class="col-md-4">
				<input class="form-control input-md" name="address" type="text"
					placeholder="Full Address" />
			</div>
		</div>


		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Age</label>
			<div class="col-md-4">
				<input class="form-control input-md" name="catDateOfBirth"
					type="number" placeholder="Age" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="passwordinput">Phone</label>
			<div class="col-md-4">
				<input id="catPhone" name="catPhone" type="tel"
					class="form-control input-md" placeholder="123456789" />
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Facebook
				Link</label>
			<div class="col-md-4">
				<input class="form-control input-md" name="catFacebook" type="url"
					placeholder="www.facebook.com/xxxxxxx" />
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label">Gender</label>
			<div class="col-md-4">
				<label for="male">Male</label> <input type="radio" name="catGender"
					id="male" value="Male" checked="checked"><br> <label
					for="female">Female</label> <input type="radio" name="catGender"
					id="female" value="Female">
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
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