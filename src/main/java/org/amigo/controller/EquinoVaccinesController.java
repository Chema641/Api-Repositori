package org.amigo.controller;

import io.javalin.http.Context;
import org.amigo.model.EquinosVaccines;
import org.amigo.service.EquinoVaccinesService;
import java.sql.SQLException;



public class EquinoVaccinesController {

    private static final EquinoVaccinesService service = new EquinoVaccinesService();

    public static void create(Context ctx) {
        try{
            EquinosVaccines equinosVaccines = ctx.bodyAsClass(EquinosVaccines.class);
            service.save(equinosVaccines);
            ctx.status(201).result("Vacunas equinas registradas con éxito");
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
