package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.CanineVaccinesController;

public class CanineVaccinesRoutes {
    public void register(Javalin app) {
        app.post("/vaccines/canines", CanineVaccinesController::create);
        app.get("/vaccines/canine/all", CanineVaccinesController::getAll);
        app.get("/vaccines/canine/{idPet}", CanineVaccinesController::getByPetId);
    }
}
