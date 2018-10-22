$(function () {
    $(".btn-save-changes").click(function (e) {
        let formsValidator = new FormsValidator();
        let formNewsEdit = $(".edit-news-form");
        if (formsValidator.newsEditForm(formNewsEdit)) {
            let service = new AJAXService();
            let btn = $(this);
            let news = new News($('#title').val(),
                $('#description').val(), $('#date').val(),
                $('#imageURL').val());

            function success() {
                location.replace("/news");
            }

            function fail() {
                console.log("fail");
            }
            service.put("/api/1.0/news/" + btn.val(), news, success, fail);
            e.preventDefault();
        }
    });

    $(".form-control").dblclick(function (e) {
        $(this).attr("readonly", false);
    });

    $(".form-control").blur(function (e) {
        $(this).attr("readonly", true);
    });

    $(".btn-update-img").click(function (e) {
        $("#news_image").attr("src", $("#imageURL").val());
    });
});