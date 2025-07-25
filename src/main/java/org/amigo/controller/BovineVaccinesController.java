package org.amigo.controller;

import io.javalin.http.Context;
import org.amigo.model.BovineVaccines;
import org.amigo.service.BovineVaccinesService;
import java.sql.SQLException;


public class BovineVaccinesController {

    private static final BovineVaccinesService service = new BovineVaccinesService();

    public static void create(Context ctx) {
        try{
            BovineVaccines bovineVaccines = ctx.bodyAsClass(BovineVaccines.class);
            service.save(bovineVaccines);
            ctx.status(201).result("Vacunas bovinas registradas con éxito");
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