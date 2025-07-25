package org.amigo.service;

import org.amigo.model.Equinos;
import org.amigo.repository.EquinosRepository;

import java.sql.SQLException;
import java.util.List;

public class EquinosService {
    private final EquinosRepository repository = new EquinosRepository();

    public void saveEquinos(Equinos equinos) {
        try {
            repository.save(equinos);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving equinos data", e);
        }
    }

    public List<Equinos> getAllEquinos() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving equinos data", e);
        }
    }


}
