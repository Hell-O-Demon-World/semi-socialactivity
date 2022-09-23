package com.golfzone.social.club;

public interface ClubDAO {
    int insertClub(ClubVO clubVO);

    ClubVO findByClubName(ClubVO clubVO);
}
