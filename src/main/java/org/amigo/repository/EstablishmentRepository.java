package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Establishment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstablishmentRepository {

    public void save(Establishment establishment) throws SQLException {
        String sql = "INSERT INTO Establishment (nombre, descripcion, direccion) VALUES (?, ?, ?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, establishment.getNombre());
            stmt.setString(2, establishment.getDescripcion());
            stmt.setString(3, establishment.getDireccion());
            stmt.executeUpdate();
        }
    }

    public List<Establishment> findAll() throws SQLException {
        List<Establishment> establishments = new ArrayList<>();
        String sql = "SELECT * FROM Establishment";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Establishment est = new Establishment();
                est.setIdLocal(rs.getInt("IdLocal"));
                est.setNombre(rs.getString("nombre"));
                est.setDescripcion(rs.getString("descripcion"));
                est.setDireccion(rs.getString("direccion"));
                establishments.add(est);
            }
        }
        return establishments;
    }
}
