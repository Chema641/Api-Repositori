package org.amigo.controller;

import io.javalin.http.Context;
import com.google.gson.Gson;
import org.amigo.model.Canine;
import org.amigo.service.CanineService;

import java.util.List;

public class CanineController {
    private static final Gson gson = new Gson();
    private static final CanineService service = new CanineService();

    public static void create(Context ctx) {
        Canine Canine = gson.fromJson(ctx.body(), Canine.class);
        service.saveCanine(Canine);
        ctx.status(201).result("Cirugías canina registrada correctamente");
    }

    public static void getAll(Context ctx) {
        List<Canine> list = service.getAllCanines();
        ctx.json(list);
    }
}

