package org.amigo;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import org.amigo.di.AppModule;
import org.amigo.routes.VeterinaryRoutes;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(CorsPluginConfig.CorsRule::anyHost);
            });
        }).start(7000);

        // Rutas generales
        app.get("/", ctx -> ctx.result("MediAmigo"));
        AppModule.initUser().register(app);
        AppModule.VeterinaryController(app);
        AppModule.PetRoutes(app);
        AppModule.EstablishmentController(app);
        AppModule.initSurgeries(app);
        AppModule.BovineController(app);
        AppModule.EquinosController(app);
        AppModule.FelineRoutes(app);
        AppModule.initCanine(app);
        AppModule.VaccinesRoutes(app);
        VeterinaryRoutes.register(app);
        AppModule.CanineVaccinesRoutes(app);
        AppModule.FelineVaccinesRoutes(app);
        AppModule.EquinosVaccinesRoutes(app);
        AppModule.BovineVaccinesRoutes(app);
    }
}
