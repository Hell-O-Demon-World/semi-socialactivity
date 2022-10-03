package com.golfzone.social.board;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.db.MariaDB;
import com.golfzone.social.db.dbCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BoardDAOImpl() {
        dbCon.DAOImpl();
    }

    @Override
    public List<BoardVO> selectAll() {
        return null;
    }

    @Override
    public int insertBoard(BoardVO boardVO) {
        int flag;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.INSERT_BOARD;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardVO.getClubNum());
            pstmt.setString(2, boardVO.getBoardTitle());
            pstmt.setString(3, boardVO.getBoardContent());
            pstmt.setString(4, boardVO.getBoardWriter());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        } 
        return flag;
    }

    @Override
    public List<BoardVO> selectAllByClubNum(ClubVO clubVO) {
        List<BoardVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.BOARD_FIND_BY_CLUB_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubVO.getClubNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoardNum(rs.getInt("BOARD_NUM"));
                vo.setBoardTitle(rs.getString("BOARD_TITLE"));
                vo.setBoardContent(rs.getString("BOARD_CONTENT"));
                vo.setBoardWriter(rs.getString("BOARD_WRITER"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vos;
    }

    public int deleteBoard(int boardNum) {
        int flag;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.DELETE_BOARD;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return flag;
    }

    @Override
    public BoardVO findByBoardNum(BoardVO boardVO) {
        BoardVO vo = new BoardVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.BOARD_FIND_BY_BOARD_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardVO.getBoardNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setBoardNum(rs.getInt("BOARD_NUM"));
                vo.setBoardTitle(rs.getString("BOARD_TITLE"));
                vo.setBoardContent(rs.getString("BOARD_CONTENT"));
                vo.setBoardWriter(rs.getString("BOARD_WRITER"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vo;
    }
}
