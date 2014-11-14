<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body class="flexContainer">

    <div class=".col-md-4">

    </div>
    <div class="activitiesContainer list-group center .col-md-4">
    
		<div class="input-group search-input">
			<span class="input-group-addon"></span>
			
			<g:form action="search">
				<input name=busquedaIntroducida type="text" class="form-control" placeholder="${message(code: 'ingrese nombre de actividad, artista , lugar o descripcion')}">
				<g:link controller="home" action="search" ></g:link>
			</g:form>
		</div>
    
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
                    	${activity.artists[0]?.lastName}
                	</div>
						<g:link controller="activity" id="${ activity.id }" class="btn btn-info showActivityButton"><g:message code="seeDescription" /></g:link>
                </div>
            </div>
        </g:each>
        &nbsp;
    </div>

</body>
</html>
