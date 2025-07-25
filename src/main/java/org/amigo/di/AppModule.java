package org.amigo.di;

import io.javalin.Javalin;
import org.amigo.controller.OwnerController;
import org.amigo.controller.VeterinaryController;
import org.amigo.controller.UserController;
import org.amigo.repository.UserRepository;
import org.amigo.routes.UserRoutes;
import org.amigo.service.UserService;
import org.amigo.controller.PetController;
import org.amigo.controller.EquinosController;
import org.amigo.controller.CanineController;
import org.amigo.controller.EstablishmentController;
import org.amigo.controller.FelineController;
import org.amigo.controller.SurgeriesController;
import org.amigo.controller.BovineController;
import org.amigo.controller.VaccinesController;
import org.amigo.controller.CanineVaccinesController;
import org.amigo.controller.FelineVaccinesController;


public class AppModule {

    public static UserRoutes initUser() {
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);
        UserController userController = new UserController(userService);
        return new UserRoutes(userController);
    }

    public static void VeterinaryController(Javalin app) {
        app.post("/veterinary", VeterinaryController::createVeterinary);
        app.get("/veterinary/all", VeterinaryController::getAllVeterinaries);

        app.post("/owners", OwnerController::createOwner);
        app.get("/owner/all", OwnerController::getAllOwners);
    }

    public static void PetRoutes(Javalin app) {
        app.post("/pets", PetController::createPet);
        app.get("/pets/all", PetController::getAllPets);
    }

    public static void EstablishmentController(Javalin app) {
        app.post("/establishments", org.amigo.controller.EstablishmentController::createEstablishment);
        app.get("/establishment/all", org.amigo.controller.EstablishmentController::getAllEstablishments);
    }


    public static void initSurgeries(Javalin app) {
        app.post("/surgeries", org.amigo.controller.SurgeriesController::create);
        app.get("/surgeries/{idPet}", org.amigo.controller.SurgeriesController::getById);
        app.get("/surgeries/all", org.amigo.controller.SurgeriesController::getAll);
    }

    public static void BovineController(Javalin app) {
        app.post("/bovine", org.amigo.controller.BovineController::create);
        app.get("/bovine/all", org.amigo.controller.BovineController::getAll);
        app.get("/bovine/pet/{idPet}", org.amigo.controller.BovineController::getByPetId);
        app.get("/bovine/{idPet}/{vaca}", org.amigo.controller.BovineController::getById);
    }

    public static void EquinosController(Javalin app) {
        app.post("/equinos", EquinosController::create);
        app.get("/equinos/all", EquinosController::getAll);
    }

    public static void initCanine(Javalin app) {
        app.post("/canine", org.amigo.controller.CanineController::create);
        app.get("/canines", org.amigo.controller.CanineController::getAll);
    }

    public static void FelineRoutes(Javalin app) {
        org.amigo.routes.FelineRoutes.register(app);
    }


    public static void VaccinesRoutes(Javalin app) {
        org.amigo.routes.VaccinesRoutes.register(app);
    }

    public static void CanineVaccinesRoutes(Javalin app) {
        app.post("/vaccines/canines", CanineVaccinesController::create);
        app.get("/vaccines/canine/all", CanineVaccinesController::getAll);
        app.get("/vaccines/canine/{idPet}", CanineVaccinesController::getByPetId);
    }

    public static void FelineVaccinesRoutes(Javalin app) {
        org.amigo.routes.FelineVaccinesRoutes.register(app);
    }

    public static void EquinosVaccinesRoutes(Javalin app) {
        org.amigo.routes.EquinosVaccinesRoutes.register(app);
    }

    public static void BovineVaccinesRoutes(Javalin app) {
        org.amigo.routes.BovineVaccinesRoutes.register(app);
    }
}
