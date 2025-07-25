package org.amigo.controller;

import io.javalin.http.Context;
import com.google.gson.Gson;
import org.amigo.model.Veterinary;
import org.amigo.service.VeterinaryService;

import java.sql.SQLException;

public class VeterinaryController {
    private static final Gson gson = new Gson();
    private static final VeterinaryService service = new VeterinaryService();

    public static void getAllVeterinaries(Context ctx) {
        try {
            ctx.json(service.getAllVeterinaries());
        } catch (SQLException e) {
            ctx.status(500).result("Error al obtener los veterinarios: " + e.getMessage());
        }
    }

    public static void createVeterinary(Context ctx) {
        try {
            Veterinary vet = gson.fromJson(ctx.body(), Veterinary.class);
            service.saveVeterinary(vet);
            ctx.status(201).result("Veterinario registrado con exito");
        } catch (SQLException e) {
            ctx.status(500).result( "error al guardar al veterinario" + e.getMessage());}
    }
}