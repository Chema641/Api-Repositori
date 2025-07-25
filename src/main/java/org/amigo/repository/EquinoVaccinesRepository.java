package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.EquinosVaccines;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EquinoVaccinesRepository {

    public void save(EquinosVaccines equinosVaccines) throws SQLException {
        String sql = "INSERT INTO Equinos_vacunas (IdPet, Encefalomielitis_equina,Tetanus, Influenza_equina, Rinoneumonitis_equina, Rabia, West_nile_virus, Strangles)" +
                "VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, equinosVaccines.getIdPet());
            stmt.setInt(2, equinosVaccines.getEncefalomielitisEquina());
            stmt.setInt(3, equinosVaccines.getTetanus());
            stmt.setInt(4, equinosVaccines.getInfluenzaEquina ());
            stmt.setInt(5, equinosVaccines.getRinoneumonitisEquina());
            stmt.setInt(6, equinosVaccines.getRabia());
            stmt.setInt(7, equinosVaccines.getWestNileVirus());
            stmt.setInt(8, equinosVaccines.getStrangles());
            stmt.executeUpdate();
        }
    }

    public List<EquinosVaccines> findAll() throws SQLException {
        List<EquinosVaccines> list = new ArrayList<>();
        String sql = "SELECT * FROM Equinos_vacunas";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EquinosVaccines ev = new EquinosVaccines();
                ev.setIdPet(rs.getInt("IdPet"));
                ev.setEncefalomielitisEquina(rs.getInt("Encefalomielitis_equina"));
                ev.setTetanus(rs.getInt("Tetanus"));
                ev.setInfluenzaEquina(rs.getInt("Influenza_equina"));
                ev.setRinoneumonitisEquina(rs.getInt("Rinoneumonitis_equina"));
                ev.setRabia(rs.getInt("Rabia"));
                ev.setWestNileVirus(rs.getInt("West_nile_virus"));
                ev.setStrangles(rs.getInt("Strangles"));
                list.add(ev);
            }
        }
        return list;
    }
}
