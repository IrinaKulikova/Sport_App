$(function () {
        let button = $("#save");
        $("#save").click(
            function (e) {

                let caption = $('#caption').val();
                let country = $('#country').val();
                let city = $('#city').val();
                let street = $('#street').val();
                let building = $('#building').val();
                let indexCity = $('#indexcity').val();

                if (caption === "" || country === "" || city === "" || street === "" || building === "" ||
                    indexCity === "" || caption === undefined || country === undefined || city === undefined
                    || street === undefined || building === undefined || indexCity === undefined) {
                    e.preventDefault();
                    return;
                }

                var newFiliation = new Filiation($('#id').val(),
                    $('#caption').val(), $('#country').val(),
                    $('#city').val(), $('#street').val(),
                    $('#building').val(), $('#indexcity').val());

                function success(d) {
                    console.log("done!");
                    window.location.href = d.data.id;
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