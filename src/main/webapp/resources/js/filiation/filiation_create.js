$(function () {
        $("#save").click(function (e) {
            var formsValidator = new FormsValidator();
            var formFiliationCreate = $(".form-filiation-create");
            if(formsValidator.filiationForm(formFiliationCreate)){
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
        });
    }
);