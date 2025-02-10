package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PostsController {

    // BEGIN
    public static void list(Context ctx) {
        int page = 1;
        String pageParam = ctx.queryParam("page");
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        List<Post> posts = PostRepository.findAll(page, 5);
        PostsPage postsPage = new PostsPage(posts, page);
        ctx.render("posts/index.jte", Map.of("postsPage", postsPage));
    }

    public static void show(Context ctx) {
        Long id;
        try {
            id = Long.valueOf(ctx.pathParam("id"));
        } catch (NumberFormatException e) {
            ctx.status(404).result("Page not found");
            return;
        }
        Optional<Post> postOptional = PostRepository.find(id);
        if (postOptional.isEmpty()) {
            ctx.status(404).result("Page not found");
            return;
        }
        Post post = postOptional.get();
        PostPage postPage = new PostPage(post);
        ctx.render("posts/show.jte", Map.of("page", postPage));
    }
    // END
}
