$(function () {
        $("#save").click(function (e) {
                let button = $(this);
                let service = new AJAXService();
                let formsValidator = new FormsValidator();
                let formEventEdit = $(".edit-event-form");
                if (formsValidator.eventForm(formEventEdit)) {
                    let name = $('#name').val();
                    let description = $('#description').val();

                    let trainigtype = new DTOTrainingType(name, description);

                    function success(d) {
                        location.replace("/trainingtypes");
                    }

                    function fail(e) {
                        console.log("error!" + e);
                    }

                    service.put("/api/1.0/events/" + button.val(), trainigtype, success, fail);
                    e.preventDefault();
                }
            }
        );

        $(".form-control").dblclick(function (e) {
            $(this).attr("readonly", false);
        });

        $(".form-control").blur(function (e) {
            $(this).attr("readonly", true);
        });
    }
);