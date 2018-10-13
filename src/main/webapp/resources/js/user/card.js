$(function () {
    $(function () {
        $(".btn-save-card").click(function (e) {
            var formsValidator = new FormsValidator();
            var cardForm = $(".card-form");
            if(formsValidator.cardCreateForm(cardForm)){
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