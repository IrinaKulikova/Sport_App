$(function () {
    $(".btn-create-user").click(function (e) {
            let formsValidator = new FormsValidator();
            let formUser = $(".create-user-form");
            if (formsValidator.userCreateForm(formUser)) {
                let user = new User($('#fname').val(),
                    $('#lname').val(), $('#email').val(),
                    $('#phone').val(), $('#pass').val());
                let service = new AJAXService();

                function success(e) {
                    window.location.href = e.data.id;
                }

                function fail() {
                    console.log('fail');
                }

                service.post("/api/1.0/users", user, success, fail);
                e.preventDefault();
            }
        }
    );
});