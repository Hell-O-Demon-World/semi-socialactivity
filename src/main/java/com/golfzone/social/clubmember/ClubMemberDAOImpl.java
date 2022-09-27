package com.golfzone.social.clubmember;

import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClubMemberDAOImpl implements ClubMemberDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ClubMemberDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);
//			jdbcConnectionTest();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertClubMember(ClubMemberVO clubMemberVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("insertClubMember: conn success");
            String sql = MariaDB.INSERT_CLUB_MEMBER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubMemberVO.getRoleNum());
            pstmt.setInt(2, clubMemberVO.getAuthNum());
            pstmt.setInt(3, clubMemberVO.getClubNum());
            pstmt.setInt(4, clubMemberVO.getUserNum());
            pstmt.setString(5, clubMemberVO.getTierName());
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
    public ClubMemberVO findByClubNum(ClubMemberVO clubMemberVO) {
        ClubMemberVO vo = new ClubMemberVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("findByClubNum: conn success");

            String sql = MariaDB.CLUB_MEMBER_FIND_BY_CLUB_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubMemberVO.getClubNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setMemberNum(rs.getInt("MEMBER_NUM"));
                vo.setRoleNum(rs.getInt("ROLE_NUM"));
                vo.setAuthNum(rs.getInt("AUTH_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setUserNum(rs.getInt("USER_NUM"));
                vo.setTierName(rs.getString("TIER_NAME"));
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
    public List<ClubMemberVO> selectAll() {
        List<ClubMemberVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("ClubMember selectAll: conn success");

            String sql = MariaDB.CLUB_MEMBER_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ClubMemberVO vo = new ClubMemberVO();
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setRoleNum(rs.getInt("ROLE_NUM"));
                vo.setRoleNum(rs.getInt("AUTH_NUM"));
                vo.setRoleNum(rs.getInt("CLUB_NUM"));
                vo.setRoleNum(rs.getInt("USER_NUM"));
                vo.setRoleNum(rs.getInt("TIER_NAME"));
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

