package org.amigo.controller;

import io.javalin.http.Context;
import org.amigo.model.FelineVaccines;
import org.amigo.service.FelineVaccinesService;

import java.sql.SQLException;

public class FelineVaccinesController {

    private static final FelineVaccinesService service = new FelineVaccinesService();

    public static void create(Context ctx) {
        try {
            FelineVaccines felineVaccines = ctx.bodyAsClass(FelineVaccines.class);
            service.save(felineVaccines);
            ctx.status(201).result("Vacunas felinas registradas con éxito");
        } catch (IllegalArgumentException e) {
            ctx.status(400).result("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getAll(Context ctx) {
        try {
            ctx.json(service.findAll());
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }
}
