package com.golfzone.social.activitymember;

import java.util.List;

public interface ActivityMemberDAO {

    int insertActivityMember(ActivityMemberVO activityMemberVO);

    List<ActivityMemberVO> selectAll();

    ActivityMemberVO findUserByActivityNum(ActivityMemberVO activityMemberVO);

}
