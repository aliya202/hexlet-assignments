@import java.lang.String
@import exercise.dto.BasePage
@param String user

@template.layout.page(
title = "Главная страница",
page = new BasePage(),
content = @`
    @if(user == null)
        <a href="@{exercise.util.NamedRoutes.buildSessionPath()}">Войти</a>
    @else
        <p>Привет, ${user}!</p>
        <form action="@{exercise.util.NamedRoutes.logoutPath()}" method="post">
            <button type="submit">Выйти</button>
        </form>
    @endif
`
)