$(function () {
    $(function () {

        $("#save").click(
            function (e) {
                var button = $(this);
                var formsValidator = new FormsValidator();
                var formEventEdit = $(".edit-event-form");
                if(formsValidator.eventForm(formEventEdit)) {
                    let name = $('#name').val();
                    let description = $('#description').val();


                    let event = new DTOEvent(name, description);

                    function success(d) {
                        console.log("done!");
                        window.location.replace("http://localhost:8080/events");
                    }

                    function fail(e) {
                        console.log(e);
                        console.log("error!");
                    }

                    let service = new AJAXService();
                    service.put("/api/1.0/events/" + button.val(), event, success, fail);
                    e.preventDefault();
                }
            }
        );
    });


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

    }
);