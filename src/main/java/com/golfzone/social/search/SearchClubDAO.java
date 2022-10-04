package com.golfzone.social.search;

import com.golfzone.social.club.ClubVO;

import java.util.List;

public interface SearchClubDAO {

    List<ClubVO> searchByCondition(SearchClubVO searchClubVO);


}
