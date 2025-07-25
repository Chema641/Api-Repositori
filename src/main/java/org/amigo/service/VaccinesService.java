package org.amigo.service;

import org.amigo.model.Vaccines;
import org.amigo.repository.VaccinesRepository;

import java.sql.SQLException;
import java.util.List;

public class VaccinesService {
    private final VaccinesRepository repository = new VaccinesRepository();

    public void save(Vaccines vaccines) throws SQLException {
        if (vaccines.getIdPet() <= 0) {
            throw new IllegalArgumentException("El IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(vaccines);
    }

    public Vaccines findById(int idPet) throws SQLException {
        return repository.findById(idPet);
    }

    public List<Vaccines> findAll() throws SQLException {
        return repository.findAll();
    }

    public List <Vaccines> delete (int idPet) {
        return null;
    }


}
