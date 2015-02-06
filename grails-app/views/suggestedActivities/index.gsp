<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body class="flexContainer">

    <div class="activitiesContainer list-group center .col-md-4" style="width: 300px">
    
        <g:each in="${activities}" var="activity" >
            <div class="list-group-item">
                <div class="line flexContainer">
                    <div class="name">
                        ${activity.name}
                    </div>
                    <div class="startDate">
                        <g:formatDate date="${activity.startDate}" type="datetime" style="LONG" timeStyle="SHORT"/>
                    </div>
                </div>
				<div class="line flexContainer">
                	<div class="artistName">
	                    ${activity.artists[0]?.name}
                	</div>
						<g:link controller="activity" id="${ activity.id }" class="btn btn-info showActivityButton"><g:message code="seeDescription" /></g:link>
                </div>
            </div>
        </g:each>
        &nbsp;
    </div>

</body>
</html>
