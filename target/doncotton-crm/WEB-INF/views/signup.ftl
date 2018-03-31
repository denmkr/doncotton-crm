<#ftl encoding="utf-8">
<#setting locale="ru_RU">

<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>


<!-- Main panel -->
<div class="main sign">
    <div class="header-container"></div>
    <div class="sign_container">
        <div class="inside">
            <div class="buttons">
                <@security.authorize access="isAnonymous()">
                    <a href="/signin">
                        <div class="button login">
                            <i class="mdi mdi-account-box"></i>
                            <span>Войти</span>
                        </div>
                    </a>
                </@security.authorize>
                <a>
                <div class="button register active">
                    <i class="mdi mdi-account-multiple-plus"></i>
                    <span>Зарегистрироваться</span>
                </div>
                </a>
            </div>
            <div class="signup">
            <@form.form commandName="signup_form" action="/signup" acceptCharset="UTF-8"  method="post">
                <div class="title">Регистрация</div>
                <div class="inputs">

                        <@form.input class="input__field input__field--chisato" type="text" id="input-13" name="name" path="name" placeholder="Иванов Иван Иванович" />

                        <@form.input class="input__field input__field--chisato" type="text" id="input-13" name="email" path="email" value="" placeholder="otrajenie@email.com" />

                        <@form.input class="input__field input__field--chisato" type="text" id="input-13" name="phone" path="phone" value="" placeholder="+7 (917) 12 23 45" />

                        <@form.input class="input__field input__field--chisato" type="text" name="position" path="position" placeholder="Должность" id="input-13" />

                        <@form.input class="input__field input__field--chisato" type="password" name="password" path="password" placeholder="Минимум 6 символов" id="input-13" />

                        <@form.input class="input__field input__field--chisato" type="password" name="confirmPassword" path="confirmPassword" id="input-13" />


                    <div class="button" onclick="document.getElementById('signup_form').submit();">Зарегистрироваться</div>

                </div>
            </@form.form>
            </div>
        </div>
    </div>
</div>


