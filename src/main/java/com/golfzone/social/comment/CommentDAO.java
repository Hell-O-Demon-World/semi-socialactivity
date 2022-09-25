package com.golfzone.social.comment;

import java.util.List;

public interface CommentDAO {
    List<CommentVO> selectAll();
    int insertComment(CommentVO commentVO);
}
