package org.amigo.service;

import org.amigo.model.Canine;
import org.amigo.repository.CanineRepository;

import java.sql.SQLException;
import java.util.List;

public class CanineService {
    private final CanineRepository repository = new CanineRepository();

    public void saveCanine(Canine canine) {
        try {
            repository.save(canine);
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar Canine: " + e.getMessage(), e);
        }
    }

    public List<Canine> getAllCanines() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener lista Canine: " + e.getMessage(), e);
        }
    }

    public Canine getByPetId(int idPet) {
        try {
            return repository.findByPetId(idPet);
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar por idPet: " + e.getMessage(), e);
        }
    }
}
