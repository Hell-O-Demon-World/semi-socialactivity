package com.golfzone.social.activity;

public class ActivityVO {

    private int activityNum;
    private String activityTitle;
    private String activityDescription;

    public int getActivityNum() {
        return activityNum;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public String getActivityDiscription() {
        return activityDescription;
    }

    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public void setActivityDiscription(String activityDiscription) {
        this.activityDescription = activityDiscription;
    }

    @Override
    public String toString() {
        return "ActivityVO{" +
                "activityNum=" + activityNum +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityDiscription='" + activityDescription + '\'' +
                '}';
    }
}
