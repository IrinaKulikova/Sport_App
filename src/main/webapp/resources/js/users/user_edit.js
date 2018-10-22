$(function () {
    $(".btn-save-changes").click(function (e) {
        let formsValidator = new FormsValidator();
        let userForm = $(".user-form");
        if (formsValidator.userEditForm(userForm)) {
            let service = new AJAXService();
            let btn = $(this);
            let user = new User($('#fname').val(),
                $('#lname').val(), $('#email').val(),
                $('#phone').val(), $('#pass').val());

            function success() {
                location.replace("/users");
            }

            function fail() {
                console.log("fail");
            }

            service.put("/api/1.0/users/" + btn.val(), user, success, fail);
            e.preventDefault();
        }
    });

    $(".form-control").dblclick(function (e) {
        $(this).attr("readonly", false);
    });

    $(".form-control").blur(function (e) {
        $(this).attr("readonly", true);
    });
});