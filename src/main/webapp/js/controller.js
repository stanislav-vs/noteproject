/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('mainController', ['$scope', '$http', 'fileUpload', function ($scope, $http, fileUpload) {
                            
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


//    $scope.showModal = false;

    $scope.openDialog = function (id) {
//        $scope.showModal = !$scope.showModal;
//        scope.myFile = "";
        console.log(id);
        if (id) {
            for (i in $scope.items) {
                if ($scope.items[i].id == id) {
                    //I use angular.copy() method to create

                    $scope.newitem = angular.copy($scope.items[i]);
                }
            }
        } else {
            $scope.newitem = {};

//            $rootScope.myFile = 1;
        }
    };



    $scope.newitem = {};


    $scope.saveItem = function () {
        console.log($scope.myFile);

        var file = $scope.myFile;
        var title = $scope.newitem.title;
        var description = $scope.newitem.description;

        if ($scope.newitem.id) {

            var id = $scope.newitem.id;

            fileUpload.uploadEditFileToUrl(file, id, title, description)
                .success(function (item) {
                    for (i in $scope.items) {
                        if ($scope.items[i].id == item.id) {
                            //I use angular.copy() method to create

                            $scope.items[i].title = item.title;
                            $scope.items[i].description = item.description;
                            $scope.items[i].picture = item.picture;
                        }
                    }
                    $scope.showModal = false;
            });
        } else {
            fileUpload.uploadNewFileToUrl(file, title, description)
                    .success(function (item) {
                        $scope.items.push(item);
                    $scope.showModal = false;
                    });

        }

        $scope.newitem = {};
    };

    $scope.delete = function (id) {

        //search contact with given id and delete it
        for (i in $scope.items) {

            if ($scope.items[i].id == id) {
                $.ajax({
                    method: 'post',
                    url: '/note/delete',
                    data: "id=" + id
                });

                $scope.items.splice(i, 1);
            }
        }

    };
}]);
