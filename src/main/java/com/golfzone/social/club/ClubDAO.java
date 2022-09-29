package com.golfzone.social.club;

import java.util.List;

public interface ClubDAO {
    int insertClub(ClubVO clubVO);
    ClubVO findByClubNum(ClubVO clubVO);
    ClubVO findByClubName(ClubVO clubVO);
    ClubVO findByClubPassword(ClubVO clubVO);
    List<ClubVO> selectAll();
}
