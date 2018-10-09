$(function () {
        let button = $("#save");
        $("#save").click(
            function (e) {

                let name = $('#name').val();
                let description = $('#description').val();

                if (name === "" || description === "" || name === undefined || description === undefined) {
                    e.preventDefault();
                    return;
                }

                var newEvent = new DTOEvent(name, description);

                function success(d) {
                    console.log("done!");
                    window.location.replace("http://localhost:8080/events");
                }

                function fail() {
                    console.log("error!");
                }

                let service = new AJAXService();
                service.post("/api/1.0/events/", newEvent, success, fail);
                e.preventDefault();
            }
        );
    }
);