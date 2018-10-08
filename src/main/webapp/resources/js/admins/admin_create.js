$(function () {
        let button = $("#save");
        $("#save").click(
            function (e) {

                let email = $("#email").val();
                let login = $("#login").val();
                let admin = new Administrator(0, login, email);

                function success(d) {
                    console.log("done!");
                    window.location.replace("http://localhost:8080/admins");
                }

                function fail() {
                    console.log("error!");
                }

                let service = new AJAXService();
                service.post("/api/1.0/admins/", admin, success, fail);
                e.preventDefault();
            }
        );
    }
);