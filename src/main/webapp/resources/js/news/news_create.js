$(function () {
    $(function () {
        $(".btn-create-news").click(function (e) {
                var formsValidator = new FormsValidator();
                var formNews = $(".create-news-form");
                if(formsValidator.newsCreateForm(formNews)) {
                    let service = new AJAXService();
                    var news = new News($('#title').val(),
                        $('#description').val(), $('#date').val(),
                        $('#imageURL').val());

                    function success() {
                        location.replace("/news");
                    };

                    function fail() {
                        console.log('fail');
                    };

                    service.post("/api/1.0/news", news, success, fail);
                    e.preventDefault();
                }
            }
        );
    });

    $(function () {
        $(".btn-update-img").click(function (e) {
            $("#news_image").attr("src", $("#imageURL").val());
        });
    });
});