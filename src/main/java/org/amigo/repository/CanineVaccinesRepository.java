package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.CanineVaccines;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanineVaccinesRepository {

    public void save(CanineVaccines cv) throws SQLException {
        String query = "INSERT INTO Canine_vacunas (IdPet, Moquillo_canino, Parvovirus_canino, Adenovirus_canino, Rabia, Leptospirosis, Parainfluenza_canina, Bordetella_bronchiseptica, Enfermedad_Lyme) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, cv.getIdPet());
            stmt.setInt(2, cv.getMoquilloCanino());
            stmt.setInt(3, cv.getParvovirusCanino());
            stmt.setInt(4, cv.getAdenovirusCanino());
            stmt.setInt(5, cv.getRabia());
            stmt.setInt(6, cv.getLeptospirosis());
            stmt.setInt(7, cv.getParainfluenzaCanina());
            stmt.setInt(8, cv.getBordetellaBronchiseptica());
            stmt.setInt(9, cv.getEnfermedadLyme());
            stmt.executeUpdate();
        }
    }

    public List<CanineVaccines> findAll() throws SQLException {
        List<CanineVaccines> list = new ArrayList<>();
        String query = "SELECT * FROM Canine_vacunas";
        try (Connection conn = Database.getDataSource().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                CanineVaccines cv = mapResultSet(rs);
                list.add(cv);
            }
        }
        return list;
    }

    public CanineVaccines findByPetId(int idPet) throws SQLException {
        String query = "SELECT * FROM Canine_vacunas WHERE IdPet = ?";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPet);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSet(rs);
                }
            }
        }
        return null;
    }

    private CanineVaccines mapResultSet(ResultSet rs) throws SQLException {
        CanineVaccines cv = new CanineVaccines();
        cv.setIdPet(rs.getInt("IdPet"));
        cv.setMoquilloCanino(rs.getInt("Moquillo_canino"));
        cv.setParvovirusCanino(rs.getInt("Parvovirus_canino"));
        cv.setAdenovirusCanino(rs.getInt("Adenovirus_canino"));
        cv.setRabia(rs.getInt("Rabia"));
        cv.setLeptospirosis(rs.getInt("Leptospirosis"));
        cv.setParainfluenzaCanina(rs.getInt("Parainfluenza_canina"));
        cv.setBordetellaBronchiseptica(rs.getInt("Bordetella_bronchiseptica"));
        cv.setEnfermedadLyme(rs.getInt("Enfermedad_Lyme"));
        return cv;
    }
}
