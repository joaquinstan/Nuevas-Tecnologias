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
			<input name="name" class="form-control" id="exampleInputName2" placeholder="Luna Park">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">${message(code: 'address')}</label>
			<input name="address" class="form-control" id="exampleInputEmail2" placeholder="Av. Madero 420">
		</div>
		<button type="submit" class="btn btn-default" >${message(code: 'create')}</button>
				
		
	</g:form>
	</div>

</body>
</html>
