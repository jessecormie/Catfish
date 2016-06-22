<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
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
		<div class="col-xs-4 bs-wizard-step complete">
			<!-- complete -->
			<div class="text-center bs-wizard-stepnum">Step 2</div>
			<div class="progress">
				<div class="progress-bar"></div>
			</div>
			<span class="bs-wizard-dot"></span>
		</div>
		<div class="col-xs-4 bs-wizard-step complete">
			<!-- complete -->
			<div class="text-center bs-wizard-stepnum">Step 3</div>
			<div class="progress">
				<div class="progress-bar"></div>
			</div>
			<span class="bs-wizard-dot"></span> <span class="bs-wizard-dot"></span>
		</div>
	</div>

	<legend align="center">Catfish Report</legend>

<div align="right">
	<button onclick="myFunction()">Print this page</button>
</div>
	<script>
		function myFunction() {
			window.print();
		}
	</script>
	
			
		<h2> Probability you caught a Catfish</h2> 
	 <div class="progress progress-striped active">
        <div id="prog-bar" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"><p id="prob"></p>
        </div>
    </div>   
</div>


<h4>Comparing Info</h4>
<table class="table table-bordered table-stripped">
	<tr>
		<th></th>
		<th>Suspect Info</th>
		<th>Results</th>
	<tr>
		<th>First Name</th>
		<td><c:choose>
				<c:when test="${suspect.firstName.isEmpty()}">Not Entered</c:when>
				<c:otherwise>${suspect.firstName}</c:otherwise>
			</c:choose></td>
		<td>${ResultFirstName}</td>
	</tr>
	<tr>
		<th>Last Name</th>
		<td><c:choose>
				<c:when test="${suspect.lastName.isEmpty()}">Not Entered</c:when>
				<c:otherwise>${suspect.lastName}</c:otherwise>
			</c:choose></td>
		<td>${ResultLastName}</td>

	</tr>
	<tr>
		<th>Gender</th>
		<td><c:choose>
				<c:when test="${suspect.gender.isEmpty()}">Not Entered</c:when>
				<c:otherwise>${suspect.gender}</c:otherwise>
			</c:choose></td>
		<td>${ResultGender}</td>
	</tr>
	<tr>
		<th>Age</th>
		<td><c:choose>
				<c:when test="${suspect.age.isEmpty()}">Not Entered</c:when>
				<c:otherwise>${suspect.age} years old</c:otherwise>
			</c:choose></td>
		<td>${ResultAge}</td>

	</tr>

	<tr>
		<th>Address</th>
		<td><c:choose>
				<c:when test="${suspect.location.isEmpty()}">Not Entered</c:when>
				<c:otherwise>${suspect.location}</c:otherwise>
			</c:choose></td>
		<td><c:choose>
				<c:when test="${fullContactPerson.location == null}"></c:when>
				<c:otherwise>${fullContactPerson.location}/ </c:otherwise>
			</c:choose> <c:choose>
				<c:when test="${piplPerson.location == null}">Not Found</c:when>
				<c:otherwise>${piplPerson.location}</c:otherwise>
			</c:choose></td>
	</tr>

	<tr>
		<th>Phone</th>
		<td><c:choose>
				<c:when test="${suspect.phone.isEmpty()}">Not Entered</c:when>
				<c:otherwise>${suspect.phone}</c:otherwise>
			</c:choose></td>
		<td>${ResultPhone}</td>
	</tr>

	<tr>
		<th>Social Profiles</th>
		<td><c:choose>
				<c:when test="${suspect.facebook.isEmpty()}">Not Entered</c:when>
				<c:otherwise>
					<a href="${suspect.facebook}">Facebook</a>
				</c:otherwise>
			</c:choose></td>
		<td><c:choose>
			<c:when test="${ResultPiplFacebook == null}">Unknown</c:when>
			<c:otherwise>
				<a href="${ResultPiplFacebook}">Facebook</a>
			</c:otherwise>
		</c:choose></td>
		
		<%-- <td><a href="${ResultFullContactFacebook}">Profile</a> / <a href="${ResultPiplFacebook}">Profile</a></td> --%>
	</tr>

</table>

<c:if test="${!websitesToShow.isEmpty()}">
	<table class="table table-bordered table-stripped">
		<tr>
			<th align="center">Click an image to see where it has been used!</th>
		</tr>
		<tr>
			<td align="center"><c:forEach var="link"
					items="${websitesToShow}" varStatus="loop">
					<a href="${link}"> <img src="${imagesToShow[loop.index]}"
						style="width: 120px; height: 120px"></a>
				</c:forEach></td>
		</tr>
	</table>
