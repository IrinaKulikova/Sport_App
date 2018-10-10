$(function () {
    $(function () {
            $(".btn-save-changes").click(function (e) {
                    let service = new AJAXService();
                    var btn = $(this);
                    var user = new User($('#fname').val(),
                        $('#lname').val(), $('#email').val(),
                        $('#phone').val(), $('#pass').val());

                    function success() {
                        location.replace("/users");
                    };

                    function fail() {
                        console.log("fail");
                    };
                    service.put("/api/1.0/users/" + btn.val(), user, success, fail);
                    e.preventDefault();
            }
            );
        }
    );

    $(function () {
        $(".form-control").dblclick(function (e) {
            $(this).attr("readonly",false);
        });
    });

    $(function () {
        $(".form-control").blur(function (e) {
            $(this).attr("readonly",true);
        });
    });

});