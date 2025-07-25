package org.amigo.routes;

import io.javalin.Javalin;
import org.amigo.controller.SurgeriesController;

public class SurgeriesRoutes {
    public static void register(Javalin app) {
        app.post("/surgeries", SurgeriesController::create);
        app.get("/surgeries/{idPet}", SurgeriesController::getById);
        app.get("/surgeries/all", SurgeriesController::getAll);
    }
}
