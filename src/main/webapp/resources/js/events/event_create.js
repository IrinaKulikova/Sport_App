$(function () {
        $("#save").click(
            function (e) {
                var formsValidator = new FormsValidator();
                var formEventCreate = $(".create-event-form");
                if(formsValidator.eventForm(formEventCreate)) {

                    let name = $('#name').val();
                    let description = $('#description').val();

                    var newEvent = new DTOEvent(name, description);

                    function success(d) {
                        console.log("done!");
                        location.replace("/events");
                    }

                    function fail() {
                        console.log("error!");
                    }

                    let service = new AJAXService();
                    service.post("/api/1.0/events/", newEvent, success, fail);
                    e.preventDefault();
                }
            }
        );
    }
);