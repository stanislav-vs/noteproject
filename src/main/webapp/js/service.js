/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
app.service('fileUpload', ['$http', function ($http) {

    this.uploadEditFileToUrl = function(file, id, title, description){
        var formEditData = new FormData();
        formEditData.append('id', id);
        
        if (file) {
              formEditData.append('pictureFile', file);
            }

        formEditData.append('title', title);
        formEditData.append('description', description);
        return $http({
            method: "POST",
            url: '/note/save',
            data: formEditData,
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });
    };
    this.uploadNewFileToUrl = function(file, title, description){
        var formNewData = new FormData();
        formNewData.append('pictureFile', file);
        formNewData.append('title', title);
        formNewData.append('description', description);
        return $http({
            method: "POST",
            url: 'note/save',
            data: formNewData,
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
            });
    };
}]);