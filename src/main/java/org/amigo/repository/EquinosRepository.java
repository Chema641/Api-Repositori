package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Equinos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquinosRepository {

    public void save(Equinos equinos) throws SQLException {
        String sql = "INSERT INTO Equinos (IdPet, Artroscopia, Reparacion_fracturas, Desmotomia_ligamento_palmar, Laparotomia_exploratoria, Reparacion_hernias_estranguladas, Laringoplastia, Sinovectomia_bolsas_guturales, Extraccion_cataratas, Reparacion_ulceras_corneales) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, equinos.getIdPet());
            stmt.setInt(2, equinos.getArtroscopia());
            stmt.setInt(3, equinos.getReparacionFracturas());
            stmt.setInt(4, equinos.getDesmotomiaLigamentoPalmar());
            stmt.setInt(5, equinos.getLaparotomiaExploratoria());
            stmt.setInt(6, equinos.getReparacionHerniasEstranguladas());
            stmt.setInt(7, equinos.getLaringoplastia());
            stmt.setInt(8, equinos.getSinovectomiaBolsasGuturales());
            stmt.setInt(9, equinos.getExtraccionCataratas());
            stmt.setInt(10, equinos.getReparacionUlcerasCorneales());
            stmt.executeUpdate();
        }
    }

    public List<Equinos> findAll() throws SQLException {
        List<Equinos> list = new ArrayList<>();
        String sql = "SELECT * FROM Equinos";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Equinos e = new Equinos();
                e.setIdPet(rs.getInt("IdPet"));
                e.setArtroscopia(rs.getInt("Artroscopia"));
                e.setReparacionFracturas(rs.getInt("Reparacion_fracturas"));
                e.setDesmotomiaLigamentoPalmar(rs.getInt("Desmotomia_ligamento_palmar"));
                e.setLaparotomiaExploratoria(rs.getInt("Laparotomia_exploratoria"));
                e.setReparacionHerniasEstranguladas(rs.getInt("Reparacion_hernias_estranguladas"));
                e.setLaringoplastia(rs.getInt("Laringoplastia"));
                e.setSinovectomiaBolsasGuturales(rs.getInt("Sinovectomia_bolsas_guturales"));
                e.setExtraccionCataratas(rs.getInt("Extraccion_cataratas"));
                e.setReparacionUlcerasCorneales(rs.getInt("Reparacion_ulceras_corneales"));
                list.add(e);
            }
        }
        return list;
    }
}
