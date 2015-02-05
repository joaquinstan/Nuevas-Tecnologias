<%@page import="javax.activity.ActivityCompletedException"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body>
	<div class="container">
	<g:uploadForm class="form-inline" action="addNewActivity">
	
		<g:if test="${msg != null}">
		<p class="bg-success" style="font-size: 18pt;padding: 20px;">${msg}</p>
		</g:if>
		
		<br></br>
		
		<div class="form-group">
			<label for="exampleInputName2">${message(code: 'name')}</label>
			<input name="name" class="form-control" id="exampleInputName2" placeholder="John Williams en el Teatro Colon!" value="${ activity != null ? activity.name : ""}">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'description')}</label>
			<input name="description" class="form-control" id="exampleInputEmail2" placeholder="John Williams en el Teatro Colon!" value="${ activity != null ? activity.description : ""}">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'establishment')}</label>
			<g:select name="establishment" class="form-control" value="${ activity != null ? activity.establishment.id : null }" from="${establishments}" optionKey="id" optionValue="name"/>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'artists')}</label>
			<g:select name="artists" class="form-control" value="" from="${artists}" value="${ activity != null ? activity.artists.id : null }" optionKey="id" optionValue="name"/>
		</div>
		

		<div class="form-group">
			Upload Image: <input type="file" name="photo"/>
		</div>


		<input name="id" type="hidden" value="${ activity != null ? activity.id : ""}">
		<button type="submit" class="btn btn-default" >${ activity != null ? message(code: 'modify') : message(code: 'create')}</button>
		
	</g:uploadForm>
	
	<br></br>
	
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

</body>
</html>
