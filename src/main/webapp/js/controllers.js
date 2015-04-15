/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var app = angular.module('noteList', [])
app.controller('NoteListController', [ '$scope', '$http', function ($scope, $http) {
    $scope.item = ($(this).data("itemid"));
    $scope.newItem = {};
    $scope.loadItems = function(){
        $http.post('/note/list')
        .success(function(data, status, headers, config) {
            $scope.items = data;
         })
        .error(function(data, status, headers, config) {
              alert('Error loading Items');
        });
    };
    $scope.addItem = function(){
        $scope.items.push($scope.enteredId, $scope.enteredTitle, $scope.enteredDescription);
        $http.post('note/create',$scope.newItem)
        .success(function(data, status, headers, config) {
            $scope.newItem = {};
            $scope.loadItems();
         })
        .error(function(data, status, headers, config) {
              alert('Error saving Item');
        });
    };
  
    $scope.deleteItem = function(){
        $http.post('note/delete', $scope.item)
            .success(function(data, status, headers, config) {
            $scope.loadItems();
         })
        .error(function(data, status, headers, config) {
              alert('Error deleting Item');
        });
    };
     
    $scope.loadItems();
}]);