$(function () {
    $(".btn-create-news").click(function (e) {
            let formsValidator = new FormsValidator();
            let formNews = $(".create-news-form");
            if (formsValidator.newsCreateForm(formNews)) {
                let service = new AJAXService();
                let news = new News($('#title').val(),
                    $('#description').val(), $('#date').val(),
                    $('#imageURL').val());

                function success() {
                    location.replace("/news");
                }

                function fail() {
                    console.log('fail');
                }

                service.post("/api/1.0/news", news, success, fail);
                e.preventDefault();
            }
        }
    );

    $(".btn-update-img").click(function (e) {
        $("#news_image").attr("src", $("#imageURL").val());
    });
});