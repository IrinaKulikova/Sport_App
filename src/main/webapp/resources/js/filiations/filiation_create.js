$(function () {
        $("#save").click(function (e) {
            let formsValidator = new FormsValidator();
            let formFiliationCreate = $(".form-filiation-create");
            if(formsValidator.filiationForm(formFiliationCreate)){
                let newFiliation = new Filiation($('#id').val(),
                    $('#caption').val(), $('#country').val(),
                    $('#city').val(), $('#street').val(),
                    $('#building').val(), $('#indexcity').val());

                function success(d) {
                    window.location.href = d.data.id;
                }

                function fail() {
                    console.log("error!");
                }

                let service = new AJAXService();
                service.post("/api/1.0/filiations/", newFiliation, success, fail);
                e.preventDefault();
            }
        });
    }
);