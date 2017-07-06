createApp.controller("sideNav", function($scope) {
    $scope.items = ["FullName", "Email", "Address", "Phone", "Date of Birth", "Education", "Skills", "Work Experience", "Submit", "Dropdown", "Gender", "Hobby", "Image"];
});


createApp.controller("sideBar", function($scope, draggableData) {
    $scope.Data = [];
    for(var i = 0,len = draggableData.length; i < len; ++i){
        $scope.data = {};
        $scope.data.idName = draggableData[i].id;
        $scope.data.className = draggableData[i].class;
        $scope.data.name = draggableData[i].name;
        $scope.Data.push($scope.data);
    }
});
