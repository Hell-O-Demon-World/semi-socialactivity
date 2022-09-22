package com.golfzone.social.user;

public class UserVO {

    private int userNum;
    private String userName;
    private String userId;
    private String userPw;
    private String userLocation;
    private int userAge;
    private boolean userSex;
    private String userTier;
    private int userScore;

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean isUserSex() {
        return userSex;
    }

    public void setUserSex(boolean userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userNum=" + userNum +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userLocation='" + userLocation + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                ", userTier='" + userTier + '\'' +
                ", userScore=" + userScore +
                '}';
    }
}
