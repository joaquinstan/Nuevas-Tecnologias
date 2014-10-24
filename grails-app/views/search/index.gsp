<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>Search</title>
</head>
<body>
    <div class="searchContainer">
        <div class="input-group searchInput">
            <input type="text" class="form-control">

            <span class="input-group-addon glyphicon glyphicon-search"></span>
        </div>
        <div class="searchResults">
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
        </div>

    </div>

</body>

</html>