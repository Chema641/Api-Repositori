package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.BovineVaccinesController;

public class BovineVaccinesRoutes {
    public static void register(Javalin app) {
        app.post("/vaccines/bovines", BovineVaccinesController::create);
        app.get("/vaccines/bovines/all", BovineVaccinesController::getAll);
    }
}
