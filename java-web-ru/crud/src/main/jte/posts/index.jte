@import exercise.dto.posts.PostsPage
@param PostsPage postsPage
<html>
  <head>
    <meta charset="UTF-8">
    <title>Posts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container mt-4">
      <h1>Posts</h1>
      <ul class="list-group">
        @for(exercise.model.Post post : postsPage.getPosts())
          <li class="list-group-item">
            <a href="@{exercise.util.NamedRoutes.postPath(post.getId())}">
              ${post.getName()}
            </a>
          </li>
        @endfor
      </ul>

      <nav aria-label="Page navigation" class="mt-3">
        <ul class="pagination">
          <li class="page-item">
            <a class="page-link" href="${exercise.util.NamedRoutes.postsPath()}?page=${postsPage.getCurrentPage() == 1 ? 1 : postsPage.getCurrentPage() - 1}">
              Previous
            </a>
          </li>
          <li class="page-item">
            <a class="page-link" href="${exercise.util.NamedRoutes.postsPath()}?page=${postsPage.getCurrentPage() + 1}">
              Next
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </body>
</html>
