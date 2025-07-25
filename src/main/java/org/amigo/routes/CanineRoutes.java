package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.CanineController;

public class CanineRoutes {
    public static void register(Javalin app) {
        app.get("/canines", CanineController::getAll);
        app.post("/canine", CanineController::create);

    }
}
