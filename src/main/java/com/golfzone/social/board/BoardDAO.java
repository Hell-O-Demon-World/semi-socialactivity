package com.golfzone.social.board;

import java.util.List;

public interface BoardDAO {
    List<BoardVO> selectAll();
    int insertBoard(BoardVO boardVO);

    int deleteBoard(int boardNum);
}
