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
            p.innerHTML = arr[i].trainingType.name;
            let cell = document.getElementById(dayid + ":" + timeid);
            cell.appendChild(p);
        }
    });
});