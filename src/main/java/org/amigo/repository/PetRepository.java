package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {

    public void save(Pet pet) throws SQLException {
        String sql = "INSERT INTO Pet (IdPet, IdUser,nombre, age, sex, weight, size, photo, numVisit, condition_, lastVisit, state, treatment, lastVaccines, race) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pet.getIdPet());
            stmt.setInt(2, pet.getIdUser());
            stmt.setString(3, pet.getNombre());
            stmt.setInt(4, pet.getAge());
            stmt.setString(5, pet.getSex());
            stmt.setString(6, pet.getWeight());
            stmt.setString(7, pet.getSize());
            stmt.setString(8, pet.getPhoto());
            stmt.setInt(9, pet.getNumVisit());
            stmt.setString(10, pet.getCondition());
            stmt.setString(11, pet.getLastVisit());
            stmt.setString(12, pet.getState());
            stmt.setString(13, pet.getTreatment());
            stmt.setString(14, pet.getLastVaccines());
            stmt.setString(15, pet.getRace());
            stmt.executeUpdate();
        }
    }

    public List<Pet> findAll() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM Pet";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pet p = new Pet();
                p.setIdPet(rs.getInt("IdPet"));
                p.setIdUser(rs.getInt("IdUser"));
                p.setNombre(rs.getString("nombre"));
                p.setAge(rs.getInt("age"));
                p.setSex(rs.getString("sex"));
                p.setWeight(rs.getString("weight"));
                p.setSize(rs.getString("size"));
                p.setPhoto(rs.getString("photo"));
                p.setNumVisit(rs.getInt("numVisit"));
                p.setCondition(rs.getString("condition_"));
                p.setLastVisit(rs.getString("lastVisit"));
                p.setState(rs.getString("state"));
                p.setTreatment(rs.getString("treatment"));
                p.setLastVaccines(rs.getString("lastVaccines"));
                p.setRace(rs.getString("race"));
                pets.add(p);
            }
        }
        return pets;
    }
}
