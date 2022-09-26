package com.golfzone.social.clubmember;

public class ClubMemberVO {
    private int memberNum;
    private int roleNum;
    private int authNum;
    private int clubNum;
    private int userNum;
    private String tierName;

    @Override
    public String toString() {
        return "ClubMemberVO{" +
                "memberNum=" + memberNum +
                ", roleNum=" + roleNum +
                ", authNum=" + authNum +
                ", clubNum=" + clubNum +
                ", userNum=" + userNum +
                ", tierName='" + tierName + '\'' +
                '}';
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int roleNum) {
        this.roleNum = roleNum;
    }

    public int getAuthNum() {
        return authNum;
    }

    public void setAuthNum(int authNum) {
        this.authNum = authNum;
    }

    public int getClubNum() {
        return clubNum;
    }

    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }
}
