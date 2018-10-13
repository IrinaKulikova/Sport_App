$(function () {

    $(".del").click(function (e) {
        $del = $(this);
        console.log("del");
        let service = new AJAXService();

        function success() {
            $del.parent().parent().remove();
            console.log('done!');
        };

        function fail() {
            console.log('fail!');
        };

        service.del("/api/1.0/events/" + $del.val(), success, fail);
        e.preventDefault();
    });
});