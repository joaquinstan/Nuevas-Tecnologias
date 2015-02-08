<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Login</title>
</head>
<body class="flexContainer center">
  <div class="loginContainer well well-sm">
    <g:if test="${flash.message}">
    	<div class="message">${flash.message}</div>
    </g:if>
    <g:form action="signIn" class="loginForm list-group">    
    	<input class="list-group-item" type="hidden" name="targetUri" value="${targetUri}" />    
      	<!-- <label for="username">Username</label> -->
      	<input class="list-group-item" type="text" name="username" value="${username}" placeholder="Username" required/>       
      	<!-- <label for="password">Password</label> -->
      	<input class="list-group-item" type="password" name="password" value=""  placeholder="Password" required/> 
      	<div class="flexContainer list-group-item">
        	<label for="rememberMe">Remember Me</label>
        	<g:checkBox name="rememberMe" value="${rememberMe}" />
      	</div>
      	<input class="list-group-item" type="submit" value="Sign in" />
    </g:form>
  </div>
</body>
</html>
