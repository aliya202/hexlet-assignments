@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@import io.javalin.validation.ValidationError
@param EditPostPage page
@param ValidationError<Object> error

@template.layout.page(
content = @`
    <main>
        <div class="mx-auto p-4 py-md-5">
            <h1>Редактировать пост</h1>
        </div>
        <div class="mx-auto p-4 py-md-5">
            <form method="post" action="${NamedRoutes.updatePostPath(page.getId())}">
                <div>
                    <label for="name">Название</label>
                    <input type="text" id="name" name="name" value="${page.getName()}" />
                    @if(page.getErrors() != null && page.getErrors().containsKey("name"))
                        <ul class="errors">
                            @for(ValidationError<Object> error : page.getErrors().get("name"))
                                <li>${error.getMessage()}</li>
                            @endfor
                        </ul>
                    @endif
                </div>
                <div>
                    <label for="body">Пост</label>
                    <textarea id="body" name="body">${page.getBody()}</textarea>
                    @if(page.getErrors() != null && page.getErrors().containsKey("body"))
                        <ul class="errors">
                            @for(ValidationError<Object> error : page.getErrors().get("body"))
                                <li>${error.getMessage()}</li>
                            @endfor
                        </ul>
                    @endif
                </div>
                <button type="submit">Обновить</button>
            </form>
        </div>
    </main>
`
)
