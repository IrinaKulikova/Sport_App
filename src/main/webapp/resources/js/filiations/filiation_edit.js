$(function () {
        var service = new AJAXService();
        let button = $("#save");
        $("#save").click( function (e) {
                var formsValidator = new FormsValidator();
                var formFiliationEdit = $(".form-filiation-edit");
                if(formsValidator.filiationForm(formFiliationEdit)) {

                    var newFiliation = new Filiation($('#id').val(),
                        $('#caption').val(), $('#country').val(),
                        $('#city').val(), $('#street').val(),
                        $('#building').val(), $('#indexcity').val());
                    console.log(newFiliation);

                    function success() {
                        $("h1").text("Filiation " + $('#caption').val());
                        location.replace("/filiation");
                    };

                    function fail() {
                        console.log("error");
                    };
                    service.put("/api/1.0/filiation/" + button.val(), newFiliation, success, fail);
                    e.preventDefault();
                }
        });

        let add = $("#add");
        $("#add").click(function (e) {
                var contact = new Contact(new ContactType($("#contacts option:selected").val(), $("#contacts option:selected").text()),
                    $("#newcontact").val());
                console.log(contact);

                function success(e) {
                    $container = $("#insert").clone().removeAttr("id").removeAttr("hidden");
                    $("#insert").before($container);
                    $container.find("label").text(contact.contactType.name + ":");
                    $container.find("input").val(contact.data);
                    $container.find(".del").val(e.data.id);
                    $container.find(".del").click(onClickDelete);
                    $("#newcontact").val("");
                    console.log($container);
                };

                function fail() {
                    console.log("error");
                };
                e.preventDefault();
                service.post("/api/1.0/contacts/" + button.val(), contact, success, fail)
            }
        );

        function onClickDelete(e) {
            $del = $(this);

            function success(d) {
                console.log(d.data);
                $del.parent().parent().remove();
            }

            function fail() {
                console.log("error!");
            }

            service.del("/api/1.0/contacts/" + $del.val(), success, fail);
            e.preventDefault();
        }

        $(".del").click(onClickDelete);

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
