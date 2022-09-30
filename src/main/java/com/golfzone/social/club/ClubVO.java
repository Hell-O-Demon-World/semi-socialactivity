package com.golfzone.social.club;

public class ClubVO {

    private int clubNum;
    private String clubName;
    private int clubMemberCount;
    private int clubMaxCount;
    private int clubAge;
    private String clubLocation;
    private String clubTier;
    private String clubDescription;
    private String clubEmblemPath;
    private int clubSex;
    private String clubPw;

    public int getClubNum() {
        return clubNum;
    }

    public String getClubName() {
        return clubName;
    }

    public int getClubMemberCount() {
        return clubMemberCount;
    }

    public int getClubMaxCount() {
        return clubMaxCount;
    }

    public int getClubAge() {
        return clubAge;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public String getClubTier() {
        return clubTier;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public String getClubEmblemPath() {
        return clubEmblemPath;
    }

    public int getClubSex() {
        return clubSex;
    }

    public String getClubPw() {
        return clubPw;
    }

    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubMemberCount(int clubMemberCount) {
        this.clubMemberCount = clubMemberCount;
    }

    public void setClubMaxCount(int clubMaxCount) {
        this.clubMaxCount = clubMaxCount;
    }

    public void setClubAge(int clubAge) {
        this.clubAge = clubAge;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public void setClubTier(String clubTier) {
        this.clubTier = clubTier;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

    public void setClubEmblemPath(String clubEmblemPath) {
        this.clubEmblemPath = clubEmblemPath;
    }

    public void setClubSex(int clubSex) {
        this.clubSex = clubSex;
    }

    public void setClubPw(String clubPw) {
        this.clubPw = clubPw;
    }

    @Override
    public String toString() {
        return "ClubVO{" +
                "clubNum=" + clubNum +
                ", clubName='" + clubName + '\'' +
                ", clubMemberCount=" + clubMemberCount +
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
}
