<#include 'base.ftl'>

<#macro title>
<title>Все рецепты</title>
<link rel="shortcut icon" href="static/img/pancake.jpg" type="image/png">
</#macro>

<#macro content>
<br>
<h1>Все рецепты</h1>
<br>

<#if recipes??>
    <#if recipes?has_content>
        <form action="" method="post" novalidate>
            <p class="lead" id="1" style="float: left; margin-right: 50px;">
                {{ tit.title.label }}<br>
                {{ tit.title }}<br>
            </p>

            <p class="lead" id="2" style="margin: 10px;">
                {{ aut.author.label }}<br>
                {{ aut.author }}<br>
            </p>

            <p class="lead" style="margin-right: 1000px;">{{ form.submit() }}</p>
        </form>

        <#list recipes as recipe>
            <a href="/read_recipe/{{item[0]}}">
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
