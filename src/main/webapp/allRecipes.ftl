<#include 'base.ftl'>

<#macro title>
<title>Все рецепты</title>
<link rel="shortcut icon" href="static/img/pancake.jpg" type="image/png">
</#macro>

<#macro content>
<br>
<h1>Все рецепты</h1>
<br>

    <form action="/allRecipes" method="post" novalidate>
        <p class="lead" id="1" style="float: left; margin-right: 50px;">
            Поиск по названию:<br>
            <input name="title" type="text"><br>
        </p>

        <br>
        <p class="lead" style="margin-right: 1000px;">
            <input type="submit" value="Найти">
        </p>
    </form>

    <br>

    <#if recipes??>
        <#if recipes?has_content>
            <#list recipes as recipe>
                <a href="/detailRecipe?id=${recipe.id}">
                    <div class="alert alert-dark" role="alert">
                        <h2>${recipe.title}</h2>
                        <div>${recipe.text}</div>
                        <br>
                        <img src="${recipe.photo}" width="665" height="350">
                        <br>
                        <br>
                        <div><small class="text-muted">${recipe.userNickname} ${recipe.data}</small></div>
                        <div><small class="text-muted">Рецепт ${recipe.id}</small></div>
                    </div>
                </a>
            </#list>

        <#else>
            <p class="lead">Нет рецептов!</p>
        </#if>
    </#if>

</#macro>
