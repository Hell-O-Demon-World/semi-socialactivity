package com.golfzone.social.club;

public class ClubVO {

    private int clubNum;
    private String clubName;
    private int clubMaxCount;
    private int clubAge;
    private String clubLocation;
    private String clubTier;
    private String clubDescription;
    private String clubEmblemPath;
    private int clubSex;
    private String clubPw;

    @Override
    public String toString() {
        return "ClubVO{" +
                "clubNum=" + clubNum +
                ", clubName='" + clubName + '\'' +
                ", clubMaxCount=" + clubMaxCount +
                ", clubAge=" + clubAge +
                ", clubLocation='" + clubLocation + '\'' +
                ", clubTier='" + clubTier + '\'' +
                ", clubDescription='" + clubDescription + '\'' +
                ", clubEmblemPath='" + clubEmblemPath + '\'' +
                ", clubSex=" + clubSex +
                ", clubPw='" + clubPw + '\'' +
                '}';
    }

    public int getClubNum() {
        return clubNum;
    }

    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getClubMaxCount() {
        return clubMaxCount;
    }

    public void setClubMaxCount(int clubMaxCount) {
        this.clubMaxCount = clubMaxCount;
    }

    public int getClubAge() {
        return clubAge;
    }

    public void setClubAge(int clubAge) {
        this.clubAge = clubAge;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public String getClubTier() {
        return clubTier;
    }

    public void setClubTier(String clubTier) {
        this.clubTier = clubTier;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

    public String getClubEmblemPath() {
        return clubEmblemPath;
    }

    public void setClubEmblemPath(String clubEmblemPath) {
        this.clubEmblemPath = clubEmblemPath;
    }

    public int getClubSex() {
        return clubSex;
    }

    public void setClubSex(int clubSex) {
        this.clubSex = clubSex;
    }

    public String getClubPw() {
        return clubPw;
    }

    public void setClubPw(String clubPw) {
        this.clubPw = clubPw;
    }
}
