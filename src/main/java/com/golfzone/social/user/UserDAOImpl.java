package com.golfzone.social.user;

import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public UserDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);
			jdbcConnectionTest();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void jdbcConnectionTest() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn successed...");

            String sql = "select version() as version";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("version"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } // end finally
    }
    @Override
    public List<UserVO> selectAll() {
        return null;
    }
}
