package com.golfzone.social.comment;

import com.golfzone.social.db.MariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    private Connection conn;

    private PreparedStatement pstmt;

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
            pstmt.setString(1, commentVO.getCommentContext());
            pstmt.setString(2, commentVO.getCommentWriter());
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
}
