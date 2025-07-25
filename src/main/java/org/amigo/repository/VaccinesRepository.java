package org.amigo.repository;

import org.amigo.model.Vaccines;
import org.amigo.config.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VaccinesRepository {

    public void save(Vaccines vaccines) throws SQLException {
        String sql = "INSERT INTO Vaccines (IdPet) VALUES (?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vaccines.getIdPet());
            stmt.executeUpdate();
        }
    }

    public Vaccines findById(int idPet) throws SQLException {
        String sql = "SELECT * FROM Vaccines WHERE IdPet = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPet);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Vaccines(rs.getInt("IdPet"));
                }
            }
        }
        return null;
    }

    public List<Vaccines> findAll() throws SQLException {
        String sql = "SELECT * FROM Vaccines";
        List<Vaccines> list = new ArrayList<>();
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Vaccines(rs.getInt("IdPet")));
            }
        }
        return list;
    }
}
