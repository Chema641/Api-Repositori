package org.amigo.controller;

import com.google.gson.Gson;
import io.javalin.http.Context;
import org.amigo.model.CanineVaccines;
import org.amigo.service.CanineVaccinesService;

import java.sql.SQLException;

public class CanineVaccinesController {
    private static final Gson gson = new Gson();
    private static final CanineVaccinesService service = new CanineVaccinesService();

    public static void create(Context ctx) {
        try {
            CanineVaccines cv = gson.fromJson(ctx.body(), CanineVaccines.class);
            service.saveCanineVaccines(cv);
            ctx.status(201).result("Vacunas caninas guardadas con éxito");
        } catch (IllegalArgumentException e) {
            ctx.status(400).result("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getAll(Context ctx) {
        try {
            ctx.json(service.getAll());
        } catch (SQLException e) {
            ctx.status(500).result("Error al obtener datos: " + e.getMessage());
        }
    }

    public static void getByPetId(Context ctx) {
        try {
            int idPet = Integer.parseInt(ctx.pathParam("idPet"));
            CanineVaccines cv = service.getByPetId(idPet);
            if (cv != null) {
                ctx.json(cv);
            } else {
                ctx.status(404).result("No se encontraron vacunas para el IdPet: " + idPet);
            }
        } catch (Exception e) {
            ctx.status(500).result("Error al obtener vacuna: " + e.getMessage());
        }
    }
}