</c:if>

<h4>Extra Info</h4>
<table class="table table-bordered table-stripped">
	<tr>
		<th></th>
		<th>Extra FullContact Data</th>
		<th>Extra Pipl Data</th>
	</tr>


	<c:choose>
		<c:when test="${fullContactPerson.children != null}">
			<tr>
				<th>Children</th>
				<td><c:choose>
						<c:when test="${fullContactPerson.children == null}">Unknown</c:when>
						<c:otherwise>${fullContactPerson.children}</c:otherwise>
					</c:choose></td>
				<td>No info</td>
			</tr>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="${fullContactPerson.maritalStatus != null}">
			<tr>
				<th>Marital Status</th>
				<td><c:choose>
						<c:when test="${fullContactPerson.maritalStatus == null}">Unknown</c:when>
						<c:otherwise>${fullContactPerson.maritalStatus}</c:otherwise>
					</c:choose></td>
				<td>No info</td>
			</tr>
		</c:when>
	</c:choose>

	<tr>
		<th>Job</th>
		<td><c:catch var="catchException">
				<c:choose>
					<c:when test="${fullContactPerson.fcJob.size() == 0}">Unknown</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="0"
							end="${fullContactPerson.fcJob.size()-1}">
							<p>
								<c:if
									test="${fullContactPerson.fcJob.get(i).isCurrent() == true}">
				Currently 
				</c:if>
								<c:if
									test="${fullContactPerson.fcJob.get(i).isCurrent() == false}">
				Used to be 
				</c:if>
								<c:out value="${fullContactPerson.fcJob.get(i).getTitle()}"></c:out>
								at
								<c:out value="${fullContactPerson.fcJob.get(i).getName()}"></c:out>
							</p>
						</c:forEach>

					</c:otherwise>
				</c:choose>
			</c:catch> <c:if test="${catchException !=null}">Unknown</c:if></td>
		<td><c:choose>
				<c:when test="${piplPerson.piplJob == null}">Unknown</c:when>
				<c:otherwise>${piplPerson.piplJob}</c:otherwise>
			</c:choose></td>
	</tr>

	<tr>
		<th>Photos</th>
		<td><c:catch var="catchException">
				<c:choose>
					<c:when test="${fullContactPerson.fcPhotos.size() == 0}">Unknown</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="0"
							end="${fullContactPerson.fcPhotos.size()-1}">
							<p>
								<a
									href="<c:out value="${fullContactPerson.fcPhotos.get(i).getUrl()}"></c:out>">
									<c:out
										value="${fullContactPerson.fcPhotos.get(i).getTypeName()}"></c:out>
									Picture
								</a>
							</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</c:catch> <c:if test="${catchException !=null}">Unknown</c:if></td>
		<td><c:choose>
				<c:when test="${piplPerson.piplImage == null}">Unknown</c:when>
				<c:otherwise>
					<a href="${piplPerson.piplImage}">Picture</a>
				</c:otherwise>
			</c:choose></td>
	</tr>
	<tr>
		<th>Social Profiles</th>
		<td><c:catch var="catchException">
				<c:choose>
					<c:when test="${fullContactPerson.fcSocialProfiles == null}">Unknown</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="0"
							end="${fullContactPerson.fcSocialProfiles.size()-1}">
							<p>
								<a
									href="<c:out value="${fullContactPerson.fcSocialProfiles.get(i).getUrl()}"></c:out>">
									<c:out
										value="${fullContactPerson.fcSocialProfiles.get(i).getTypeName()}"></c:out>
								</a>
							</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</c:catch></td>
		<td><c:choose>
				<c:when test="${piplPerson.piplUrl == null}">Unknown</c:when>
				<c:otherwise>
					<a href="${piplPerson.piplUrl}">Profile</a>
				</c:otherwise>
			</c:choose></td>
	</tr>

	<tr>
		<th>Relations</th>
		<td>No info</td>
		<td><c:catch var="catchException">
				<c:choose>
					<c:when test="${piplPerson.piplRelations.getNames().size() == 0}">Unknown</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="0"
							end="${piplPerson.piplRelations.getNames().size()-1}">
							<p>${piplPerson.piplRelations.getNames().get(i).display}</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</c:catch> <c:if test="${catchException !=null}">Unknown</c:if></td>
	</tr>
</table>


