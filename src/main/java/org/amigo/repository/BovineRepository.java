package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.Bovine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BovineRepository {

    public void save(Bovine bovine) throws SQLException {
        String sql = "INSERT INTO Bovine (IdPet, Rumenotomia, Cesarea, Reparacion_prolapso_rectal, Episiotomia, " +
                "Castracion, Descornado, Reparacion_hernia_umbilical, Cirugias_podales) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bovine.getIdPet());
            stmt.setInt(2, bovine.getRumenotomia());
            stmt.setInt(3, bovine.getCesarea());
            stmt.setInt(4, bovine.getReparacionProlapso());
            stmt.setInt(5, bovine.getEpisiotomia());
            stmt.setInt(6, bovine.getCastracion());
            stmt.setInt(7, bovine.getDescornado());
            stmt.setInt(8, bovine.getReparacionHernias());
            stmt.setInt(9, bovine.getCirugiasPodales());

            stmt.executeUpdate();
        }
    }

    /** Busca un registro específico por PK compuesta (IdPet + vaca). */
    public Bovine findById(int idPet, String vaca) throws SQLException {
        String sql = "SELECT * FROM Bovine WHERE IdPet = ? AND vaca = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPet);
            stmt.setString(2, vaca);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public List<Bovine> findByPetId(int idPet) throws SQLException {
        List<Bovine> list = new ArrayList<>();
        String sql = "SELECT * FROM Bovine WHERE IdPet = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPet);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        }
        return list;
    }

    public List<Bovine> findAll() throws SQLException {
        List<Bovine> list = new ArrayList<>();
        String sql = "SELECT * FROM Bovine";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    private Bovine map(ResultSet rs) throws SQLException {
        Bovine b = new Bovine();
        b.setIdPet(rs.getInt("IdPet"));
        b.setRumenotomia(rs.getInt("Rumenotomia"));
        b.setCesarea(rs.getInt("Cesarea"));
        b.setReparacionProlapso(rs.getInt("Reparacion_prolapso_rectal"));
        b.setEpisiotomia(rs.getInt("Episiotomia"));
        b.setCastracion(rs.getInt("Castracion"));
        b.setDescornado(rs.getInt("Descornado"));
        b.setReparacionHernias(rs.getInt("Reparacion_hernia_umbilical"));
        b.setCirugiasPodales(rs.getInt("Cirugias_podales"));
        return b;
    }
}
