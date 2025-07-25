package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.FelineController;

public class FelineRoutes {
    public static void register(Javalin app) {
        app.post("/feline", FelineController::create);
        app.get("/feline/all", FelineController::getAll);
        app.get("/feline/{idPet}", FelineController::getByPetId);
    }
}
