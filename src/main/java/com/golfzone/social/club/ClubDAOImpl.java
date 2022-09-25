package com.golfzone.social.club;

import com.golfzone.social.db.MariaDB;
import com.golfzone.social.user.UserVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClubDAOImpl implements ClubDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ClubDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);
//			jdbcConnectionTest();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertClub(ClubVO clubVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");
            String sql = MariaDB.INSERT_CLUB;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clubVO.getClubName());
            pstmt.setInt(2, clubVO.getClubMaxCount());
            pstmt.setInt(3, clubVO.getClubAge());
            pstmt.setString(4, clubVO.getClubLocation());
            pstmt.setString(5, clubVO.getClubTier());
            pstmt.setString(6, clubVO.getClubDescription());
            pstmt.setString(7, clubVO.getClubEmblemPath());
            pstmt.setInt(8, clubVO.getClubSex());
            pstmt.setString(9, clubVO.getClubPw());
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
    public ClubVO findByClubName(ClubVO clubVO) {
        ClubVO vo = new ClubVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");

            String sql = MariaDB.CLUB_FIND_BY_CLUB_NAME;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clubVO.getClubName());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setClubName(rs.getString("CLUB_NAME"));
                vo.setClubMaxCount(rs.getInt("CLUB_MAXCOUNT"));
                vo.setClubAge(rs.getInt("CLUB_AGE"));
                vo.setClubLocation(rs.getString("CLUB_LOCATION"));
                vo.setClubTier(rs.getString("CLUB_TIER"));
                vo.setClubDescription(rs.getString("CLUB_DESCRIPTION"));
                vo.setClubEmblemPath(rs.getString("CLUB_EMBLEMPATH"));
                vo.setClubSex(rs.getInt("CLUB_SEX"));
                vo.setClubPw(rs.getString("CLUB_PW"));
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

    @Override
    public List<ClubVO> selectAll() {
        List<ClubVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("conn success");

            String sql = MariaDB.CLUB_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ClubVO vo = new ClubVO();
                vo.setClubEmblemPath(rs.getString("CLUB_EMBLEMPATH"));
                vo.setClubName(rs.getString("CLUB_NAME"));
                vo.setClubLocation(rs.getString("CLUB_LOCATION"));
                vo.setClubMaxCount(rs.getInt("CLUB_MAXCOUNT"));
                vos.add(vo);
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
        return vos;
    }
}

