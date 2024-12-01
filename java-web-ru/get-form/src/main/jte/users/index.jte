@import exercise.dto.users.UsersPage
@param UsersPage usersPage
@param String term

<div class="container">
    <form method="get" action="/users" class="mb-3">
        <div class="input-group">
            <input type="text" name="term" value="${term}" class="form-control" placeholder="Поиск по имени">
            <button class="btn btn-primary" type="submit">Искать</button>
        </div>
    </form>

    <ul class="list-group">
        @if (usersPage.getUsers().isEmpty())
            <li class="list-group-item">Совпадений не найдено</li>
        @else
            @for (var user : usersPage.getUsers())
                <li class="list-group-item">
                    <strong>${user.getFirstName()}</strong> ${user.getLastName()} - ${user.getEmail()}
                </li>
            @end
        @end
    </ul>
</div>