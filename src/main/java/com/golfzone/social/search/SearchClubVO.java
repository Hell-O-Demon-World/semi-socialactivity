package com.golfzone.social.search;

public class SearchClubVO {
    private String searchTitle;

    private String searchMinAge;

    private String searchMaxAge;

    private String searchMinScore;

    private String searchMaxScore;

    private String searchLocation;

    public String getSearchTitle() {
        return searchTitle;
    }

    public String getSearchMinAge() {
        return searchMinAge;
    }

    public String getSearchMaxAge() {
        return searchMaxAge;
    }

    public String getSearchMinScore() {
        return searchMinScore;
    }

    public String getSearchMaxScore() {
        return searchMaxScore;
    }

    public String getSearchLocation() {
        return searchLocation;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public void setSearchMinAge(String searchMinAge) {
        this.searchMinAge = searchMinAge;
    }

    public void setSearchMaxAge(String searchMaxAge) {
        this.searchMaxAge = searchMaxAge;
    }

    public void setSearchMinScore(String searchMinScore) {
        this.searchMinScore = searchMinScore;
    }

    public void setSearchMaxScore(String searchMaxScore) {
        this.searchMaxScore = searchMaxScore;
    }

    public void setSearchLocation(String searchLocation) {
        this.searchLocation = searchLocation;
    }

    @Override
    public String toString() {
        return "SearchClubVO{" +
                "searchTitle='" + searchTitle + '\'' +
                ", searchMinAge=" + searchMinAge +
                ", searchMaxAge=" + searchMaxAge +
                ", searchMinScore='" + searchMinScore + '\'' +
                ", searchMaxScore='" + searchMaxScore + '\'' +
                ", searchLocation='" + searchLocation + '\'' +
                '}';
    }
}
