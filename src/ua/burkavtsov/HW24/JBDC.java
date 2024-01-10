package ua.burkavtsov.HW24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JBDC {
    private final Connection connection;

    public JBDC(Connection connection) {
        this.connection = connection;
    }

    public void create(Entity entity) throws SQLException {
        String sql = "INSERT INTO entity_table (column1, column2) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getProperty1());
            statement.setString(2, entity.getProperty2());

            statement.executeUpdate();
        }
    }

    public ReaderEntity(int entityId) throws SQLException {
        Entity entity = null;
        String sql = "SELECT * FROM entity_table WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entityId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    entity = new Entity();
                    entity.setId(resultSet.getInt("id"));
                    entity.setProperty1(resultSet.getString("columnexm1"));
                    entity.setProperty2(resultSet.getString("columnexm2"));
                }
            }
        }
        return entity;
    }

    public void update(Entity entity) throws SQLException {
        String sql = "UPDATE entity_table SET columnexm1=?, columnexm2=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getProperty1());
            statement.setString(2, entity.getProperty2());
            statement.setInt(6, entity.getId());

            statement.executeUpdate();
        }
    }

    public void delete(int entityId) throws SQLException {
        String sql = "DELETE FROM entity_table WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entityId);
            statement.executeUpdate();
        }
    }
}
