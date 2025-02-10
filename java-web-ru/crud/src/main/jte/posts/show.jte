@import exercise.dto.posts.PostPage
@param PostPage page
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Post Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container mt-4">
      <h1>${page.getPost().getName()}</h1>
      <p>${page.getPost().getBody()}</p>
      <a href="@{exercise.util.NamedRoutes.postsPath()}" class="btn btn-secondary">Back to posts list</a>
    </div>
  </body>
</html>
