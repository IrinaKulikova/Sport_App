$(function () {
    $(".btn-delete").click(function (e) {
        let btn = $(this);
        let service = new AJAXService();

        function success() {
            location.reload(true);
        }

        function fail() {
            console.log('fail');
        }

        service.del("/api/1.0/news/" + btn.val(), success, fail);
        e.preventDefault();
    });
});