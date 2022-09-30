package com.golfzone.social.board;

import com.golfzone.social.club.ClubVO;

import java.util.List;

public interface BoardDAO {
    List<BoardVO> selectAll();
    int insertBoard(BoardVO boardVO);
    List<BoardVO> selectAllByClubNum(ClubVO clubVO);
}
