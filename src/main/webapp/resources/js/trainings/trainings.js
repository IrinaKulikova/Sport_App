$(function () {
    let service = new AJAXService();
    let id = document.getElementById("id");
    service.getAll('/api/1.0/shared/' + id.value + '/trainings', function (e) {
        let arr = e.data;
        for (let i = 0; i < arr.length; i++) {
            console.log(arr[i]);
            let dayid = arr[i].day.id;
            let timeid = arr[i].time.id;
            let p = document.createElement('p');
            p.id = arr[i].id;
            p.innerHTML = arr[i].trainingType.name;
            let cell = document.getElementById(dayid + ":" + timeid);
            cell.appendChild(p);
        }
    });

    $("table").dblclick(
        function (e) {
            alert("dbclick " + e.target.id);
        });

    $("table").contextmenu(
        function (e) {
            let result = confirm("Delete training?");
            if (result === true) {
                service.del('/api/1.0/trainings/' + e.target.children[0].id, function () {
                    while (e.target.firstChild) {
                        e.target.removeChild(e.target.firstChild);
                    }
                });
            }
            e.preventDefault();
        });
});