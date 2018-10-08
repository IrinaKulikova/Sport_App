$(function () {
        let button = $("#save");
        $("#save").click(
            function (e) {
                var newFiliation = new Filiation($('#id').val(),
                    $('#caption').val(), $('#country').val(),
                    $('#city').val(), $('#street').val(),
                    $('#building').val(), $('#indexcity').val());

                function success(){
                    console.log("done!");
                }

                function fail(){
                    console.log("error!");
                }

                let service= new AJAXService();
                service.post("/api/1.0/filiation/",newFiliation,success,fail);

                // $.ajax({
                //     type: 'POST',
                //     dataType: 'json',
                //     url: "/api/1.0/filiation/",
                //     contentType: 'application/json; charset=utf-8',
                //     data: JSON.stringify(newFiliation),
                //     async: true,
                //     success: function () {
                //         $('#info').text("success");
                //     },
                //     error: function () {
                //         $('#info').text("error");
                //     }
                // });
                e.preventDefault();
            }
        );
    }
);