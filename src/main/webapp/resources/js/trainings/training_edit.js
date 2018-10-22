$(function () {
    $(".btn-primary").click(function (e) {
        let service = new AJAXService();
        let btn = $(this);
        let schedule = new DTOTraining(btn.val(), $('#day').val(),
            $('#time').val(), $('#sheduleevent').val());

        function success() {
            location.replace("/trainings");
        }

        function fail() {
            console.log("fail");
        }

        service.put("/api/1.0/trainings/scheduleedit/" + btn.val(), schedule, success, fail);
        e.preventDefault();
    });

});