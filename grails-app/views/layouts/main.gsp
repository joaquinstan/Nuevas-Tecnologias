<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Turilla"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/json2/20140204/json2.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places&sensor=true"></script>
        <g:layoutHead/>
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <%@ page import="org.apache.shiro.SecurityUtils" %>
        <% user = SecurityUtils.subject.principal %>

	</head>
	<body>
        <geolocation:locateMe/> 
        <div id="wrapper">
            <g:if test="${user}">
                <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <li class="sidebar-brand">
                            <g:displayName></g:displayName>
                        </li>
                        <li>
                            <g:link controller="home">Home</g:link>
                        </li>
                        <li>
                            <a href="#"><g:link controller="profile">My profile</g:link></a>
                        </li>
                        <li>
                            <a href="#"><g:link controller="search">Search Activities</g:link></a>
                        </li>
                        <li>
                            <a href="#"><g:link controller="suggestedActivities">Suggested activities</g:link></a>
                        </li>
                        <li>
                            <a href="#"><g:link controller="activities">Load new Activities</g:link></a>
                        </li>
                        <li>
                            <a href="#"><g:link controller="artists">Load new Artists</g:link></a>
                        </li>
                        <li>
                            <a href="#"><g:link controller="establishments">Load new Establishment</g:link></a>
                        </li>
                        <li>
                            <a href="#"></a>
                        </li>
                        <li>
                            <g:link controller="auth" action="signOut">Logout</g:link>
                        </li>
                    </ul>
                </div>

            </g:if>
            <div id="page-content-wrapper">
                <header>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                            <g:if test="${user}">

                                <a class="navbar-toggle" id="menu-toggle">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </a>
                            </g:if>
                                <a class="navbar-brand" href="#">Turilla</a>


                            </div>
                        </div><!-- /.container-fluid -->
                    </nav>
                </header>

                <div class="flexContainer">
                    <g:layoutBody/>
                </div>
            </div>
        </div>
    </body>
</html>
