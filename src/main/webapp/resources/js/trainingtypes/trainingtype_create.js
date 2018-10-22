$(function () {
        $("#save").click(function (e) {
                let formsValidator = new FormsValidator();
                let formEventCreate = $(".create-event-form");
                if (formsValidator.eventForm(formEventCreate)) {

                    let name = $('#name').val();
                    let description = $('#description').val();

                    let newTrainingType = new DTOTrainingType(name, description);

                    function success(d) {
                        console.log("done!");
                        location.replace("/trainingtypes/"+d.data.id);
                    }

                    function fail() {
                        console.log("error!");
                    }

                    let service = new AJAXService();
                    service.post("/api/1.0/trainingtypes/", newTrainingType, success, fail);
                    e.preventDefault();
                }
            }
        );
    }
);