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
        <g:if test="${tags == null}">
            <p class="bg-success" style="font-size: 18pt;padding: 20px;">Usted no tiene tags</p>
        </g:if>
        <g:each in="${tags}" var="tag" >
            <p>${tag.valor}</p>
        </g:each>
	    <g:uploadForm class="form-inline" role="form" action="updateUserData">
            <div class="form-group">
                <label>${message(code: 'interestTags')}</label>
                <g:select id="tags" multiple="true" name="interestTags" class="form-control" placeholder="${message(code: 'interestPlaceHolder')}" from="${tags}" optionKey="valor" optionValue="valor" />
            </div>

			<button type="submit" class="btn btn-default" >${ message(code: 'save')}</button>
			
		</g:uploadForm>
				
	</div>
    <script>
        $(document).ready(function() {
            $("select").select2();
            $("#tags").select2({
                tags: true,
                tokenSeparators: [',', ' ']
            })
        });
    </script>
</body>
</html>
