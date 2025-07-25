package org.amigo.service;

import org.amigo.model.Owner;
import org.amigo.repository.OwnerRepository;

import java.sql.SQLException;
import java.util.List;

public class OwnerService {
    private final OwnerRepository repository;

    public OwnerService() {
        this.repository = new OwnerRepository();
    }

    public void saveOwner(Owner owner) throws SQLException {
        repository.save(owner);
    }

    public List<Owner> getAllOwners() throws SQLException {
        return repository.findAll();
    }
}
