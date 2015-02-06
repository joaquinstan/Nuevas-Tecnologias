<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Home</title>
</head>
<body class="activityContainer">
    <div class="container">
    
    	<g:if test="${msg != null}">
			<p class="bg-success" style="font-size: 18pt;padding: 20px;">${msg}</p>
		</g:if>
    
	    <g:uploadForm class="form-inline" action="updateUserData">
	    
	   		<div class="flexGrow1">
	  		 	<label for="exampleInputName2">${message(code: 'interestTags')}</label>
				<input name="interestTags" style="display: initial;" class="form-control name" 
						value="${ currentUser != null ? currentUser.interestTags : ""}" placeholder="${message(code: 'interestPlaceHolder')}">
			</div>
			
			<button type="submit" class="btn btn-default" >${ message(code: 'save')}</button>
			
		</g:uploadForm>
				
	</div>	
</body>
</html>
