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
        'https://www.w3schools.com/**'
     ]);
}); */

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
    
     $http.get("https://www.w3schools.com/angular/customers.php").then(function(response) {
        $scope.Countries = response.data.records;
        console.log("$scope.Countries: " + JSON.stringify($scope.Countries));
    }); 
    
     console.log("$scope.Countries: ##########" + JSON.stringify($scope.Countries));
    
});
	
	window.location.href = '#!employee';
	
</script>


</body>
</html>