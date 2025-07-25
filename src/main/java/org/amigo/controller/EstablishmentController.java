package org.amigo.controller;

import com.google.gson.Gson;
import io.javalin.http.Context;
import org.amigo.model.Establishment;
import org.amigo.service.EstablishmentService;

import java.sql.SQLException;

public class EstablishmentController {
    private static final Gson gson = new Gson();
    private static final EstablishmentService service = new EstablishmentService();

    public static void createEstablishment(Context ctx) {
        try {
            Establishment establishment = gson.fromJson(ctx.body(), Establishment.class);
            if (establishment.getNombre() == null || establishment.getDescripcion() == null || establishment.getDireccion() == null) {
                ctx.status(400).result("Todos los campos son obligatorios: name, description, directory");
                return;
            }
            service.save(establishment);
            ctx.status(201).result("Establecimiento creado correctamente");
        } catch (SQLException e) {
            ctx.status(500).result("Error al guardar establecimiento: " + e.getMessage());
        } catch (Exception e) {
            ctx.status(500).result("Error inesperado: " + e.getMessage());
        }
    }

    public static void getAllEstablishments(Context ctx) {
        try {
            ctx.json(service.getAll());
        } catch (SQLException e) {
            ctx.status(500).result("Error al obtener establecimientos: " + e.getMessage());
        }
    }
}
