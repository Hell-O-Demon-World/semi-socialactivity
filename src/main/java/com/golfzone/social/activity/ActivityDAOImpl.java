package com.golfzone.social.activity;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.db.MariaDB;
import com.golfzone.social.db.dbCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAOImpl implements ActivityDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ActivityDAOImpl() {
        dbCon.DAOImpl();
    }

    @Override
    public int insertActivity(ActivityVO activityVO) {
        int flag;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("insertActivity: conn success");
            String sql = MariaDB.INSERT_ACTIVITY;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activityVO.getClubNum());
            pstmt.setString(2, activityVO.getActivityTitle());
            pstmt.setString(3, activityVO.getActivityDescription());
            flag = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return flag;
    }

    @Override
    public List<ActivityVO> selectAll() {
        List<ActivityVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

            String sql = MariaDB.ACTIVITY_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ActivityVO vo = new ActivityVO();
                vo.setActivityNum(rs.getInt("ACTIVITY_NUM"));
                vo.setActivityTitle(rs.getString("ACTIVITY_TITLE"));
                vo.setActivityDescription(rs.getString("ACTIVITY_DESCRIPTION"));
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
    public ActivityVO findByActivityNum(ActivityVO activityVO) {
        ActivityVO vo = new ActivityVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

            String sql = MariaDB.ACTIVITY_FIND_BY_ACTIVITY_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activityVO.getActivityNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setActivityNum(rs.getInt("ACTIVITY_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setActivityTitle(rs.getString("ACTIVITY_TITLE"));
                vo.setActivityDescription(rs.getString("ACTIVITY_DESCRIPTION"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        } 
        return vo;
    }

    @Override
    public List<ActivityVO> selectAllByClubNum(ClubVO clubVO) {
        List<ActivityVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

            String sql = MariaDB.ACTIVITY_FIND_BY_CLUB_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubVO.getClubNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ActivityVO vo = new ActivityVO();
                vo.setActivityNum(rs.getInt("ACTIVITY_NUM"));
                vo.setActivityTitle(rs.getString("ACTIVITY_TITLE"));
                vo.setActivityDescription(rs.getString("ACTIVITY_DESCRIPTION"));
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
    public ActivityVO countActivityMember(int ActivityNum) {
        ActivityVO vo = new ActivityVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("countActivityMember: conn success");
            String sql = MariaDB.COUNT_ACTIVITY_MEMBER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ActivityNum);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                vo.setActivityMemberCount(rs.getInt("COUNT"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        } 
        return vo;
    }
}

