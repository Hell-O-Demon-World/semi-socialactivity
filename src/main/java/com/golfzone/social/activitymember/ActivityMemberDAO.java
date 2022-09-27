package com.golfzone.social.activitymember;

import java.util.List;

public interface ActivityMemberDAO {

    List<ActivityMemberVO> selectAll();

    ActivityMemberVO findUserByActivityNum(ActivityMemberVO activityMemberVO);

    int insertActivityMember(ActivityMemberVO activityMemberVO);

    int deleteActivityMember(ActivityMemberVO activityMemberVO);
    //주석1
}
