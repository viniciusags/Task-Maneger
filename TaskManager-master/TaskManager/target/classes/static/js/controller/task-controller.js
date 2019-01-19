//controllers creation

appTaskManager.controller("taskController", function($scope, $http){
	
	
	
	$scope.tasks=[];
	$scope.task={}
	
	listTasks=function (){
		$http({method:'GET', url:'http://localhost:8080/tasks'})
		.then(function (response){
			
			$scope.tasks=response.data;
			
						
		} , function (response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	$scope.saveTasks=function(){
		
		$http({method:'POST', url:'http://localhost:8080/tasks', data:$scope.task})
		.then(function (response){
			
			//$scope.tasks.push(response.data);
			listTasks();
			$scope.cancelChange();
			
		} , function (response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
	}
	
	$scope.deleteTasks=function(task){
		$http({method:'DELETE', url:'http://localhost:8080/tasks/' +task.id})
		.then(function (response){
			
			pos =$scope.tasks.indexOf(task);
			$scope.tasks.splice(pos, 1);
				
		} , function (response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
		
		window.alert("Do you really want to delete the task ?");
	};
		
	$scope.changeTaks=function(tk){
		$scope.task = angular.copy(tk);
	};
	
	$scope.cancelChange=function(){
		$scope.task={};
		
	};
	listTasks();
	
});