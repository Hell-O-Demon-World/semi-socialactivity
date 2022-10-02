package com.golfzone.social.comment;

import com.golfzone.social.board.BoardVO;

import java.util.List;

public interface CommentDAO {
    List<CommentVO> selectAll();
    int insertComment(CommentVO commentVO);

    int deleteComment(CommentVO commentVO);

    List<CommentVO> selectAllByBoardNum(BoardVO boardVO);
}
