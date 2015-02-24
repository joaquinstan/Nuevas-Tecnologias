<%@page import="javax.activity.ActivityCompletedException"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body>
	<div class="container">

        <g:uploadForm class="form-horizontal" role="form" action="addNewActivity">

            <g:if test="${msg != null}">
            <p class="bg-success" style="font-size: 18pt;padding: 20px;">${msg}</p>
            </g:if>

            <br/>

            <div class="form-group">
                <label class="control-label" for="name">${message(code: 'name')}</label>
                <div>
                    <input type="text" id="name" name="name" class="form-control" placeholder="John Williams en el Teatro Colon!" value="${ activity != null ? activity.name : ""}" required="required">
                </div>
            </div>

            <div class="form-group">
                <label>${message(code: 'description')}</label>
                <input name="description" class="form-control" placeholder="John Williams en el Teatro Colon!" value="${ activity != null ? activity.description : ""}">
            </div>


            <div class="form-group">
                <label>${message(code: 'tags')}</label>
                <g:select id="tags" multiple="true" name="tags" class="form-control" placeholder="${message(code: 'exampleTag')}" from="${tags}" optionKey="valor" optionValue="valor" />
            </div>

            <div class="form-group">
                <label>${message(code: 'establishment')}</label>
                <g:select id="establishment" name="establishment" class="form-control" value="${ activity != null ? activity.establishment.id : null }" from="${establishments}" optionKey="id" optionValue="name"/>
            </div>

            <div class="form-group">
                <label>${message(code: 'artists')}</label>
                <g:select id="artists" name="artists" class="form-control"  from="${artists}" value="${ activity != null ? activity.artists.id : null }" optionKey="id" optionValue="name"/>
            </div>

            <div id="fromDateContainer" class="form-group">
                <label>From Date</label>
                <g:datePicker id="fromDate" name="fromDate" value="${new Date()}" relativeYears="[0..5]" precision="minute" class="form-control"/>
            </div>

            <div id="untilDateContainer" class="form-group">
                <label>Until Date</label>
                <g:datePicker  id="untilDate" name="untilDate" relativeYears="[0..5]" precision="minute" class="form-control"/>

            </div>

            <div class="form-group">
                Upload Image: <input type="file" name="photo"/>
            </div>

            <input name="id" type="hidden" value="${ activity != null ? activity.id : ""}">
            <button type="submit" class="btn btn-default" >${ activity != null ? message(code: 'modify') : message(code: 'create')}</button>

        </g:uploadForm>

	
	<br/>
	
	<g:if test="${ownActivities.size() > 0}">
		<div class="list-group-item">
			<table class="table table-striped">
				<tr>
					<th>${message(code: 'name')}</th>
					<th>${message(code: 'description')}</th>
					<th>${message(code: 'establishment')}</th>
					<th></th>
				</tr>
				
				<g:each in="${ownActivities}" var="activity">
					<tr>
						<td>${activity.name}</td>
						<td>${activity.description}</td>
						<td>${activity.establishment.name}</td>
						<td> 
							<g:link action="modifyActivity" id="${activity.id}"> <img src="${resource(dir:'images',file:'edit.png')}"> </img> </g:link>
							<g:link action="deleteActivity" id="${activity.id}"> <img src="${resource(dir:'images',file:'delete.png')}"> </img> </g:link> 
						</td>
					</tr>
				</g:each>
				
			</table>
		</div>
	</g:if>
	
	</div>
<script>
    $(document).ready(function() {
        $("#establishment, #artists").select2();
        $("#fromDateContainer, #untilDateContainer").find("select").select2({
            'width': 'maxWidth'
        });
        $("#tags").select2({
            tags: true,
            tokenSeparators: [',', ' ']
        });
    });
</script>
</body>
</html>
