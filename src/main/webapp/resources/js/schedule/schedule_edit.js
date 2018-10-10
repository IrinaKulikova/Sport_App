$(function () {
    $(".btn-primary").click(function (e) {
       let service=new AJAXService();
       var btn=$(this);
       var schedule=new Schedule(btn.val(),$('#day').val(),
           $('#starttime').val(),$('#sheduleevent').val());
        function success() {
            location.replace("/");
        };
        function fail() {
            console.log("fail");
        };
        service.put("/schedules/dbclickedit",schedule, success, fail);
        e.preventDefault();
    });

});