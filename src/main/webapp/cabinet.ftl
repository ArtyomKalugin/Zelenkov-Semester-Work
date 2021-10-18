<#include 'base.ftl'>

<#macro title>
<title>Личный кабинет</title>
<link rel="shortcut icon" href="static/img/pancake.jpg" type="image/jpg">
</#macro>

<#macro content>
<br>
<h1>Ваш личный кабинет</h1>
<br>
<table>
    <tr>
        <td><img alt="user_img" src="/static/img/{{p}}" width="50" height="50" class="rounded-circle"></td>
        <td><p class="lead"><strong>${user.nickname}</strong></p></td>
        <td><p class="lead"><em>${user.firstName}  ${user.secondName}</em></p></td>
    </tr>
</table>
<form action="/cabinet" method="post" novalidate enctype="multipart/form-data">
    <p class="lead">
        Смена аватарки
    </p>

    <p class="lead">
        <input name="avatar" type="file">
    </p>

    <p class="lead">
        <p class="lead"><input type="submit" value="Поменять">
    </p>
</form>

<br>
<table>
    <tr>
        <td><p class="lead">Ваша почта: ${user.email}</p></td>
        <td><p class="lead">Ваш id: ${user.id}</p></td>
    </tr>
    <tr>
        <td><p class="lead"><a href="/add_theory">Добавить рецепт</a></p></td>
        <td><p class="lead"><a href="/read_my_theories">Мои рецепты</a></p></td>
    </tr>
</table>
<br>
    <tr>
        <td><p class="lead"><a href="/logout">Выйти</a></p></td>
        <td><p class="lead"><a href="/deleteUser">Удалить аккаунт</a></p></td>
    </tr>
<br>

</#macro>
