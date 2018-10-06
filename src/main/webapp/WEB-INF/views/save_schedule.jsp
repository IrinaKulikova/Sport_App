<%--
  Created by IntelliJ IDEA.
  User: Aleks
  Date: 06.10.2018
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <meta charset="UTF-8"/>
    <title>Добавить Расписание</title>
    <style>
        form{width: 500px;margin:  0 auto;margin-top: 0px;}
    </style>
</head>
<body>
<!--<button class="btn btn-primary">Добавить событие</button> -->
<form  method="post" accept-charset="UTF-8">
    <div class="form-group">
        <label for="sheduleevent">Событие</label>
        <select class="form-control" id="sheduleevent" name="event_schedule" >
            <option value="1">Событие1</option>
            <option value="2">Событие2</option>
            <option value="3">Событие3</option>
            <option value="4">Событие4</option>
            <option value="5">Событие5</option>
            <option value="6">Событие6</option>
            <option value="7">Событие7</option>
            <option value="8">Событие8</option>
        </select>
    </div>
    <div class="form-group" accept-charset="UTF-8">
        <label for="week">День недели</label>
        <select class="form-control" id="week" name="day">
            <option value="1">Понедельник</option>
            <option value="2">Вторник</option>
            <option value="3">Среда</option>
            <option value="4">Четвeрг</option>
            <option value="5">Пятница</option>
            <option value="6">Суббота</option>
            <option value="7">Воскресенье</option>
        </select>
    </div>
    <div class="form-row">
        <div class="form-group">
            <label for="hour">Часы</label>
            <select multiple class="form-control" id="hour" name="hour" style="width: 100px"  >
                <option value="8">8</option>
                <option value="9" selected>9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option>13</option>
                <option>14</option>
                <option>16</option>
                <option>17</option>
                <option>18</option>
                <option>19</option>
                <option>20</option>
            </select>
        </div>
        <div class="form-group">
            <label for="min">Минуты</label>
            <select class="form-control" id="min" name="min" style="width: 100px">
                <option value="00" selected>00</option>
                <option value="30">30</option>
            </select>
        </div>

    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</body>
</html>
