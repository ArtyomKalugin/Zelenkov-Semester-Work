<#include 'base.ftl'>

<#macro title>
    <title>Добавление рецепта</title>
    <link rel="shortcut icon" href="static/img/pancake.jpg" type="image/png">
</#macro>

<#macro content>
    <#if recipe?has_content>
        <br>
        <h1>Рецепт</h1>
        <br>
        <form action="/editRecipe?id=${recipe.id}" method="post" novalidate enctype="multipart/form-data">
            <p class="lead">
                Введите название:<br>
                <input name="title" type="text" style="width: 710px" placeholder="${recipe.title}"><br>
            </p>


            <p class="lead">
                Введите рецепт:<br>
                <label>
                    <textarea name="content" placeholder="Рецепт..." class="recipe">${recipe.text}</textarea>
                </label><br>
            </p>

            <p class="lead">
                <input name="photo" type="file"><br>
            </p>
            <br>
            <p class="lead"><input type="submit" value="Сохранить"></p>
            <br>
        </form>
    </#if>
</#macro>
