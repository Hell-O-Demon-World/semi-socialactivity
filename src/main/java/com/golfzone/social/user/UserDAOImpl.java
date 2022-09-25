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
        List<UserVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");
            String sql = MariaDB.USER_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserVO vo = new UserVO();
                vo.setUserNum(rs.getInt("userNum"));
                vo.setUserName(rs.getString("userName"));
                vo.setUserId(rs.getString("userID"));
                vo.setUserPw(rs.getString("userPW"));
                vo.setUserLocation(rs.getString("userLocation"));
                vo.setUserAge(rs.getInt("userAge"));
                vo.setUserSex(rs.getBoolean("userSex"));
                vo.setUserTier(rs.getString("userTier"));
                vo.setUserScore(rs.getInt("userScore"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return vos;
    }

    @Override
    public int insertUser(UserVO userVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");
            String sql = MariaDB.INSERT_USER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userVO.getUserName());
            pstmt.setString(2, userVO.getUserId());
            pstmt.setString(3, userVO.getUserPw());
            pstmt.setString(4, userVO.getUserLocation());
            pstmt.setInt(5, userVO.getUserAge());
            pstmt.setBoolean(6, userVO.isUserSex());
            pstmt.setString(7, userVO.getUserTier());
            pstmt.setInt(8, userVO.getUserScore());
            flag = pstmt.executeUpdate();
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
        return flag;
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
