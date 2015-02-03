<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body>
	<div class="container">
	<g:form class="form-inline" action="addNewEstablishment">
	
		<g:if test="${msg != null}">
		<p class="bg-success" style="font-size: 18pt;padding: 20px;">${msg}</p>
		</g:if>
		
		<br></br>
		
		<div class="form-group">
			<label for="exampleInputName2">${message(code: 'name')}</label>
			<input name="name" class="form-control" id="exampleInputName2" placeholder="Luna Park" value="${ establishment != null ? establishment.name : ""}">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'address')}</label>
			<input name="address" class="form-control" id="exampleInputEmail2" placeholder="Av. Madero 420" value="${ establishment != null ? establishment.address : ""}">
		</div>
		<input name="id" type="hidden" value="${ establishment != null ? establishment.id : ""}">
		<button type="submit" class="btn btn-default" >${ establishment != null ? message(code: 'modify') : message(code: 'create')}</button>
				
	</g:form>
	
	<br></br>
	
	<g:if test="${ownEstablishments.size() > 0}">
		<div class="list-group-item">
			<table class="table table-striped">
				<tr>
					<th>${message(code: 'name')}</th>
					<th>${message(code: 'address')}</th>
					<th></th>
				</tr>
				
				<g:each in="${ownEstablishments}" var="establishment">
					<tr>
						<td>${establishment.name}</td>
						<td>${establishment.address}</td>
						<td> 
							<g:link action="modifyEstablishment" id="${establishment.id}"> <img src="${resource(dir:'images',file:'edit.png')}"> </img> </g:link>
							<g:link action="deleteEstablishment" id="${establishment.id}"> <img src="${resource(dir:'images',file:'delete.png')}"> </img> </g:link> 
						</td>
					</tr>
				</g:each>
				
			</table>
		</div>
	</g:if>
	
	</div>

</body>
</html>
