$(function () {
    $(function () {
            $(".btn-save-changes").click(function (e) {
                    let service = new AJAXService();
                    var btn = $(this);
                    var news = new News($('#title').val(),
                        $('#description').val(), $('#date').val(),
                        $('#imageURL').val());

                    function success() {
                        location.replace("/news");
                    };

                    function fail() {
                        console.log("fail");
                    };
                    service.put("/api/1.0/news/" + btn.val(), news, success, fail);
                    e.preventDefault();
                }
            );
        }
    );

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

    $(function () {
        $(".btn-update-img").click(function (e) {
            $("#news_image").attr("src",$("#imageURL").val());
        });
    });

});