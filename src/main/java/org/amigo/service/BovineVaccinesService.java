package org.amigo.service;

import org.amigo.model.BovineVaccines;
import org.amigo.repository.BovineVaccinesRepository;
import java.sql.SQLException;
import java.util.List;

public class BovineVaccinesService {

    private final BovineVaccinesRepository repository = new BovineVaccinesRepository();

    public void save(BovineVaccines bovineVaccines) throws SQLException {
        if (bovineVaccines.getIdPet() <= 0) {
            throw new IllegalArgumentException("El IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(bovineVaccines);
    }

    public List<BovineVaccines> findAll() throws SQLException {
        return repository.findAll();
    }
}
