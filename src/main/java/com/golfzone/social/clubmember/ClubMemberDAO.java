package com.golfzone.social.clubmember;

import com.golfzone.social.user.UserVO;

import java.util.List;

public interface ClubMemberDAO {
    int insertClubMember(ClubMemberVO clubMemberVO);
    ClubMemberVO findByUser(UserVO userVO);

    ClubMemberVO findByUserNumClubNum(ClubMemberVO clubMemberVO);
    List<ClubMemberVO> selectAllByUserNum(int userNum);
    List<ClubMemberVO> selectAll();

}