<div align="center">
	<h2>Google Map</h2>

	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB7JqDZbiMaQ6B3RClC08X467VOdBrW_xA&callback=initMap">
		
	</script>
	<script>
		var l = 0;
		var coordinates;
		var geocoder;
		var theCenter = new google.maps.LatLng(-43.59375, 38.272688535980976);

		//pic info
		var suspectMetaDataLat = ${suspect.metadataLong};
		var suspectMetaDataLong = ${suspect.metadataLat};
		var suspectMetaDataAddress = new google.maps.LatLng(suspectMetaDataLat, suspectMetaDataLong);
		
		//suspect's info
		var suspectAddress = "${suspect.location}";
		var suspectLat = null;
		var suspectLng;
		var suspectGeoAddress;

		//fullContract info
		var fullContactAddress = "${fullContactPerson.location}";
		var fullContactLat;
		var fullContactLng;
		var fullContactGeoAddress;

		//pipl info
		var piplAddress = "${piplPerson.location}";
		var piplLat;
		var piplLng;
		var piplGeoAddress;

		//Distance between two points
		var radius = 6371;
		var dLat;
		var dLon;
		var a;
		var c;
		var metaDataDistance;
		var fullContactDistance;
		var piplDistance;

		//probability
		var prob = ${percent};
		var locationProb = 0;
		var totalProb = 0;
		var totalLocationProb = 0;
		
		function SuspectDetails(lat, lng) {
			this.lat = lat;
			this.lng = lng;
		}

		var suspect = new SuspectDetails();

		//alert("before initialize function")
		function initialize() {

			//alert("just inside initialize ")
			geocoder = new google.maps.Geocoder();
			var lat = null;
			if (suspectAddress) {

				console.log("SECOND");
				console.log("suspectadd")

				geocoder
						.geocode(
								{
									'address' : suspectAddress
								},
								function(results, status) {
									if (status == google.maps.GeocoderStatus.OK) {
										suspectLat = results[0].geometry.location
												.lat();
										lat = suspectLat;
										
										suspectLng = results[0].geometry.location
												.lng();
										
										suspect.lat = suspectLat;
										suspect.lng = suspectLng;
										console.log(suspect);

										suspectGeoAddress = new google.maps.LatLng(
												suspectLat, suspectLng);

										var marker = new google.maps.Marker(
												{
													position : suspectGeoAddress,
													animation : google.maps.Animation.BOUNCE,
													title : "Suspects Address",
													icon : 'http://maps.google.com/mapfiles/ms/icons/red-dot.png'
												});
										marker.setMap(map);

										var infowindow = new google.maps.InfoWindow(
												{
													content : "Suspected Address"
												});

									
										google.maps.event.addListener(marker,
												'click', function() {
													map.setZoom(12);
													map.setCenter(marker
															.getPosition());
													infowindow
															.open(map, marker);
												});
										getMetaDataDistance();
									}
								});
			}

			if (piplAddress) {
				console.log("FIRST");
				
				geocoder
						.geocode(
								{
									'address' : piplAddress
								},
								function(results, status) {
									if (status == google.maps.GeocoderStatus.OK) {
										piplLat = results[0].geometry.location
												.lat();
										piplLng = results[0].geometry.location
												.lng();
										piplGeoAddress = new google.maps.LatLng(
												piplLat, piplLng);
										var marker2 = new google.maps.Marker(
												{
													position : piplGeoAddress,
													animation : google.maps.Animation.BOUNCE,
													title : "Found Address",
													icon : 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
												});
										marker2.setMap(map);
										var infowindow2 = new google.maps.InfoWindow(
												{
													content : "Search Engine Address"
												});

										google.maps.event.addListener(marker2,
												'click', function() {
													map.setZoom(12);
													map.setCenter(marker2
															.getPosition());
													infowindow2.open(map,
															marker2);
												});
										getPiplDistance()
									}
								});
			}
			if (fullContactAddress) {
				console.log("fullContactAddress")
				geocoder
						.geocode(
								{
									'address' : fullContactAddress
								},
								function(results, status) {
									if (status == google.maps.GeocoderStatus.OK) {
										console.log(suspect);
										fullContactLat = results[0].geometry.location
												.lat();
										fullContactLng = results[0].geometry.location
												.lng();
										fullContactGeoAddress = new google.maps.LatLng(
												fullContactLat, fullContactLng);

										var marker3 = new google.maps.Marker(
												{
													position : fullContactGeoAddress,
													animation : google.maps.Animation.BOUNCE,
													title : "Found Address",
													icon : 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
												});
										marker3.setMap(map);
										var infowindow3 = new google.maps.InfoWindow(
												{
													content : "Search Address"
												});

										google.maps.event.addListener(marker3,
												'click', function() {
													map.setZoom(12);
													map.setCenter(marker3
															.getPosition());
													infowindow3.open(map,
															marker3);
												});
										getFullContactDistance()
									}
								});
			}
			var mapOptions = {
				center : theCenter,
				zoom : 1,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};

			var map = new google.maps.Map(
					document.getElementById('map-canvas'), mapOptions);

			if (suspectMetaDataAddress) {
				var marker4 = new google.maps.Marker(
						{
							position : suspectMetaDataAddress,
							animation : google.maps.Animation.BOUNCE,
							title : "Found Address",
							icon : 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png'
						});
				marker4.setMap(map);
				var infowindow4 = new google.maps.InfoWindow({
					content : "Picture Address"
				});

				google.maps.event.addListener(marker4, 'click', function() {
					map.setZoom(12);
					map.setCenter(marker4.getPosition());
					infowindow4.open(map, marker4);
				});			
			}

			if (typeof path != 'undefined') {
				var marker = new google.maps.Marker({
					position : path[path.length - 1],
					map : map,
					title : 'Hello World!'
				});
			}		
		}

		
		function getFullContactDistance() {
			dLat = deg2rad(fullContactLat - suspectLat); // deg2rad below
			dLon = deg2rad(fullContactLng - suspectLng);
			console.log(suspect);
			a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
					+ Math.cos(deg2rad(suspectLat))
					* Math.cos(deg2rad(fullContactLat)) * Math.sin(dLon / 2)
					* Math.sin(dLon / 2);
			c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			fullContactDistance = radius * c;
			/* alert("FullContact Distance " + fullContactDistance); */
			if (fullContactDistance <= 10) {
				totalProb = totalProb + 50;
				//alert("FullContact if total prob: " + totalProb);
			} else {
				totalProb = totalProb + 50;
				locationProb = locationProb + 50;
		/* alert("FullContact else total prob " + totalProb + "location prob: "
						+ locationProb);  */
			}
			calculateProb();
		}

		function getPiplDistance() {
			dLat = deg2rad(piplLat - suspectLat);
			dLon = deg2rad(piplLng - suspectLng);
			console.log(suspect);
			a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
					+ Math.cos(deg2rad(suspectLat))
					* Math.cos(deg2rad(piplLat)) * Math.sin(dLon / 2)
					* Math.sin(dLon / 2);
			c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			piplDistance = radius * c;
			//alert("Pipl Distance " + piplDistance);
			if (piplDistance <= 10) {				
				totalProb = totalProb + 50;
				//alert("Pipl if total prob: " + totalProb);
			} else {
				totalProb = totalProb + 50;
				locationProb = locationProb + 50;
			 /* alert("Pipl else total prob " + totalProb + "location prob: "
						+ locationProb);  */
			}
			calculateProb();
		}

		function getMetaDataDistance() {
			dLat = deg2rad(suspectMetaDataLat - suspectLat); // deg2rad below
			dLon = deg2rad(suspectMetaDataLong - suspectLng);
			console.log(suspect);
			a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
					+ Math.cos(deg2rad(suspectLat))
					* Math.cos(deg2rad(suspectMetaDataLat))
					* Math.sin(dLon / 2) * Math.sin(dLon / 2);
			c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			metaDataDistance = radius * c;
			//alert("Metadata Distance " + metaDataDistance);
			if (metaDataDistance <= 500) {
				totalProb = totalProb + 50;
				//alert("Metadata if total prob: " + totalProb);
			} else {
				totalProb = totalProb + 50;
				locationProb = locationProb + 50;
			/*  alert("Metadata else total prob " + totalProb + "location prob: "
						+ locationProb);  */
			}
			calculateProb();
		}

		function calculateProb() {		
			probToDisplay = ((prob + locationProb) / (100 + totalProb)) * 100;
			
		/* 	alert("Prob to display: " + probToDisplay);	
			 */
			probToDisplay = probToDisplay.toFixed(2);
			document.getElementById("prob").innerHTML = probToDisplay + "%";
			
			$('#prog-bar').css('width', probToDisplay+'%').attr('aria-valuenow', probToDisplay);    
		}

		function deg2rad(deg) {
			return deg * (Math.PI / 180)
		}

		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
	
	<div id="map-canvas" style="height: 500px; width: 500px;"></div>
</div>
