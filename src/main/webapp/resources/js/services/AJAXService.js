class AJAXService {

    post(url, entityDTO, success, fail) {
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: url,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(entityDTO),
            async: true,
            success: success,
            error: fail
        });
    }

    put(url, entityDTO, success, fail) {
        $.ajax({
            type: 'PUT',
            dataType: 'json',
            url: url,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(entityDTO),
            async: true,
            success: success,
            error: fail
        });
    }

    del(url, success, fail) {
        $.ajax({
            type: 'DELETE',
            url: url,
            success: success,
            error: fail
        });
    }

    getAll(url, success) {
        $.ajax({
            type: 'GET',
            url: url,
            success: success,
        });
    }
}