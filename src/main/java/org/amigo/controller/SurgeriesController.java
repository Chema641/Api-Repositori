package org.amigo.controller;

import com.google.gson.Gson;
import io.javalin.http.Context;
import org.amigo.model.Surgeries;
import org.amigo.service.SurgeriesService;

import java.sql.SQLException;

public class SurgeriesController {
    private static final Gson gson = new Gson();
    private static final SurgeriesService service = new SurgeriesService();

    public static void create(Context ctx) {
        try {
            Surgeries surgeries = gson.fromJson(ctx.body(), Surgeries.class);
            service.saveSurgeries(surgeries);
            ctx.status(201).result("Registro de cirugías guardado correctamente");
        } catch (IllegalArgumentException e) {
            ctx.status(400).result("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getById(Context ctx) {
        try {
            int idPet = Integer.parseInt(ctx.pathParam("idPet"));
            Surgeries surgeries = service.findById(idPet);
            if (surgeries == null) {
                ctx.status(404).result("No se encontró registro para este IdPet");
            } else {
                ctx.json(surgeries);
            }
        } catch (NumberFormatException e) {
            ctx.status(400).result("IdPet inválido");
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getAll(Context ctx) {
        try {
            ctx.json(service.findAll());
        } catch (SQLException e) {
            ctx.status(500).result("Error al recuperar datos: " + e.getMessage());
        }
    }
}
