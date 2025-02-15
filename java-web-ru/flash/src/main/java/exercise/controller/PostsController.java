package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String body = ctx.formParam("body");

        if (name == null || name.trim().length() < 2) {
            ctx.sessionAttribute("flash", "Title is too short");
            ctx.sessionAttribute("flashType", "danger");
            ctx.redirect("/posts/build");
            return;
        }
        Post post = new Post(name, body);
        PostRepository.save(post);
        ctx.sessionAttribute("flash", "Post was successfully created!");
        ctx.sessionAttribute("flashType", "success");
        ctx.redirect("/posts");
    }

    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        String flash = ctx.sessionAttribute("flash");
        String flashType = ctx.sessionAttribute("flashType");

        ctx.sessionAttribute("flash", null);
        ctx.sessionAttribute("flashType", null);
        var page = new PostsPage(posts, flash, flashType);
        ctx.render("posts/index.jte", model("page", page));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
