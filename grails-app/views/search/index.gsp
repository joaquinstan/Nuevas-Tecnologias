<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>Search</title>
</head>
<body>
<div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <g:form role="form" action="search">
                    <div class="form-group">
                        <label>Activity name:</label>
                        <input id="activity" type="text" name="actName" maxlength="100" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>${message(code: 'artists')+" o grupo"}</label>
                        <g:select id="artists" name="artists" class="form-control" from="${allArtists}" optionKey="id" optionValue="name"/>
                    </div>

                    <div class="form-group">
                        <label>${message(code: 'establishment')}</label>
                        <g:select id="establishment" name="establishment" class="form-control" value="${ activity != null ? activity.establishment.id : null }" from="${establishments}" optionKey="name" optionValue="name"/>
                    </div>

                    <label>From Date</label>
                    <div id="fromDateContainer" class="form-group">
                        <g:datePicker id="fromDate" name="fromDate" value="${new Date()}" relativeYears="[0..5]" precision="minute" class="form-control"/>
                    </div>

                    <div id="untilDateContainer" class="form-group">
                        <label>Until Date</label>
                        <g:checkBox name="untilDateCheckBox" id="untilDateCheckBox" value="notnull" checked="false"/>
                        <div id="untilDate" ><g:datePicker  name="untilDate" relativeYears="[0..5]" precision="minute" class="form-control"/></div>

                    </div>
                    <input class="list-group-item" type="submit" value="Search" />
                </g:form>
            </div>
            <div class="col-md-6 column">
                <div class="searchResults">
                    <g:each in="${activities}" var="activity" >
                        <div class="list-group-item">
                            <div class="line flexContainer">
                                <div class="name">
                                    ${activity.name}
                                </div>
                                <div class="startDate">
                                    <g:formatDate class="datepicker" date="${activity.startDate}" type="datetime" style="LONG" timeStyle="SHORT"/>
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
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $("#fromDateContainer, #untilDateContainer").find("select").select2({
                'width': 'maxWidth'
            });
            $("#untilDate").hide();
            $("#untilDateCheckBox").click(function(){
                $("#untilDate").toggle();
            });
            var selects = $('#artists, #establishment');
            selects.prepend("<option value=\"\" selected=\"selected\"></option>");
            selects.select2({
                placeholder: "select to filter",
                allowClear: true
            });
        });

    </script>
</body>
</html>