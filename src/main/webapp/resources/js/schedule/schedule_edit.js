$(function () {
    $(".btn-primary").click(function (e) {
       let service=new AJAXService();
       var btn=$(this);
       var schedule=new Schedule(btn.val(),$('#day').val(),
           $('#starttime').val(),$('#sheduleevent').val());
        function success() {
            location.replace("/schedules");
        };
        function fail() {
            console.log("fail");
        };
     //   service.put("/api/1.0/schedules/scheduleedit/4",schedule, success, fail);
        service.put("/api/1.0/schedules/scheduleedit/"+btn.val(),schedule,success,fail);
        e.preventDefault();
    });

});