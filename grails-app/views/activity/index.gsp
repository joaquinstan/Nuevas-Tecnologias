<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body class="flexContainer">

    <div class=".col-md-4">

    </div>
    <div class="activitiesContainer list-group flexContainer center .col-md-4">
		<div class="list-group-item">
			<div class="line flexContainer">
			    <div class="name">
			        ${activity.name}
			</div>
			<div class="startDate">
			    <g:formatDate date="${activity.startDate}" type="datetime" style="LONG" timeStyle="SHORT"/>
			    </div>
			</div>
			
			<hr/>
			
			<div class=activityDescription>
				${activity.description}
			</div>

			<hr/>

			<div class="artistName">
			    ${activity.artists?.name}
				${activity.artists?.lastName}
			</div>
			
			<hr/>
			
			<div class="btn-vote">
				<g:if test="${activity.getUserLike(currentUser) == 1}">
				    <a class="up active" href="javascript:void(0);"></a>
				</g:if>
				<g:else>
				     <a class="up" href="javascript:void(0);"></a>
				</g:else>

				<g:if test="${activity.getUserLike(currentUser) == -1}">
     				<a class="second-btn down active" href="javascript:void(0);"></a></a>
				</g:if>
				<g:else>
     				<a class="second-btn down" href="javascript:void(0);"></a>
				</g:else>
     		
			</div>
			
		</div>
    </div>

</body>
</html>
