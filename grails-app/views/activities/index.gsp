<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body>
	<div class="container">
	<g:form class="form-inline" action="addNewActivity">
	
		<g:if test="${msg != null}">
		<p class="bg-success" style="font-size: 18pt;padding: 20px;">${msg}</p>
		</g:if>
		
		<br></br>
		
		<div class="form-group">
			<label for="exampleInputName2">${message(code: 'name')}</label>
			<input name="name" class="form-control" id="exampleInputName2" placeholder="John Williams en el Teatro Colon!">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'description')}</label>
			<input name="description" class="form-control" id="exampleInputEmail2" placeholder="John Williams en el Teatro Colon!">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'establishment')}</label>
			<select name="establishment" class="form-control">
				<g:each var="est" in="${establishments}">
					<option value="${est.id}">${est.name}</option>
				</g:each>
			</select>
		</div>
		
		<button type="submit" class="btn btn-default" >${message(code: 'create')}</button>
				
		
	</g:form>
	</div>

</body>
</html>
