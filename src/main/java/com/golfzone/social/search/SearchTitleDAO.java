package com.golfzone.social.search;

import com.golfzone.social.club.ClubVO;

import java.util.List;

public interface SearchTitleDAO {

    List<ClubVO> searchByClubTitle(SearchTitleVO searchTitleVO);


}
