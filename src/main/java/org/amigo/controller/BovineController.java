package org.amigo.controller;

import com.google.gson.Gson;
import io.javalin.http.Context;
import org.amigo.model.Bovine;
import org.amigo.service.BovineService;

import java.sql.SQLException;
import java.util.List;

public class BovineController {
    private static final Gson gson = new Gson();
    private static final BovineService service = new BovineService();

    public static void create(Context ctx) {
        try {
            Bovine bovine = gson.fromJson(ctx.body(), Bovine.class);
            service.save(bovine);
            ctx.status(201).result("Registro bovino guardado.");
        } catch (IllegalArgumentException e) {
            ctx.status(400).result("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getById(Context ctx) {
        try {
            int idPet = Integer.parseInt(ctx.pathParam("idPet"));
            String vaca = ctx.pathParam("vaca");
            Bovine bovine = service.getById(idPet, vaca);
            if (bovine == null) {
                ctx.status(404).result("No encontrado.");
            } else {
                ctx.json(bovine);
            }
        } catch (NumberFormatException e) {
            ctx.status(400).result("IdPet inválido.");
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getByPetId(Context ctx) {
        try {
            int idPet = Integer.parseInt(ctx.pathParam("idPet"));
            List<Bovine> list = service.getByPetId(idPet);
            ctx.json(list);
        } catch (NumberFormatException e) {
            ctx.status(400).result("IdPet inválido.");
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getAll(Context ctx) {
        try {
            ctx.json(service.getAll());
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }
}
