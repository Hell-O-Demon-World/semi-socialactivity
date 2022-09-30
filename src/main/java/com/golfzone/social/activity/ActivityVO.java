package com.golfzone.social.activity;

public class ActivityVO {

    private int activityNum;
    private int clubNum;
    private int activityMemberCount;
    private String activityTitle;
    private String activityDescription;

    public int getActivityNum() {
        return activityNum;
    }

    public int getClubNum() {
        return clubNum;
    }

    public int getActivityMemberCount() {
        return activityMemberCount;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
    }

    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public void setActivityMemberCount(int activityMemberCount) {
        this.activityMemberCount = activityMemberCount;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    @Override
    public String toString() {
        return "ActivityVO{" +
                "activityNum=" + activityNum +
                ", clubNum=" + clubNum +
                ", activityMemberCount=" + activityMemberCount +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                '}';
    }
}
