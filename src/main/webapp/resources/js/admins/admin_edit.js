$(function () {
        let button = $("#save");
        $("#save").click(
            function (e) {
                let password1 = $('#password1').val();
                let password2 = $('#password2').val();

                if (password1 !== password2 || password1 === "" || password1 === undefined) {
                    e.preventDefault();
                    return;
                }

                function success(d) {
                    console.log("done!");
                    window.location.replace("http://localhost:8080/admins");
                }

                function fail() {
                    console.log("error!");
                }

                let service = new AJAXService();
                service.put("/api/1.0/admins/" + button.val(), password1, success, fail);
                e.preventDefault();
            }
        );
    }
);