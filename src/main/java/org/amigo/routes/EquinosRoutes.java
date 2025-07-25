package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.EquinosController;

public class EquinosRoutes {
    public static void register(Javalin app) {
        app.post("/equinos", EquinosController::create);
        app.get("/equinos/all", EquinosController::getAll);
    }
}
