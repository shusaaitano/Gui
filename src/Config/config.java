package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class config {

    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load SQLite driver
            con = DriverManager.getConnection("jdbc:sqlite:cozystay.db"); // Connect
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    public boolean addRecord(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        pstmt.executeUpdate();
        System.out.println("Record added successfully!");
        return true;

    } catch (SQLException e) {
        System.out.println("Error adding record: " + e.getMessage());
        return false;
    }
}
    public boolean emailExists(String email) {
    String sql = "SELECT 1 FROM account WHERE email = ?";

    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();

        return rs.next(); // true if email exists

    } catch (SQLException e) {
        System.out.println("Email check error: " + e.getMessage());
    }
    return false;
}

    public String authenticate(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("type");
            }
        }
    } catch (SQLException e) {
        System.out.println("Login Error: " + e.getMessage());
    }
    return null;
}
    
    public void displayData(String sql, javax.swing.JTable table) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        // This line automatically maps the Resultset to your JTable
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    } catch (SQLException e) {
        System.out.println("Error displaying data: " + e.getMessage());
    }
}
    
    public ResultSet getData(String sql) throws SQLException {
        Connection con = connectDB();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
    
    public boolean isDuplicate(String sql, Object[] values) {
    try (Connection con = connectDB();
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        for (int i = 0; i < values.length; i++) {
            pst.setObject(i + 1, values[i]);
        }
        
        ResultSet rs = pst.executeQuery();
        return rs.next(); // Returns true if a match is found
        
    } catch (SQLException ex) {
        System.out.println("Validation Error: " + ex.getMessage());
        return false;
    }
}
}
