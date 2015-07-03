/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('noteController', ['$scope', '$http', 'fileUpload', function ($scope, $http, fileUpload) {
    
    var getItems = function () {
        $http.post('/note/list')
            .success(function (data) {
                console.log(data);
                $scope.items = data;
            })
            .error(function () {
                alert('Error loading Items');
            });
    };
    
    getItems();
    
    $scope.newItem = {};
    $scope.visible = false;
    
    
    $scope.saveItem = function () {
        console.log($scope.newitem.id);

        var id = $scope.newitem.id;
        var file = $scope.myFile;
        var title = $scope.newitem.title;
        var description = $scope.newitem.description;
        if (id) {
            fileUpload.uploadEditFileToUrl(file, id, title, description);
        } else {
            fileUpload.uploadNewFileToUrl(file, title, description);
            
        }
        $scope.newitem = {};
    };
    
    $scope.delete = function(id) {
         
        //search contact with given id and delete it
        for(i in $scope.items) {
            
            if($scope.items[i].id == id) {
                $.ajax({
                    method: 'post',
                    url: '/note/delete',
                    data: "id=" + id
                })
                .success(function (item, status, response, config) {
                    console.log(id, item);
                })
                .error(function (data, status, headers, config) {
                    alert('Error deleting Item');
                });
                $scope.items.splice(i,1);
            }
        }
         
    };
    
    $scope.add = function() {$scope.visible = true;}
    
    $scope.edit = function(id) {
        $scope.visible = true;
            console.log(id);
            for(i in $scope.items) {
                if($scope.items[i].id == id) {
                    //I use angular.copy() method to create
                    $.ajax({
                    method: 'post',
                    url: '/note/edit',
                    data: "id=" + id
                    })
                    .success(function (item, status, response, config) {
                        console.log(item);
                       
                    })
                    .error(function (data, status, headers, config) {
                        alert('Error edit Item');
                    });
                    
                    $scope.newitem = angular.copy($scope.items[i]);
                }
            }
    //search contact with given id and update it
        
    }

    
}]);
