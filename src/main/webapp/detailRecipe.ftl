<#include 'base.ftl'>

<#macro title>
<title>Рецепт</title>
<link rel="shortcut icon" href="static/img/pancake.jpg" type="image/png">
</#macro>

<#macro content>
<br>
<#if u??>
    <p class="lead"><a href="/myRecipes">Назад</a></p>
<#else>
    <p class="lead"><a href="/allRecipes">Назад</a></p>
</#if>
<br>

<#if recipe?has_content>
    <h1>${recipe.title}</h1>
    <br>
    <div>${recipe.text}</div>
    <br>
    <img src="${recipe.photo}" width="709" height="350">
    <br>
    <br>
    <div>
        <table>
            <tr>
                <td><img alt="user_img" src="${author.avatar}" width="50" height="50" class="rounded-circle"></td>

                <td><strong style="font-size:20px"><a href="/detailUser?id=${author.id}">${recipe.userNickname}</a></strong></td>
                <td><small class="text-muted" style="font-size:17px"><em>${recipe.data}</em></small></td>
                <td><small class="text-muted" style="font-size:17px">Рецепт ${recipe.id}</small></td>
            </tr>
        </table>
    </div>

    <br>
<#else>
    <p class="lead">Что-то пошло не так...</p>
</#if>

</#macro>