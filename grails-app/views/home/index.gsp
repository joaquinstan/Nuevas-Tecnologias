<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body class="flexContainer">

  <g:each in="${activities}" var="activity" class="list-group">
    <div class="activitiesContainer list-group-item flexContainer">
        <div class="line flexContainer">
            <div class="name">
                ${activity.name}
            </div>
            <div class="startDate">
                ${activity.startDate}
            </div>
        </div>

        <div class="artist">
            ${activity.artist?.name}
        </div>
    </div>
  </g:each>

</body>
</html>
