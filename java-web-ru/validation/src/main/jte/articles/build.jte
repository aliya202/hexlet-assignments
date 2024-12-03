@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>Создание новой статьи</h1>
                <form method="POST" action="/articles">
                    <div class="mb-3">
                        <label for="title" class="form-label">Название</label>
                        <input type="text" id="title" name="title" class="form-control"
                               value="${page.getTitle() != null ? page.getTitle() : ""}">
                        <div class="text-danger">
                            ${page.getErrors().containsKey("title") ? page.getErrors().get("title").getMessage() : ""}
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="content" class="form-label">Содержимое</label>
                        <textarea id="content" name="content" class="form-control">${page.getContent() != null ? page.getContent() : ""}</textarea>
                        <div class="text-danger">
                            ${page.getErrors().containsKey("content") ? page.getErrors().get("content").getMessage() : ""}
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </main>
        </div>
    `
)
