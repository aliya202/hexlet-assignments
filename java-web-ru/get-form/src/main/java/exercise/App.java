package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Objects;

import exercise.model.User;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            String term = Objects.requireNonNull(ctx.queryParam("term")).toLowerCase();

            List<User> filteredUsers = USERS.stream()
                    .filter(user -> StringUtils.startsWithIgnoreCase(user.getFirstName(), term))
                    .toList();

            UsersPage usersPage = new UsersPage(filteredUsers);

            ctx.render("users/index.jte", model("usersPage", usersPage, "term", term));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}