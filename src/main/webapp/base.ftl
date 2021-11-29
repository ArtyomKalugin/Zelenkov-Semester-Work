<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <@title></@title>
    <link rel="stylesheet" href="css/mainStyles.css">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="/info"><img alt="food_img" src="/static/img/pancake.jpg" width="50" height="50" class="rounded-circle" style=""></a>

    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="/info">Об этом сайте</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/allRecipes">Рецепты</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/allUsers">Пользователи</a>
        </li>
    </ul>

    <#if user?has_content>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <img alt="user_img" src="${user.avatar}" width="50" height="50" class="rounded-circle" style="">
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/cabinet"><strong>${user.nickname}</strong></a>
            </li>
        </ul>
    <#else>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="/signIn">Войти</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Регистрация</a>
            </li>
        </ul>
    </#if>

</nav>

<div class="mainer">
    <main role="main" class="container">
        <@content></@content>
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
