$(function () {
    $(".btn-save-card").click(function (e) {
        let formsValidator = new FormsValidator();
        let cardForm = $(".card-form");
        if (formsValidator.cardCreateForm(cardForm)) {
            let service = new AJAXService();
            let userId = $("#userId").val();
            let card = new Card($('#pinCode').val(),
                $('#issueDate').val(), $('#expirationDate').val(),
                $('#description').val());

            function success() {
                location.replace("/users/" + userId);
            }

            function fail() {
                console.log("fail");
            }

            service.post("/api/1.0/cards/" + userId, card, success, fail);
            e.preventDefault();
        }
    });

    $(".btn-del-card").click(function (e) {
        let service = new AJAXService();
        let cardId = $(this).val();
        let userId = $("#userId").val();

        function success() {
            location.replace("/users/" + userId);
        }

        function fail() {
            console.log("fail");
        }

        service.del("/api/1.0/cards/" + userId + "/" + cardId, success, fail);
        e.preventDefault();
    });
});
