$(function () {
    $("#reloading").attr('href', '/filiation/0');

    $(".del").click(function (e) {
        $del = $(this);
        let service = new AJAXService();

        function success() {
            $del.parent().parent().remove();
            console.log('done!');
        };

        function fail() {
            console.log('fail!');
        };

        service.del("/api/1.0/filiation/" + $del.val(), success, fail);
        e.preventDefault();
    });
});