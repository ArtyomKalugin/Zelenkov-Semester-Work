<#include 'base.ftl'>

<#macro title>
    <title>Все рецепты</title>
    <link rel="shortcut icon" href="static/img/pancake.jpg" type="image/png">
</#macro>

<#macro content>
    <br>
    <h1>Все пользователи</h1>
    <br>

    <#if users??>
        <#if users?has_content>
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

            <#list users as user>
                <a href="/user/{{item[0]}}">
                    <div class="alert alert-dark" role="alert">
                        <table>
                            <tr>
                                <td><img alt="user_img" src="${user.avatar}" width="50" height="50" class="rounded-circle"></td>
                                <td>
                                    <h3>
                                        <strong>${user.nickname}</strong>
                                    </h3>
                                </td>
                            </tr>
                        </table>
                    </div>
                </a>
            </#list>

        <#else>
            <p class="lead">Нет пользователей!</p>
        </#if>
    </#if>

</#macro>
