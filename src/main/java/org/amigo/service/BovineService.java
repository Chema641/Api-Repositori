package org.amigo.service;

import org.amigo.model.Bovine;
import org.amigo.repository.BovineRepository;

import java.sql.SQLException;
import java.util.List;

public class BovineService {
    private final BovineRepository repository = new BovineRepository();

    public void save(Bovine bovine) throws SQLException {
        if (bovine.getIdPet() <= 0) {
            throw new IllegalArgumentException("IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(bovine);
    }

    public Bovine getById(int idPet, String vaca) throws SQLException {
        return repository.findById(idPet, vaca);
    }

    public List<Bovine> getByPetId(int idPet) throws SQLException {
        return repository.findByPetId(idPet);
    }

    public List<Bovine> getAll() throws SQLException {
        return repository.findAll();
    }
}
