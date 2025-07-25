package org.amigo.controller;

import com.google.gson.Gson;
import io.javalin.http.Context;
import org.amigo.model.Pet;
import org.amigo.service.PetService;

import java.sql.SQLException;
import java.util.List;

public class PetController {
    private static final Gson gson = new Gson();
    private static final PetService service = new PetService();

    public static void createPet(Context ctx) {
        try {
            Pet pet = gson.fromJson(ctx.body(), Pet.class);
            service.savePet(pet);
            ctx.status(201).result("Pet guardado correctamente");
        } catch (IllegalArgumentException e) {
            ctx.status(400).result("Error de validación: " + e.getMessage());
        } catch (SQLException e) {
            ctx.status(500).result("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void getAllPets(Context ctx) {
        try {
            List<Pet> pets = service.getAllPets();
            ctx.json(pets);
        } catch (SQLException e) {
            ctx.status(500).result("Error recuperando mascotas: " + e.getMessage());
        }
    }
}
