package com.golfzone.social.user;

import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public UserDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);
//			jdbcConnectionTest();

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

    @Override
    public void insertUser(UserVO userVO) {
        String id = "";
        id = userVO.getUserName() + ","
                + userVO.getUserId() + ","
                + userVO.getUserPw() + ","
                + userVO.getUserLocation() + ","
                + userVO.getUserAge() + ","
                + userVO.isUserSex() + ","
                + userVO.getUserTier() + ","
                + userVO.getUserScore();
        String tmpId = "'" + id + "'";
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");

            String sql = MariaDB.USER_INSERT + tmpId;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

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
    public UserVO findByUser(String userId) {
        UserVO vo = new UserVO();
        String id2 = "'" + userId + "'";
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");

            String sql = MariaDB.USER_FIND_BY_USER + id2;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setUserNum(rs.getInt("USER_NUM"));
                vo.setUserId(rs.getString("USER_ID"));
                vo.setUserPw(rs.getString("USER_PW"));
                vo.setUserName(rs.getString("USER_NAME"));
                vo.setUserLocation(rs.getString("USER_LOCATION"));
                vo.setUserAge(rs.getInt("USER_AGE"));
                vo.setUserSex(rs.getBoolean("USER_SEX"));
                vo.setUserTier(rs.getString("USER_TIER"));
                vo.setUserScore(rs.getInt("USER_SCORE"));
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

        return vo;
    }
}
