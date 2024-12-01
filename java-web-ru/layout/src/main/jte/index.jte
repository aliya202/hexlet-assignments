@template layout.page
@params String title, exercise.model.User user

<h1 class="mb-4">User Details</h1>
<ul class="list-group">
    <li class="list-group-item"><strong>ID:</strong> @user.getId()</li>
    <li class="list-group-item"><strong>First Name:</strong> @user.getFirstName()</li>
    <li class="list-group-item"><strong>Last Name:</strong> @user.getLastName()</li>
    <li class="list-group-item"><strong>Email:</strong> @user.getEmail()</li>
</ul>
<a href="/users" class="btn btn-primary mt-3">Back to Users</a>
