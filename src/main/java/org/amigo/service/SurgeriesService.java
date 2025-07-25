package org.amigo.service;

import org.amigo.model.Surgeries;
import org.amigo.repository.SurgeriesRepository;

import java.sql.SQLException;
import java.util.List;

public class SurgeriesService {
    private final SurgeriesRepository repository = new SurgeriesRepository();

    public void saveSurgeries(Surgeries surgeries) throws SQLException {
        if (surgeries.getIdPet() <= 0) {
            throw new IllegalArgumentException("El IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(surgeries);
    }

    public Surgeries findById(int idPet) throws SQLException {
        return repository.findById(idPet);
    }

    public List<Surgeries> findAll() throws SQLException {
        return repository.findAll();
    }
}
