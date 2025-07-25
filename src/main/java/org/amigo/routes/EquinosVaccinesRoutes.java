package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.EquinoVaccinesController;

public class EquinosVaccinesRoutes {
    public static void register(Javalin app) {
        app.post("/vaccines/equinos", EquinoVaccinesController::create);
        app.get("/vaccines/equinos/all", EquinoVaccinesController::getAll);
    }
}
