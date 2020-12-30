package ua.kpi.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ua.kpi.common.ServerAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {
    private final String url = "jdbc:postgresql://localhost/server";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void insertRecord(String message) {
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        ServerAction serverAction = null;
        try {
            serverAction = objectMapper.readValue(message, ServerAction.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String sql = "insert into server_actions(user_uuid, firstname, lastname, time, action) "
                + "values(?,?,?,?,?);";

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, serverAction.getUuid());
            ps.setString(2, serverAction.getFirstName());
            ps.setString(3, serverAction.getLastName());
            ps.setObject(4, serverAction.getTime());
            ps.setString(5, serverAction.getAction().toString());
            ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
