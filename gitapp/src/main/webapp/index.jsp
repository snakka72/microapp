<!DOCTYPE html>
<html lang="en">
<head>
  <title>Git Example</title>
  
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
</head>

<body  ng-app="myApp" >

Welcome!

<div ng-view></div>

<script>

var app = angular.module("myApp", ["ngRoute"]);




/* app.config(function($sceDelegateProvider)  {
    $sceDelegateProvider.resourceUrlWhitelist([
        'https://cloudapp-svc.cfapps.io/**'
     ]);
});  */

app.config(function($routeProvider) {
    $routeProvider
    .when('/employee', {
        templateUrl : 'employee.html' ,
        controller : 'employeeCtrl'
    
    });
});
	
app.controller("employeeCtrl", function ($scope, $http) {
    
	$scope.Countries = {};
    //$scope.Countries = [{Name: 'ID1001', City: 'Bura'}];
    $scope.Country = {};
    
    
    
     $http.get("https://www.w3schools.com/angular/customers.php").then(function(response) {
        $scope.Countries = response.data.records;
        console.log("$scope.Countries: " + JSON.stringify($scope.Countries));
    }); 
    
     
      $http.get("https://cloudapp-svc.cfapps.io/welcome").then(function(response) {
         $scope.Country = response.data;
         //$scope.Country = response.data;
         console.log("$scope.Country: " + JSON.stringify($scope.Country));
     });       
     
      
      /* $http({
          method: 'GET',
          headers: {
              'Content-Type': 'application/json'
          },
          url: 'https://cloudapp-svc.cfapps.io/welcome',
          data: angular.toJson( $scope.Country),
          transformResponse: [
  	        function (response) { 
  	            return  console.log(response);; 
  	        }
  	    ]
      })
      });
     console.log("$scope.Country: ##########" + JSON.stringify($scope.Country)); */
     
      
});
	
	window.location.href = '#!employee';
	
</script>


</body>
</html>