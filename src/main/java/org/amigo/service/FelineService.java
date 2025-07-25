package org.amigo.service;

import org.amigo.model.Feline;
import org.amigo.repository.FelineRepository;
import java.sql.SQLException;
import java.util.List;

public class FelineService {
    private final FelineRepository repository = new FelineRepository();

    public void saveFeline(Feline feline) throws SQLException {
        if (feline.getIdPet() <= 0) {
            throw new IllegalArgumentException("El IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(feline);
    }

    public List<Feline> getAllFelines() throws SQLException {
        return repository.findAll();
    }

    public Feline getFelineByPetId(int idPet) throws SQLException {
        return repository.findByPetId(idPet);
    }
}
