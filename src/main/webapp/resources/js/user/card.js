$(function () {
    $(function () {
        $(".btn-save-card").click(function (e) {
            var cardForm = $(".card-form");
            $(function () {
                cardForm.validate({
                    rules: {
                        description: {
                            required: true,
                            maxlength: 30
                        },
                        issueDate: {
                            required: true,
                            date: true
                        },
                        expirationDate: {
                            required: true,
                            date: true
                        },
                        pinCode: {
                            required: true,
                            minlength: 4,
                            maxlength: 4,
                            number: true
                        }
                    },
                    messages: {
                        description: {
                            required: "Description cant be empty!",
                            maxlength: "Max length: 30 symbols!"
                        },
                        issueDate: {
                            required: "Issue Date cant be empty!",
                            date: "Is not valid date format. (mm/dd/yyyy)"
                        },
                        expirationDate: {
                            required: "Expiration Date cant be empty!",
                            date: "Is not valid date format. (mm/dd/yyyy)"
                        },
                        pinCode: {
                            required: "Pin code cant be empty!",
                            minlength: "Pin code must be 4 numeric symbols!",
                            maxlength: "Pin code must be 4 numeric symbols!",
                            number: "Pin code must contain only numbers!"
                        }
                    }
                });
            });
            if(cardForm.valid()){
                let service = new AJAXService();
                var userId = $("#userId").val();
                var card = new Card($('#pinCode').val(),
                    $('#issueDate').val(), $('#expirationDate').val(),
                    $('#description').val());

                function success() {
                    location.replace("/users/edit/" + userId);
                };

                function fail() {
                    console.log("fail");
                };
                service.post("/api/1.0/cards/" + userId,card,success,fail);

                e.preventDefault();
            }
            }
        );
    });
    $(function () {
        $(".btn-del-card").click(function (e) {
                let service = new AJAXService();
                var cardId = $(this).val();
                var userId = $("#userId").val();
                function success() {
                    location.replace("/users/edit/" + userId);
                };

                function fail() {
                    console.log("fail");
                };

                service.del("/api/1.0/cards/" + userId + "/" + cardId, success, fail);
                e.preventDefault();
            }
        );
    });
});