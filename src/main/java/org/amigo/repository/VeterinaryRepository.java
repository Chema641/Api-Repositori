package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Veterinary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinaryRepository {

    public List<Veterinary> findAll() throws SQLException {
        List<Veterinary> list = new ArrayList<>();
        String query = "SELECT * FROM Veterinary";

        try (
                Connection conn = Database.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Veterinary vet = new Veterinary();
                // Asegúrate de que estos nombres de columna coincidan con tu base de datos
                vet.setIdVet(rs.getInt("Idvet"));
                vet.setIdUser(rs.getInt("idUser"));
                vet.setIdLocal(rs.getInt("IdLocal"));
                vet.setComprobante(rs.getString("comprobante"));
                vet.setEspecialidad(rs.getString("especialidad"));
                vet.setDisponibilidad(rs.getString("disponibilidad"));
                list.add(vet);
            }
        }

        return list;
    }

    public Veterinary findByIdVet(int idVet) throws SQLException {
        Veterinary vet = null;
        String query = "SELECT * FROM Veterinary WHERE Idvet = ?";

        try (
                Connection conn = Database.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, idVet);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vet = new Veterinary();
                    vet.setIdVet(rs.getInt("Idvet"));
                    vet.setIdUser(rs.getInt("idUser"));
                    vet.setIdLocal(rs.getInt("IdLocal"));
                    vet.setComprobante(rs.getString("comprobante"));
                    vet.setEspecialidad(rs.getString("especialidad"));
                    vet.setDisponibilidad(rs.getString("disponibilidad"));
                }
            }
        }

        return vet;
    }

    public void save(Veterinary vet) throws SQLException {
        String query = "INSERT INTO Veterinary (idUser, IdLocal, comprobante, especialidad, disponibilidad) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = Database.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, vet.getIdUser());
            stmt.setInt(2, vet.getIdLocal());
            stmt.setString(3, vet.getComprobante());
            stmt.setString(4, vet.getEspecialidad());
            stmt.setString(5, vet.getDisponibilidad());

            stmt.executeUpdate();
        }
    }
}
