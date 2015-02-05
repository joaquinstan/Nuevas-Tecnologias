<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
  <% establishment = activity.establishment %>
</head>
<body class="activityContainer">
    <div class="activityContainer">
	    	<div class="infoContainer">
	    		<div class="flexGrow1">
		    		<h2>
						${activity.name}
				    </h2>
				    <h3 >
					    ${activity.artists[0]?.name}
					</h3>
					<div class="startDate">
					    <g:formatDate date="${activity.startDate}" type="datetime" style="LONG" timeStyle="SHORT"/>
				
					</div>

					<p>
						${activity.description}
					</p>
							<div class="btn-vote">
						<g:render template="btn-vote" />     		
					</div>

	    		</div>
				

			    <g:if test="${activity.image}">
			    	<div class="imageContainer ">
						<img class="activityImage" src="${createLink(controller:'activity', action:'image', id:activity.ident())}" />
			    	</div>
			  		
				</g:if>				
			</div>
			    
		    <div class="mapContainer">
		    	<div id="activityMap"></div>
			</div>
	</div>
    
    <g:javascript> 
	  	var establishmentPosition = new google.maps.LatLng(<%= establishment.latitude %>,<%= establishment.longitude %>)
	  	var mapOptions = {
	          center: establishmentPosition,
	          zoom: 15
		};

		var map = new google.maps.Map(document.getElementById('activityMap'), mapOptions);
		var marker = new google.maps.Marker({
      		position: establishmentPosition,
      		map: map 
  		});

  		var infowindow = new google.maps.InfoWindow({
      		content: '<%= establishment.name %> - <%= establishment.address%>'
  		});
  		
  		google.maps.event.addListenerOnce(map, 'idle', function(){
	    	infowindow.open(map,marker);
    	});
  		
	</g:javascript>

</body>
</html>
