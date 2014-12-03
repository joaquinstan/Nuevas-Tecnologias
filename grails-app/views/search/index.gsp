<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>Search</title>
</head>
<body>
	<div class="container">
	<g:form action="search">
		<div class="row clearfix">
			<div class="col-md-12 column">
				Activity name: <input type="text" name="actName"  class="form-control" maxlength="100">
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				Artist: <input type="text" name="artist"  class="form-control" maxlength="100">
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				Establishment:<input type="text" name="establishment"class="form-control" maxlength="100"> 
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				 Artist Group:<input type="text" name="group" class="form-control" maxlength="100">  
			</div>
		</div>
		
		<div class="row clearfix">
			<div class="col-md-12 column">
			</div>
		</div>
		
		From Date
		<div class="row clearfix">
			<div class="col-md-4 column">
				year:<input type="text" name="iniYear" class="form-control" maxlength="100"> 
			</div>
			<div class="col-md-4 column">
				month:<input type="text" name="iniMonth" class="form-control" maxlength="100"> 
			</div>
			<div class="col-md-2 column">
				day:<input type="text" name="iniDay" class="form-control" maxlength="100"> 
			</div>
			<div class="col-md-1 column">
				Hour:<input type="text" name="iniHour" class="form-control" maxlength="100"> 
			</div>
			<div class="col-md-1 column">
				Minutes:<input type="text" name="iniMinutes" class="form-control" maxlength="100"> 
			</div>
		</div>
		Until Date
		<div class="row clearfix">
			<div class="col-md-4 column">
				year:<input type="text" name="finYear" class="form-control" maxlength="100"> 
			</div>
			<div class="col-md-4 column">
				month:<input type="text" name="finMonth" class="form-control" maxlength="100"> 
			</div>
			<div class="col-md-4 column">
				day:<input type="text" name="finDay" class="form-control" maxlength="100"> 
			</div>
		</div>
		<input class="list-group-item" type="submit" value="Search" />
	</g:form>
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

</body>
</html>