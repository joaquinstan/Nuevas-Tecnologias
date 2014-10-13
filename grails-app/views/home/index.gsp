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

                <div class="artistName">
                    ${activity.artist?.name}
                    ${activity.artist?.lastName}
                </div>
            </div>
        </g:each>
    </div>

</body>
</html>
