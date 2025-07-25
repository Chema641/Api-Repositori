package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Surgeries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurgeriesRepository {

    public void save(Surgeries surgeries) throws SQLException {
        String sql = "INSERT INTO Surgeries (IdPet) VALUES (?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, surgeries.getIdPet());
            stmt.executeUpdate();
        }
    }

    public Surgeries findById(int idPet) throws SQLException {
        String sql = "SELECT * FROM Surgeries WHERE IdPet = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPet);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public List<Surgeries> findAll() throws SQLException {
        List<Surgeries> list = new ArrayList<>();
        String sql = "SELECT * FROM Surgeries";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    private Surgeries map(ResultSet rs) throws SQLException {
        Surgeries s = new Surgeries();
        s.setIdPet(rs.getInt("IdPet"));
        return s;
    }
}
