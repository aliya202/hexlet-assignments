@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
title = "Posts",
page = page,
content = @`
    <div class="row">
        <div class="col">
            <h1>Posts</h1>
            <ul class="list-group">
                @for(exercise.model.Post post : page.getPosts())
                    <li class="list-group-item">
                        <a href="/posts/${post.getId()}">${post.getName()}</a>
                    </li>
                @endfor
            </ul>
        </div>
    </div>
`
)