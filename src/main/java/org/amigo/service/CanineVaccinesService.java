package org.amigo.service;

import org.amigo.model.CanineVaccines;
import org.amigo.repository.CanineVaccinesRepository;

import java.sql.SQLException;
import java.util.List;

public class CanineVaccinesService {
    private final CanineVaccinesRepository repository = new CanineVaccinesRepository();

    public void saveCanineVaccines(CanineVaccines cv) throws SQLException {
        if (cv.getIdPet() <= 0) {
            throw new IllegalArgumentException("El IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(cv);
    }

    public List<CanineVaccines> getAll() throws SQLException {
        return repository.findAll();
    }

    public CanineVaccines getByPetId(int idPet) throws SQLException {
        return repository.findByPetId(idPet);
    }
}
