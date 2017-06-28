function getRequest() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert(xhr.responseText);
            } else {
                alert('Error: ' + xhr.status);
            }
        }
    };
    xhr.open('GET', "http://localhost/a.txt", true);
    xhr.send();
}