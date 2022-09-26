package com.golfzone.social.activity;

import java.util.List;

public interface ActivityDAO {

    int insertActivity(ActivityVO activityVO);
    List<ActivityVO> selectAll();
}
