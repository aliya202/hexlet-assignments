@import exercise.dto.posts.PostPage
@import exercise.dto.BasePage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
title = page.getPost().getName(),
page = new BasePage(),
content = @`
    <div class="mb-3">
        <h1>${page.getPost().getName()}</h1>
    </div>
    <div class="mb-3">
        ${page.getPost().getBody()}
    </div>
`
)