@import java.lang.String
@param String error

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Логин</title>
</head>
<body>
<h1>Логин</h1>
@if(error != null)
    <p style="color: red;">${error}</p>
@endif
<form action="@{exercise.util.NamedRoutes.loginPath()}" method="post">
    <div>
        <label for="name">Имя:</label>
        <input type="text" id="name" name="name" required>
    </div>
    <div>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <button type="submit">Войти</button>
</form>
</body>
</html>