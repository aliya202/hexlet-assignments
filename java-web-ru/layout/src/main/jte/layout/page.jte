<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>@param title String</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <header class="bg-dark text-white py-3">
        <div class="container">
            <nav>
                <a href="/" class="text-white me-3">Home</a>
                <a href="/users" class="text-white">Users</a>
            </nav>
        </div>
    </header>

    <main class="container mt-4">
        @param content jte.Content
        @content
    </main>

    <footer class="bg-light text-center py-3 mt-4">
        <p>Created by Your Name | <a href="https://gitlab.com/your-profile" target="_blank">GitLab Profile</a></p>
    </footer>
</body>
</html>
