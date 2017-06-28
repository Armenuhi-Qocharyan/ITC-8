function a() {
    this.b = function() {
        alert("hi");
    }
}

(new a()).b();
