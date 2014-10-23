<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body class="flexContainer">

    <div class=".col-md-4">

    </div>
    <div class="activitiesContainer list-group flexContainer .col-md-4">
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
			</div>
    </div>

</body>
</html>
