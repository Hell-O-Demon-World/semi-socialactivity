package com.golfzone.social.search;

import com.golfzone.social.club.ClubVO;

import java.util.List;

public interface SearchClubDAO {

    List<ClubVO> searchAllClub(SearchClubVO searchClubVO);

    List<ClubVO> searchByCondition(SearchClubVO searchClubVO);


}
