$(function () {
    let service = new AJAXService();
    service.getAll('/api/1.0/shared/1/trainings', function (e) {
        console.log(e.data);
        //insert into cells by id
    });
});