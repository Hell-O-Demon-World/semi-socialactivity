package com.golfzone.social.user;

import com.golfzone.social.db.MariaDB;
import com.golfzone.social.db.dbCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public UserDAOImpl() {
        dbCon.DAOImpl();
    }

    @Override
    public List<UserVO> selectAll() {
        List<UserVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vos;
    }

    @Override
    public int insertUser(UserVO userVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return flag;
    }

    @Override
    public int deleteUserByUserNum(int userNum) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.DELETE_USER_FROM_USER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNum);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return flag;
    }

    @Override
    public UserVO findByUserNum(int userNum) {
        UserVO vo = new UserVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.USER_FIND_BY_USER_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNum);
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }

    @Override
    public UserVO findByUser(String userId) {
        UserVO vo = new UserVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.USER_FIND_BY_USER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }
}
