package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.FelineVaccinesController;

public class FelineVaccinesRoutes {
    public static void register(Javalin app) {
        app.post("/vaccines/felines", FelineVaccinesController::create);
        app.get("/vaccines/felines/all", FelineVaccinesController::getAll);
    }
}
