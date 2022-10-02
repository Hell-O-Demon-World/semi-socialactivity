package com.golfzone.social.comment;

import com.golfzone.social.board.BoardVO;
import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    private Connection conn;

    private PreparedStatement pstmt;

    private ResultSet rs;


    public CommentDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CommentVO> selectAll() {
        return null;
    }

    @Override
    public int insertComment(CommentVO commentVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.INSERT_COMMENT;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, commentVO.getBoardNum());
            pstmt.setInt(2, commentVO.getClubNum());
            pstmt.setString(3, commentVO.getCommentContext());
            pstmt.setString(4, commentVO.getCommentWriter());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
            return flag;
        }
    }

    @Override
    public int deleteComment(CommentVO commentVO) {

        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.DELETE_COMMENT;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, commentVO.getCommentNum());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
            return flag;
        }
    }

    @Override
    public List<CommentVO> selectAllByBoardNum(BoardVO boardVO) {
        List<CommentVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

            String sql = MariaDB.COMMENT_FIND_BY_BOARD_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardVO.getBoardNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CommentVO vo = new CommentVO();
                vo.setCommentNum(rs.getInt("COMMENT_NUM"));
                vo.setBoardNum(rs.getInt("BOARD_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setCommentContext(rs.getString("COMMENT_CONTENT"));
                vo.setCommentWriter(rs.getString("COMMENT_WRITER"));
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
