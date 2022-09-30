package com.golfzone.social.board;

import com.golfzone.social.activity.ActivityVO;
import com.golfzone.social.club.ClubVO;
import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BoardDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BoardVO> selectAll() {
        return null;
    }

    @Override
    public int insertBoard(BoardVO boardVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("insertBoard: conn success");
            String sql = MariaDB.INSERT_BOARD;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardVO.getBoardTitle());
            pstmt.setString(2, boardVO.getBoardContent());
            pstmt.setString(3, boardVO.getBoardWriter());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
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
    public List<BoardVO> selectAllByClubNum(ClubVO clubVO) {
        List<BoardVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

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
    public int deleteBoard(int boardNum) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("deleteBoard: conn success");
            String sql = MariaDB.DELETE_BOARD;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
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
        return flag;
    }
    }
}
