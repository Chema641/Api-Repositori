package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.BovineVaccines;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BovineVaccinesRepository {

    public void save(BovineVaccines bovineVaccines) throws SQLException {
        String sql = "INSERT INTO Bovine_vacunas (IdPet, Carbunco, Fiebre_aftosa, Brucelosis, Leptospirosis, Clostridiales, IBR, Diarrea_viral_bovina, Parainfluenza)" +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = Database.getDataSource().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bovineVaccines.getIdPet());
            stmt.setInt(2, bovineVaccines.getCarbunco());
            stmt.setInt(3, bovineVaccines.getFiebre_aftosa());
            stmt.setInt(4, bovineVaccines.getBrucelosis ());
            stmt.setInt(5, bovineVaccines.getLeptospirosis());
            stmt.setInt(6, bovineVaccines.getClostridiales());
            stmt.setInt(7, bovineVaccines.getIBR());
            stmt.setInt(8, bovineVaccines.getDiarrea_viral_bovina());
            stmt.setInt(9, bovineVaccines.getParainfluenza());
            stmt.executeUpdate();
        }
    }

    public List<BovineVaccines> findAll() throws SQLException {
        List<BovineVaccines> list = new ArrayList<>();
        String sql = "SELECT * FROM Bovine_vacunas";

        try (Connection conn = Database.getDataSource().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BovineVaccines bv = new BovineVaccines();
                bv.setIdPet(rs.getInt("IdPet"));
                bv.setCarbunco(rs.getInt("Carbunco"));
                bv.setFiebre_aftosa(rs.getInt("Fiebre_aftosa"));
                bv.setBrucelosis(rs.getInt("Brucelosis"));
                bv.setLeptospirosis(rs.getInt("Leptospirosis"));
                bv.setClostridiales(rs.getInt("Clostridiales"));
                bv.setIBR(rs.getInt("IBR"));
                bv.setDiarrea_viral_bovina(rs.getInt("Diarrea_viral_bovina"));
                bv.setParainfluenza(rs.getInt("Parainfluenza"));
            }
        }
        return list;
    }
}