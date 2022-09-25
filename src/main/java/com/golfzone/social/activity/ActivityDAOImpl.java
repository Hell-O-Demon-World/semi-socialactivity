package com.golfzone.social.activity;

import com.golfzone.social.db.MariaDB;

import java.sql.*;

public class ActivityDAOImpl implements ActivityDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ActivityDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);
//			jdbcConnectionTest();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
    public int insertActivity(ActivityVO activityVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");
            String sql = MariaDB.INSERT_ACTIVITY;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, activityVO.getActivityTitle());
            pstmt.setString(2, activityVO.getActivityDescription());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        } // end finally
        return flag;
    }
}
