package com.golfzone.social.activitymember;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.user.UserVO;

import java.util.List;

public interface ActivityMemberDAO {

    List<ActivityMemberVO> selectAll();

    ActivityMemberVO findUserByActivityNum(ActivityMemberVO activityMemberVO);
    ActivityMemberVO findClubNumByActivityNum(ActivityMemberVO activityMemberVO);
    ActivityMemberVO findByUser(UserVO userVO);
    int insertActivityMember(ActivityMemberVO activityMemberVO);

    int deleteActivityMember(ActivityMemberVO activityMemberVO);

    List<ActivityMemberVO> selectAllByUserNum(UserVO userVO);

    List<ActivityMemberVO> selectAllByClubNum(ClubVO clubVO);
}
