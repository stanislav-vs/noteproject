/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('userController', ['$scope', '$http', function ($scope, $http) {
        var getUsers = function () {
            $http.post('/userslist')
                    .success(function (data) {
                        console.log(data);
                        $scope.users = data;
                    })
                    .error(function () {
                        alert('Error loading Users');
                    });
        };
        getUsers();
        
    }]);
