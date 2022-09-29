package com.golfzone.social.activity;

import com.golfzone.social.club.ClubVO;

import java.util.List;

public interface ActivityDAO {

    int insertActivity(ActivityVO activityVO);
    List<ActivityVO> selectAll();

    ActivityVO findByActivityNum(ActivityVO activityVO);

    List<ActivityVO> selectAllByClubNum(ClubVO clubVO);
}
