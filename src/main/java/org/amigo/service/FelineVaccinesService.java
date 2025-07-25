package org.amigo.service;

import org.amigo.model.FelineVaccines;
import org.amigo.repository.FelineVaccinesRepository;

import java.sql.SQLException;
import java.util.List;

public class FelineVaccinesService {

    private final FelineVaccinesRepository repository = new FelineVaccinesRepository();

    public void save(FelineVaccines felineVaccines) throws SQLException {
        if (felineVaccines.getIdPet() <= 0) {
            throw new IllegalArgumentException("El IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(felineVaccines);
    }

    public List<FelineVaccines> findAll() throws SQLException {
        return repository.findAll();
    }
}
