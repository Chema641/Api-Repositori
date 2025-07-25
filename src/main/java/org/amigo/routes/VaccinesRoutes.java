package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.VaccinesController;

public class VaccinesRoutes {
    public static void register(Javalin app) {
        app.get("/vaccines", VaccinesController::getAll);
        app.get("/vaccines/{idPet}", VaccinesController::getById);
        app.post("/vaccines", VaccinesController::create);
        app.delete("/vaccines/{idPet}", VaccinesController::delete);
    }
}
