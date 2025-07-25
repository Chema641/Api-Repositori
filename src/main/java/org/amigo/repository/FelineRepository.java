package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Feline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FelineRepository {

    public void save(Feline feline) throws SQLException {
        String sql = "INSERT INTO Feline (IdPet, Esterilizacion, Extraccion_cuerpos_extranos, Cistotomia, Uretrostomia_perineal, Tiroidectomia, Extraccion_dental, Reparacion_ulceras_corneales) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, feline.getIdPet());
            stmt.setInt(2, feline.getEsterilizacion());
            stmt.setInt(3, feline.getExtraccionCuerposExtranos());
            stmt.setInt(4, feline.getCistotomia());
            stmt.setInt(5, feline.getUretrostomiaPerineal());
            stmt.setInt(6, feline.getTiroidectomia());
            stmt.setInt(7, feline.getExtraccionDental());
            stmt.setInt(8, feline.getReparacionUlcerasCorneales());
            stmt.executeUpdate();
        }
    }

    public List<Feline> findAll() throws SQLException {
        List<Feline> felines = new ArrayList<>();
        String sql = "SELECT * FROM Feline";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Feline feline = new Feline();
                feline.setIdPet(rs.getInt("IdPet"));
                feline.setEsterilizacion(rs.getInt("Esterilizacion"));
                feline.setExtraccionCuerposExtranos(rs.getInt("Extraccion_cuerpos_extranos"));
                feline.setCistotomia(rs.getInt("Cistotomia"));
                feline.setUretrostomiaPerineal(rs.getInt("Uretrostomia_perineal"));
                feline.setTiroidectomia(rs.getInt("Tiroidectomia"));
                feline.setExtraccionDental(rs.getInt("Extraccion_dental"));
                feline.setReparacionUlcerasCorneales(rs.getInt("Reparacion_ulceras_corneales"));
                felines.add(feline);
            }
        }
        return felines;
    }

    public Feline findByPetId(int idPet) throws SQLException {
        String sql = "SELECT * FROM Feline WHERE IdPet = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPet);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Feline feline = new Feline();
                feline.setIdPet(rs.getInt("IdPet"));
                feline.setEsterilizacion(rs.getInt("Esterilizacion"));
                feline.setExtraccionCuerposExtranos(rs.getInt("Extraccion_cuerpos_extranos"));
                feline.setCistotomia(rs.getInt("Cistotomia"));
                feline.setUretrostomiaPerineal(rs.getInt("Uretrostomia_perineal"));
                feline.setTiroidectomia(rs.getInt("Tiroidectomia"));
                feline.setExtraccionDental(rs.getInt("Extraccion_dental"));
                feline.setReparacionUlcerasCorneales(rs.getInt("Reparacion_ulceras_corneales"));
                return feline;
            }
        }
        return null;
    }
}
