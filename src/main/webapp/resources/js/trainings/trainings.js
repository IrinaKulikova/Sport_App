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

    //ячейка таблицы по которой кликнули
    let td = null;

    $('td').click(function (e) {
        if ($(e.target).is("td")) {
            td = e.target;
        }
        if ($(e.target).is("p")) {
            td = e.target.parentElement;
        }
    });


    function success(e) {
        let dayid = e.data.day.id;
        let timeid = e.data.time.id;
        let td = document.getElementById(dayid + ":" + timeid);
        let firstchild = td.firstChild;
        if (firstchild === undefined || firstchild === null) {
            firstchild = document.createElement('p');
            td.appendChild(firstchild);
        }
        firstchild.innerText = e.data.trainingType.name;
    }


    $('#save').click(function (e) {
        let ids = td.id.match(/([\d]+):([\d]+)/);
        let trining = new DTOTraining(ids[1],
            ids[2],
            $("#type-id option:selected").val(),
            $('#id').val());
        service.put('/api/1.0/trainings/', trining, success, null);
        $('#addmodal').modal('hide');
    });
});