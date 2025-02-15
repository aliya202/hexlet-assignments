package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Collections;
import java.util.Optional;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        String token = Security.generateToken();

        User user = new User(firstName, lastName, email, password, token);

        UserRepository.save(user);

        ctx.cookie("token", token);

        ctx.redirect("/users/" + user.getId());
    }

    public static void show(Context ctx) {
        Long id = Long.valueOf(ctx.pathParam("id"));

        Optional<User> userOptional = UserRepository.find(id);
        if (userOptional.isEmpty()) {
            ctx.redirect("/users/build");
            return;
        }
        User user = userOptional.get();

        String cookieToken = ctx.cookie("token");

        if (cookieToken == null || !cookieToken.equals(user.getToken())) {
            ctx.redirect("/users/build");
            return;
        }
        var page = new exercise.dto.users.UserPage(user);
        ctx.render("users/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
