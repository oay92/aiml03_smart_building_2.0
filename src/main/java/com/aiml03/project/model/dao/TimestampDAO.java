package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimestampDAO {
    private Connection conn;

    public TimestampDAO(Connection conn) {
        this.conn = conn;
    }

    public List<String> getFaceTimestamps(String userID) throws SQLException {
        List<String> faceTimestamps = new ArrayList<>();
        final String SQL = "SELECT face_timestamp FROM face_table WHERE user_id = ?";
        try (PreparedStatement preState = conn.prepareStatement(SQL)) {
            preState.setString(1, userID);

            try (ResultSet rs = preState.executeQuery()) {
                while (rs.next()) {
                    String faceTimestamp = rs.getString("face_timestamp");
                    faceTimestamps.add(faceTimestamp);
                }
            }
        }
        return faceTimestamps;
    }

    public List<String> getPlateTimestamps(String userID) throws SQLException {
        List<String> plateTimestamps = new ArrayList<>();
        final String SQL = "SELECT plate_timestamp FROM plate_table WHERE user_id = ?";
        try (PreparedStatement preState = conn.prepareStatement(SQL)) {
            preState.setString(1, userID);

            try (ResultSet rs = preState.executeQuery()) {
                while (rs.next()) {
                    String plateTimestamp = rs.getString("plate_timestamp");
                    plateTimestamps.add(plateTimestamp);
                }
            }
        }
        return plateTimestamps;
    }
    
    // Other methods for connection handling, if required
}
