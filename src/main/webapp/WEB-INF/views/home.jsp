<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html xmlns:ng="http://angularjs.org" class="ng-app:SpringData" id="ng-app" ng-app="SpringData">
	<head>	
		<title>Spring Data JPA Example</title>
	    <meta charset="utf-8">
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<link rel="SHORTCUT ICON" href="resources/images/favicon.ico" type="image/x-icon" />
	    <c:import url="/WEB-INF/views/css.jsp"></c:import>		   	    
		<c:import url="/WEB-INF/views/javascript.jsp"></c:import>
	</head>
	
	
	<body >
		<c:import url="/WEB-INF/views/header.jsp"></c:import>
		<div ng-controller="HomeController">
			<div id="wrapper">
				<div class="container">		
					<div class="row">		
						<form class="navbar-form navbar-left" role="search">		      
					      	<div class="form-group">
						        <div class="btn-group searchBtnGroup" data-toggle="buttons-radio">
									<button type="button" class="btn btn-default active" ng-click="setSearchColumn('all',$event)">All</button>
									<button type="button" class="btn btn-default" ng-click="setSearchColumn('firstName',$event)">First Name</button>
									<button type="button" class="btn btn-default" ng-click="setSearchColumn('lastName',$event)">Last Name</button>
								</div>
							</div>
					      		      
							<div class="form-group">
							  <input type="text" class="form-control" placeholder="Search" ng-model="requestObject.searchTerm">
							</div>
					      	
					      	<button type="submit" class="btn btn-default" ng-click="search()">
					      		<i class="glyphicon glyphicon-search"></i>
					      	</button>				      	
					    </form>		    
			 		</div>		 
				</div>
		
				<!-- please put the jqgrid inside a div, because is causing some angular problems -->
				<div>
					<table id="playersList"></table> 
					<div id="playersPager"></div>
				</div>
				
				<button type="button" id="openAddNewUserModal" class="hide btn btn-default" ng-click="open()">D</button>
			    
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/footer.jsp"></c:import>
	</body>
</html>
