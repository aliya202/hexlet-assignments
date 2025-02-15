package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SessionsController {

    // BEGIN
    public static void newForm(Context ctx) {
        ctx.render("build.jte", Collections.emptyMap());
    }

    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String password = ctx.formParam("password");

        if (name == null || password == null) {
            ctx.redirect(NamedRoutes.rootPath());
            return;
        }

        String encryptedPassword = encryptPassword(password);

        Optional<User> userOpt = UsersRepository.findByName(name);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(encryptedPassword)) {
            ctx.sessionAttribute("user", userOpt.get());
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            Map<String, Object> model = new HashMap<>();
            model.put("error", "Wrong username or password");
            ctx.render("build.jte", model);
        }
    }

    public static void delete(Context ctx) {
        ctx.req().getSession().invalidate();
        ctx.redirect(NamedRoutes.rootPath());
    }

    private static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
