<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body>
	<div class="container">
	<g:form class="form-inline" action="addNewArtist">
	
		<g:if test="${msg != null}">
		<p class="bg-success" style="font-size: 18pt;padding: 20px;">${msg}</p>
		</g:if>
		
		<br></br>
		
		<div class="form-group">
			<label for="exampleInputName2">${message(code: 'alias')}</label>
			<input name="alias" class="form-control" id="exampleInputName2" placeholder="John Williams" value="${ artist != null ? artist.alias : ""}">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'name')}</label>
			<input name="name" class="form-control" id="exampleInputEmail2" placeholder="John Williams" value="${ artist != null ? artist.name : ""}">
		</div>
		<input name="id" type="hidden" value="${ artist != null ? artist.id : ""}">
		<button type="submit" class="btn btn-default" >${ artist != null ? message(code: 'modify') : message(code: 'create')}</button>
		
	</g:form>
		
	<br></br>
	
	<g:if test="${ownArtists.size() > 0}">
		<div class="list-group-item">
			<table class="table table-striped">
				<tr>
					<th>${message(code: 'alias')}</th>
					<th>${message(code: 'name')}</th>
					<th></th>
				</tr>
				
				<g:each in="${ownArtists}" var="artist">
					<tr>
						<td>${artist.alias}</td>
						<td>${artist.name}</td>
						<td> 
							<g:link action="modifyArtist" id="${artist.id}"> <img src="${resource(dir:'images',file:'edit.png')}"> </img> </g:link>
							<g:link action="deleteArtist" id="${artist.id}"> <img src="${resource(dir:'images',file:'delete.png')}"> </img> </g:link> 
						</td>
					</tr>
				</g:each>
				
			</table>
		</div>
	</g:if>
		
	</div>

</body>
</html>
