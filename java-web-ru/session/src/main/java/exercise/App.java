package exercise;

import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;

import java.util.HashMap;
import java.util.Map;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), ctx -> {
            Map<String, Object> model = new HashMap<>();
            model.put("user", ctx.sessionAttribute("user"));
            ctx.render("index.jte", model);
        });
        app.get(NamedRoutes.buildSessionPath(), SessionsController::newForm);
        app.post(NamedRoutes.loginPath(), SessionsController::create);
        app.post(NamedRoutes.logoutPath(), SessionsController::delete);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
