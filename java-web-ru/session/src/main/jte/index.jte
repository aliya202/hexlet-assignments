@import exercise.model.User
@param User user

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
@if(user == null)
    <a href="@{exercise.util.NamedRoutes.buildSessionPath()}">Войти</a>
@else
    <p>Привет, ${user.getName()}!</p>
    <form action="@{exercise.util.NamedRoutes.logoutPath()}" method="post">
        <button type="submit">Выйти</button>
    </form>
@endif
</body>
</html>