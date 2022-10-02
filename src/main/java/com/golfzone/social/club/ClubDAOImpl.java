package com.golfzone.social.club;

import com.golfzone.social.db.MariaDB;
import com.golfzone.social.db.dbCon;

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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public int insertClub(ClubVO clubVO) {
        int flag;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("insertClub: conn success");
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return flag;
    }

    @Override
    public ClubVO findByClubNum(ClubVO clubVO) {
        ClubVO vo = new ClubVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("findByClubName: conn success");

            String sql = MariaDB.CLUB_FIND_BY_CLUB_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubVO.getClubNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setClubNum(rs.getInt("CLUB_NUM"));
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }


    @Override
    public ClubVO findByClubName(ClubVO clubVO) {
        ClubVO vo = new ClubVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("findByClubName: conn success");

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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }

    @Override
    public ClubVO findByClubPassword(ClubVO clubVO) {
        ClubVO vo = new ClubVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("findByClubPassword: conn success");

            String sql = MariaDB.CLUB_FIND_BY_CLUB_PASSWORD;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clubVO.getClubName());
            pstmt.setString(2, clubVO.getClubPw());
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }

    @Override
    public ClubVO countClubMember(int ClubNum) {
        ClubVO vo = new ClubVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("countClubMember: conn success");
            String sql = MariaDB.COUNT_CLUB_MEMBER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ClubNum);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                vo.setClubMemberCount(rs.getInt("COUNT"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }

    @Override
    public List<ClubVO> selectAll() {
        List<ClubVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Club selectAll: conn success");

            String sql = MariaDB.CLUB_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ClubVO vo = new ClubVO();
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setClubEmblemPath(rs.getString("CLUB_EMBLEMPATH"));
                vo.setClubName(rs.getString("CLUB_NAME"));
                vo.setClubLocation(rs.getString("CLUB_LOCATION"));
                vo.setClubMaxCount(rs.getInt("CLUB_MAXCOUNT"));
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

