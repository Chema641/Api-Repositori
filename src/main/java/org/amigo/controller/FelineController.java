package org.amigo.controller;

import io.javalin.http.Context;
import com.google.gson.Gson;
import org.amigo.model.Feline;
import org.amigo.service.FelineService;

public class FelineController {
    private static final Gson gson = new Gson();
    private static final FelineService service = new FelineService();

    public static void create(Context ctx) {
        try {
            Feline feline = gson.fromJson(ctx.body(), Feline.class);
            service.saveFeline(feline);
            ctx.status(201).result("Cirugías de felinos guardadas correctamente");
        } catch (Exception e) {
            ctx.status(400).result("Error: " + e.getMessage());
        }
    }

    public static void getAll(Context ctx) {
        try {
            ctx.json(service.getAllFelines());
        } catch (Exception e) {
            ctx.status(500).result("Error: " + e.getMessage());
        }
    }

    public static void getByPetId(Context ctx) {
        try {
            int idPet = Integer.parseInt(ctx.pathParam("idPet"));
            Feline feline = service.getFelineByPetId(idPet);
            if (feline != null) {
                ctx.json(feline);
            } else {
                ctx.status(404).result("No feline surgery record found for IdPet " + idPet);
            }
        } catch (Exception e) {
            ctx.status(400).result("Error: " + e.getMessage());
        }
    }
}
