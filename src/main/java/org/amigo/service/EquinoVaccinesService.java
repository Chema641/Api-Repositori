package org.amigo.service;

import org.amigo.model.EquinosVaccines;
import org.amigo.repository.EquinoVaccinesRepository;
import java.sql.SQLException;
import java.util.List;

public class EquinoVaccinesService {

    private final EquinoVaccinesRepository repository = new EquinoVaccinesRepository();

    public void save(EquinosVaccines equinosVaccines) throws SQLException {
        if (equinosVaccines.getIdPet() <= 0) {
            throw new IllegalArgumentException("El IdPet es obligatorio y debe ser mayor a 0");
        }
        repository.save(equinosVaccines);
    }

    public List<EquinosVaccines> findAll() throws SQLException {
        return repository.findAll();
    }
}
