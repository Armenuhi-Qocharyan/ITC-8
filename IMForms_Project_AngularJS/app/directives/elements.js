createApp.directive("fullName", function() {
    return {
        template: "<form class='name forms' id='ElementfullName' style='display: none;'><label for='fname'>First Name</label><br><input class='inputs' type='text' id='fname' name='firstname' placeholder='Name...' disabled><br><label for='lname'>Last Name</label><br><input class='inputs' type='text' id='lname' name='lastname' placeholder='Last name..' disabled><button type='button' class='btn btn-danger btn-circle btn-xl RemoveButton' onclick='Remove(this)'><i class='glyphicon glyphicon-remove'></i></button></form>"
    };
});

createApp.directive("email", function() {
    return {
        template: "<form class='email forms' id='Elementemail' style='display: none;'><label for='mail'>Email</label><br><input class='inputs' type='email' name='email' id='mail' disabled><button type='button' class='btn btn-danger btn-circle btn-xl RemoveButton' onclick='Remove(this)'><i class='glyphicon glyphicon-remove'></i></button></form>"
    };
});

createApp.directive("address", function() {
    return {
        template: "<form class='address forms' id='Elementaddress' style='display: none;'><label for='country'>Country</label><br><select class='input' id='country' name='country' disabled><option value='australia'>Australia</option><option value='canada'>Canada</option><option value='usa'>USA</option></select><button type='button' class='btn btn-danger btn-circle btn-xl RemoveButton' onclick='Remove(this)'><i class='glyphicon glyphicon-remove'></i></button></form>"
    };
});

createApp.directive("phone", function() {
    return {
        template: "<form class='phone forms' id='Elementphone' style='display:none'><label for='phone'>Telephone</label><br><input class='inputs' type='tel' name='usrtel' disabled><button type='button' class='btn btn-danger btn-circle btn-xl RemoveButton' onclick='Remove(this)'><i class='glyphicon glyphicon-remove'></i></button></form>"
    };
});

createApp.directive("birthday", function() {
    return {
        template: "<form class='birthday forms' id='Elementbirthday' style='display:none'><label for=''>Birthday</label><br><input class='inputs' type='date' name='bday' disabled><button type='button' class='btn btn-danger btn-circle btn-xl RemoveButton' onclick='Remove(this)'><i class='glyphicon glyphicon-remove'></i></button></form>"
    };
});
