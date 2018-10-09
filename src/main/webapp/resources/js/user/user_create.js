$(function () {
        $(".btn-create-user").click(function (e) {

                var user = new User($('#fname').val(),
                    $('#lname').val(), $('#email').val(),
                    $('#phone').val(), $('#pass').val());
                let service = new AJAXService();

            function success() {
                location.replace("/users");
            };

            function fail() {
                console.log('fail');
            };

                service.post("/api/1.0/users",user, success, fail);
                e.preventDefault();
            }
        );
    }
);