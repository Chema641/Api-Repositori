package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.BovineController;

public class BovineRoutes {
    public static void register(Javalin app) {
        app.post("/bovine", BovineController::create);
        app.get("/bovine/all", BovineController::getAll);

    }
}
