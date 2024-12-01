@template layout.page
@params String title, List<exercise.model.User> users

<h1 class="mb-4">List of Users</h1>
<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        @for (User user : users) {
            <tr>
                <td>@user.getId()</td>
                <td>@user.getFirstName()</td>
                <td>@user.getLastName()</td>
                <td>@user.getEmail()</td>
            </tr>
        }
    </tbody>
</table>
