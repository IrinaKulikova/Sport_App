<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <meta charset="UTF-8"/>
    <title>Добавить событие</title>
</head>
<body>
form method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="name">Наименование тренировки</label>
        <input type="text" class="form-control" id="name"  placeholder="" name="name">

    </div>
    <div class="form-group">
        <label for="description">Описание тренировки</label>
        <textarea class="form-control" id="description" placeholder="" name="description" row="5"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Сохранить</button>
</form>
</body>
</html>