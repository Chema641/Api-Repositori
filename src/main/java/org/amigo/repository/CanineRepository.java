package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Canine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanineRepository {

    public void save(Canine canine) throws SQLException {
        String sql = "INSERT INTO Canine (idPet, Esterilizacion, Cesarea, Reparacion_fracturas, " +
                "Luxacion_patela, Displasia_cadera, Mastectomia, " +
                "Amputacion_extremidades, Entropion_ectropion, Enucleacion_ocular, Ligadura_PDA) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, canine.getIdPet());
            stmt.setInt(2, canine.getEsterilizacion());
            stmt.setInt(3, canine.getCesarea());
            stmt.setInt(4, canine.getReparacion_fracturas());
            stmt.setInt(5, canine.getLuxacion_patela());
            stmt.setInt(6, canine.getDisplasia_cadera());
            stmt.setInt(7, canine.getMastectomia());
            stmt.setInt(8, canine.getAmputacion_extremidades());
            stmt.setInt(9, canine.getEntropionEctropion());
            stmt.setInt(10, canine.getEnucleacion_ocular());
            stmt.setInt(11, canine.getLigadura_pda());
            stmt.executeUpdate();
        }
    }

    public List<Canine> findAll() throws SQLException {
        List<Canine> list = new ArrayList<>();
        String sql = "SELECT * FROM Canine";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Canine c = new Canine();
                c.setIdPet(rs.getInt("idPet"));
                c.setEsterilizacion(rs.getInt("Esterilizacion"));
                c.setCesarea(rs.getInt("Cesarea"));
                c.setReparacion_fracturas(rs.getInt("Reparacion_fracturas"));
                c.setLuxacion_patela(rs.getInt("Luxacion_patela"));
                c.setDisplasia_cadera(rs.getInt("Displasia_cadera"));
                c.setMastectomia(rs.getInt("Mastectomia"));
                c.setAmputacion_extremidades(rs.getInt("Amputacion_extremidades"));
                c.setEntropionEctropion(rs.getInt("Entropion_ectropion"));
                c.setEnucleacion_ocular(rs.getInt("Enucleacion_ocular"));
                c.setLigadura_pda(rs.getInt("Ligadura_PDA"));
                list.add(c);
            }
        }
        return list;
    }

    public Canine findByPetId(int idPet) throws SQLException {
        String sql = "SELECT * FROM Canine WHERE idPet = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPet);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Canine c = new Canine();
                    c.setIdPet(rs.getInt("idPet"));
                    c.setEsterilizacion(rs.getInt("Esterilizacion"));
                    c.setCesarea(rs.getInt("Cesarea"));
                    c.setReparacion_fracturas(rs.getInt("Reparacion_de_fracturas"));
                    c.setLuxacion_patela(rs.getInt("Correccion_de_luxacion_patela"));
                    c.setDisplasia_cadera(rs.getInt("Cirugia_para_displasia_de_cadera"));
                    c.setMastectomia(rs.getInt("Mastectomia"));
                    c.setAmputacion_extremidades(rs.getInt("Amputacion_de_extremidades"));
                    c.setEntropionEctropion(rs.getInt("Entropion_ectropion"));
                    c.setEnucleacion_ocular(rs.getInt("Enucleacion_ocular"));
                    c.setLigadura_pda(rs.getInt("Ligadura_de_PDA"));
                    return c;
                }
            }
        }
        return null;
    }
}
