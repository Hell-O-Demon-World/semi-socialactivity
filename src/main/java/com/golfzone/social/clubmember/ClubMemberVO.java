package com.golfzone.social.clubmember;

public class ClubMemberVO {
    private int memberNum;
    private int roleNum;
    private int clubNum;
    private int userNum;

    @Override
    public String toString() {
        return "ClubMemberVO{" +
                "memberNum=" + memberNum +
                ", roleNum=" + roleNum +
                ", clubNum=" + clubNum +
                ", userNum=" + userNum + '\'' +
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

}
