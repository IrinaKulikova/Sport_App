<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <meta charset="UTF-8"/>
    <title>Добавить событие</title>
    <style>
        div{height: 70px}
        form{width: 300px;margin:  0 auto;margin-top: 0px;}
    </style>
    <!--   <link rel="stylesheet" href="/css/style.css"> -->
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
<form method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="nameEvent"></label>
        <input type="text" class="form-control" id="nameEvent"  placeholder="" name="nameEvent">

    </div>
    <div class="form-group">
        <label for="lastname">Фамилия</label>
        <input type="text" class="form-control" id="lastname" placeholder="" name="lastname">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" placeholder="" name="email">
    </div>
    <div class="form-group">
        <label for="fone">Номер телефона</label>
        <input type="text" class="form-control" id="fone" placeholder="" name="fone">
    </div>
    <div class="form-group">
        <label for="date">Дата</label>
        <input type="date" class="form-control" id="date" placeholder="" name="date">
    </div>
    <div class="form-group">
        <label for="statys">Статус</label>
        <select id="statys" class="form-control" name="statys">
            <option value="Active" selected>Active</option>
            <option value="NoActive">NoActive</option>
        </select>
    </div>
    <div class="form-group">
        <label for="salary">Зарплата</label>
        <input type="text" class="form-control" id="salary" placeholder="25 000" name="salary">
    </div>
    <div class="form-group">
        <label for="details">Заметки</label>
        <input type="text" class="form-control" id="details" placeholder="" name="details">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>