$(function () {
        let button = $("#save");
        $("#save").click(
            function (e) {
                var newFiliation = new Filiation($('#id').val(),
                    $('#caption').val(), $('#country').val(),
                    $('#city').val(), $('#street').val(),
                    $('#building').val(), $('#indexcity').val());

                function success() {
                    console.log("done!");
                }

                function fail() {
                    console.log("error!");
                }

                let service = new AJAXService();
                service.post("/api/1.0/filiation/", newFiliation, success, fail);
                e.preventDefault();
            }
        );
    }
);