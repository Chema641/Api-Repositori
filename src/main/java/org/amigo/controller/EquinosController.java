package org.amigo.controller;

import com.google.gson.Gson;
import io.javalin.http.Context;
import org.amigo.model.Equinos;
import org.amigo.service.EquinosService;

import java.util.List;

public class EquinosController {
    private static final Gson gson = new Gson();
    private static final EquinosService service = new EquinosService();

    public static void create(Context ctx) {
        Equinos equinos = gson.fromJson(ctx.body(), Equinos.class);
        service.saveEquinos(equinos);
        ctx.status(201).result("Cirugía de equinos creada");
    }

    public static void getAll(Context ctx) {
        List<Equinos> list = service.getAllEquinos();
        ctx.json(list);
    }
}
