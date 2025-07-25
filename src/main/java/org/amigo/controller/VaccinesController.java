package org.amigo.controller;

import io.javalin.http.Context;
import org.amigo.model.Vaccines;
import org.amigo.service.VaccinesService;

import java.sql.SQLException;

public class VaccinesController {

    private static final VaccinesService service = new VaccinesService();

    public static void getAll(Context ctx) {
        try {
            ctx.json(service.findAll());
        } catch (SQLException e) {
            ctx.status(500).result("Error al obtener las vacunas: " + e.getMessage());
        }
    }

    public static void getById(Context ctx) {
        try {
            int idPet = Integer.parseInt(ctx.pathParam("idPet"));
            Vaccines vaccine = service.findById(idPet);
            if (vaccine != null) {
                ctx.json(vaccine);
            } else {
                ctx.status(404).result("Vacuna no encontrada para IdPet: " + idPet);
            }
        } catch (Exception e) {
            ctx.status(400).result("Error: " + e.getMessage());
        }
    }

    public static void create(Context ctx) {
        try {
            Vaccines vaccine = ctx.bodyAsClass(Vaccines.class);
            service.save(vaccine);
            ctx.status(201).result("Vacunas creada con éxito");
        } catch (Exception e) {
            ctx.status(400).result("Error al crear vacuna: " + e.getMessage());
        }
    }

    public static void delete(Context ctx) {
        try {
            int idPet = Integer.parseInt(ctx.pathParam("idPet"));
            service.delete(idPet);
            ctx.status(200).result("Vacuna eliminada con éxito");
        } catch (Exception e) {
            ctx.status(400).result("Error al eliminar vacuna: " + e.getMessage());
        }
    }
}
