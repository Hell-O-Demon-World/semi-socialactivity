package com.golfzone.social.clubmember;

import com.golfzone.social.db.MariaDB;
import com.golfzone.social.db.dbCon;
import com.golfzone.social.user.UserVO;

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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public int insertClubMember(ClubMemberVO clubMemberVO) {
        int flag;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("insertClubMember: conn success");
            String sql = MariaDB.INSERT_CLUB_MEMBER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubMemberVO.getRoleNum());
            pstmt.setInt(2, clubMemberVO.getClubNum());
            pstmt.setInt(3, clubMemberVO.getUserNum());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return flag;
    }

    @Override
    public ClubMemberVO findByUser(UserVO userVO) {
        ClubMemberVO vo = new ClubMemberVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("findByClubNum: conn success");

            String sql = MariaDB.CLUB_MEMBER_FIND_BY_USER_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userVO.getUserNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setMemberNum(rs.getInt("MEMBER_NUM"));
                vo.setRoleNum(rs.getInt("ROLE_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setUserNum(rs.getInt("USER_NUM"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }

    @Override
    public ClubMemberVO findByUserNumClubNum(ClubMemberVO clubMemberVO) {
        ClubMemberVO vo = new ClubMemberVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("findByClubNum: conn success");

            String sql = MariaDB.CLUB_MEMBER_FIND_BY_USER_NUM_CLUB_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubMemberVO.getUserNum());
            pstmt.setInt(2, clubMemberVO.getClubNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setMemberNum(rs.getInt("MEMBER_NUM"));
                vo.setRoleNum(rs.getInt("ROLE_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setUserNum(rs.getInt("USER_NUM"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }

    @Override
    public List<ClubMemberVO> selectAllByUserNum(int userNum) {
        List<ClubMemberVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("ClubMember selectAll: conn success");

            String sql = MariaDB.CLUB_MEMBER_FIND_BY_USER_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNum);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ClubMemberVO vo = new ClubMemberVO();
                vo.setMemberNum(rs.getInt("MEMBER_NUM"));
                vo.setRoleNum(rs.getInt("ROLE_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setUserNum(rs.getInt("USER_NUM"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vos;
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
                vo.setMemberNum(rs.getInt("MEMBER_NUM"));
                vo.setRoleNum(rs.getInt("ROLE_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setUserNum(rs.getInt("USER_NUM"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vos;
    }
}

