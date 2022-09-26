package com.golfzone.social.clubmember;

import java.util.List;

public interface ClubMemberDAO {
    int insertClubMember(ClubMemberVO clubMemberVO);

    ClubMemberVO findByClubNum(ClubMemberVO clubMemberVO);
    List<ClubMemberVO> selectAll();
}
