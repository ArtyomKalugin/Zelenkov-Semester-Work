<#include "base.ftl">

<#macro title>
<title>Регистрация</title>
<link rel="shortcut icon" href="static/img/icon.png" type="image/png">
</#macro>

<#macro content>
<br>

<h1>Регистрация</h1>

<br>

<form action="/login" method="post" novalidate>
    <p class="lead">
        Введите никнейм:<br>
        <input name="nickname" type="text"/><br>
    </p>

    <p class="lead">
        Введите имя:<br>
        <input name="first_name" type="text"/><br>
    </p>

    <p class="lead">
        Введите фамилию:<br>
        <input name="second_name" type="text"/><br>
    </p>

    <p class="lead">
        Введите электронную почту:<br>
        <input name="email" type="text"/><br>
    </p>

    <p class="lead">
        Выберите аватар:<br>
        <input name="avatar" type="file"/><br>
    </p>

    <p class="lead">
        Введите логин:<br>
        <input name="login" type="text"/><br>
    </p>

    <p class="lead">
        Введите пароль:<br>
        <input name="password" type="password"><br>
    </p>

    <br>
    <p class="lead">
        <input type="submit" value="Зарегистрироваться">
    </p>
    <br>

</form>
</#macro>