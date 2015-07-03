/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var app = angular.module('noteApp', [])
    app.directive('fileModel', ['$parse', function ($parse) {
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                var model = $parse(attrs.fileModel);
                var modelSetter = model.assign;

                element.bind('change', function(){
                    scope.$apply(function(){
                        modelSetter(scope, element[0].files[0]);
                    });
                });
            }
        };
    }]);
    app.service('fileUpload', ['$http', function ($http) {
            
        this.uploadEditFileToUrl = function(file, id, title, description){
            var formEditData = new FormData();
            formEditData.append('id', id);
            formEditData.append('pictureFile', file);
            formEditData.append('title', title);
            formEditData.append('description', description);
            $http({
                method: "POST",
                url: '/note/save',
                data: formEditData,
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .success(function (item, status, response, config) {
                console.log(item);
            })
            .error(function (data, status, headers, config) {
                alert('Error to edit Item');
            });
        };
        this.uploadNewFileToUrl = function(file, title, description){
            var formNewData = new FormData();
            formNewData.append('pictureFile', file);
            formNewData.append('title', title);
            formNewData.append('description', description);
            $http({
                method: "POST",
                url: 'note/save',
                data: formNewData,
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
                })
            .success(function(response){
                console.log(response);
            })
            .error(function(){
            });
        };
    }]);