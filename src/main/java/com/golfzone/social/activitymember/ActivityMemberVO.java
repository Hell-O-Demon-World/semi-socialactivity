package com.golfzone.social.activitymember;

public class ActivityMemberVO {
    private int activityMemberNum;
    private int activityNum;
    private int clubNum;
    private int userNum;

    public int getActivityMemberNum() {
        return activityMemberNum;
    }

    public int getActivityNum() {
        return activityNum;
    }

    public int getClubNum() {
        return clubNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setActivityMemberNum(int activityMemberNum) {
        this.activityMemberNum = activityMemberNum;
    }

    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
    }

    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    @Override
    public String toString() {
        return "ActivityMemberVO{" +
                "activityMemberNum=" + activityMemberNum +
                ", activityNum=" + activityNum +
                ", clubNum=" + clubNum +
                ", userNum=" + userNum +
                '}';
    }
}
