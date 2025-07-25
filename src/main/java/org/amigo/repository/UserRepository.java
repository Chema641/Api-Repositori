package org.amigo.repository;

import org.amigo.config.Database;
import org.amigo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Usuario";
        try (
                Connection conn = Database.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User u = new User();
                // Asegúrate de que estos nombres de columna coincidan EXACTAMENTE con tu script SQL
                u.setIdUser(rs.getInt("IdUser"));
                u.setNombre(rs.getString("nombre")); //
                u.setEmail(rs.getString("email"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setContra(rs.getString("contra"));
                users.add(u);
            }
        }
        return users;
    }

    public User findByIdUser(int idUser) throws SQLException {
        User user = null;
        String query = "SELECT * FROM Usuario WHERE IdUser = ?";

        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idUser);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setIdUser(rs.getInt("IdUser"));
                    user.setNombre(rs.getString("nombre"));
                    user.setEmail(rs.getString("email"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setContra(rs.getString("contra"));
                }
            }
        }

        return user;
    }

    public void save(User user) throws SQLException {

        String query = "INSERT INTO Usuario (nombre, email, contra, phoneNumber) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getContra());
            stmt.setString(4, user.getPhoneNumber());

            stmt.executeUpdate();
        }
    }
}