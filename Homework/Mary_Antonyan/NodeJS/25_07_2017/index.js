var addUser = function() {
    document.getElementById("article").innerHTML="<b>Title</b> : Add User<hr/><b>URL</b> : /register<hr/><b>Method</b> : POST<hr/><b>Data Params</b> : { email : [string], name : [string], password : [alphanumeric], password_confirmation : [alphanumeric] }<hr/><b>Response Codes</b>: Success (200 OK), Bad Request (400)";
}

var login = function() {
    document.getElementById("article").innerHTML="<b>Title</b> : Login<hr/><b>URL</b> : /login<hr/><b>Method</b> : POST<hr/><b>Data Params</b> : { email : [string], password : [alphanumeric], session_id : [alphanumeric] }<hr/><b>Response Codes</b>: Success (200 OK), Bad Request (400)";
}

var getForms = function() {
    document.getElementById("article").innerHTML="<b>Title</b> : Get List Of Forms<hr/><b>URL</b> : /my-forms<hr/><b>Method</b> : GET<hr/><b>URL Params</b> : user_id : [integer]<hr/><b>Response</b> : { my-forms : [array of strings] }<hr/><b>Response Codes</b>: Success (200 OK), Bad Request (400), Unauthorized (401)";
}

var getFilledForms = function() {
    document.getElementById("article").innerHTML="<b>Title</b> : Get List Of Filled Forms<hr/><b>URL</b> : /my-forms<hr/><b>Method</b> : GET<hr/><b>URL Params</b> : user_id : [integer], form_id : [integer]<hr/><b>Response</b> : { filled : [array of JSONs] }<hr/><b>Response Codes</b>: Success (200 OK), Bad Request (400), Unauthorized (401), Forbidden (403)";
}

var saveNewForm = function() {
    document.getElementById("article").innerHTML="<b>Title</b> : Save Created Form<hr/><b>URL</b> : /create-forms<hr/><b>Method</b> : POST<hr/><b>Data Params</b> : { user_id : [integer], form_id : [integer], form_content : [JSON] }<hr/><b>Response Codes</b>: Success (200 OK), Bad Request (400), Unauthorized (401), Forbidden (403)";
}

var logout = function() {
    document.getElementById("article").innerHTML="<b>Title</b> : Logout<hr/><b>URL</b> : /logout<hr/><b>Method</b> : POST<hr/><b>Data Params</b> : { user_id : [integer], session_id : [alphanumeric] }<hr/><b>Response Codes</b>: Success (200 OK), Bad Request (400), Unauthorized (401)";
}

var fillForm = function() {
    document.getElementById("article").innerHTML="<b>Title</b> : Fill Form<hr/><b>URL</b> : /submit<hr/><b>Method</b> : POST<hr/><b>Data Params</b> : { form_id : [integer], filled_content : [JSON] }<hr/><b>Response Codes</b>: Success (200 OK), Bad Request (400)";
}
