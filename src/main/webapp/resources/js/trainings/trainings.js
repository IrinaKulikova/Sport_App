$(function () {
    let service = new AJAXService();
    let id = document.getElementById("id");
    service.getAll('/api/1.0/shared/' + id.value + '/trainings', function (e) {
        let arr = e.data;
        for (let i = 0; i < arr.length; i++) {
            let dayid = arr[i].day.id;
            let timeid = arr[i].time.id;
            let p = document.createElement('p');
            p.id = arr[i].id;
            p.innerHTML = arr[i].trainingType.name;
            document.getElementById(dayid + ":" + timeid).appendChild(p);
        }
    });

    $("table").contextmenu(
        function (e) {
            if ($(e.target).is("td")) {
                if (e.target.children.length >= 1) {
                    if (confirm("Delete training?")) {
                        service.del('/api/1.0/trainings/' + e.target.children[0].id, function () {
                            while (e.target.firstChild) {
                                e.target.removeChild(e.target.firstChild);
                            }
                        });
                    }
                }
            }
            else if ($(e.target).is("p")) {
                if (confirm("Delete training?")) {
                    service.del('/api/1.0/trainings/' + e.target.id, function () {
                        let p = e.target.parentElement;
                        while (p.firstChild) {
                            p.removeChild(p.firstChild);
                        }
                    });
                }
            }
            e.preventDefault();
        });

    $('#addmodal').on('hidden.bs.modal', function (e) {
        alert("modal!");
    });
});