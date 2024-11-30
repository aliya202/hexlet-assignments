package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_PER_PAGE = 5;

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", App::handleGetUsers);
        // END

        return app;

    }

    private static void handleGetUsers(Context ctx) {
        int page = parseQueryParam(ctx.queryParam("page"), DEFAULT_PAGE);
        int perPage = parseQueryParam(ctx.queryParam("per"), DEFAULT_PER_PAGE);

        List<Map<String, String>> paginatedUsers = paginate(USERS, page, perPage);

        ctx.json(paginatedUsers);
    }

    private static int parseQueryParam(String param, int defaultValue) {
        if (param == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private static List<Map<String, String>> paginate(List<Map<String, String>> users, int page, int perPage) {
        int fromIndex = (page - 1) * perPage;
        int toIndex = Math.min(fromIndex + perPage, users.size());

        if (fromIndex >= users.size() || fromIndex < 0) {
            return List.of();
        }

        return users.subList(fromIndex, toIndex);
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
