package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.FelineVaccines;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FelineVaccinesRepository {

    public void save(FelineVaccines felineVaccines) throws SQLException {
        String sql = "INSERT INTO Feline_vacunas (IdPet, Panleucopenia_felina, Herpesvirus_felino, Calicivirus_felino, Rabia, Leucemia_felina, PIF, Clamidiosis_felina) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, felineVaccines.getIdPet());
            stmt.setInt(2, felineVaccines.getPanleucopeniaFelina());
            stmt.setInt(3, felineVaccines.getHerpesvirusFelino());
            stmt.setInt(4, felineVaccines.getCalicivirusFelino());
            stmt.setInt(5, felineVaccines.getRabia());
            stmt.setInt(6, felineVaccines.getLeucemiaFelina());
            stmt.setInt(7, felineVaccines.getPif());
            stmt.setInt(8, felineVaccines.getClamidiosisFelina());
            stmt.executeUpdate();
        }
    }

    public List<FelineVaccines> findAll() throws SQLException {
        List<FelineVaccines> list = new ArrayList<>();
        String sql = "SELECT * FROM Feline_vacunas";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FelineVaccines fv = new FelineVaccines();
                fv.setIdPet(rs.getInt("IdPet"));
                fv.setPanleucopeniaFelina(rs.getInt("Panleucopenia_felina"));
                fv.setHerpesvirusFelino(rs.getInt("Herpesvirus_felino"));
                fv.setCalicivirusFelino(rs.getInt("Calicivirus_felino"));
                fv.setRabia(rs.getInt("Rabia"));
                fv.setLeucemiaFelina(rs.getInt("Leucemia_felina"));
                fv.setPif(rs.getInt("PIF"));
                fv.setClamidiosisFelina(rs.getInt("Clamidiosis_felina"));
                list.add(fv);
            }
        }
        return list;
    }
}
