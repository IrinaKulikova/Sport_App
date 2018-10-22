$(function () {
    let button = $("#save");
    $("#save").click(function (e) {
        let formsValidation = new FormsValidator();
        let formEditAdmin = $(".edit-admin-form");
        if(formsValidation.adminEditForm(formEditAdmin)) {
            let password1 = $('#password1').val();

            function success(d) {
                console.log("done!");
                location.replace("/admins");
            }

            function fail() {
                console.log("error!");
            }

            let service = new AJAXService();
            service.put("/api/1.0/admins/" + button.val(), password1, success, fail);
            e.preventDefault();
        }
    });
});