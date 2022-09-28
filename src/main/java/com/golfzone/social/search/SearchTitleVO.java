package com.golfzone.social.search;

public class SearchTitleVO {
    private String searchTitle;

    private int searchMinAge;

    private int searchMaxAge;

    private int searchMinScore;

    private int searchMaxScore;

    private String searchLocation;

    public String getSearchTitle() {
        return searchTitle;
    }

    public int getSearchMinAge() {
        return searchMinAge;
    }

    public int getSearchMaxAge() {
        return searchMaxAge;
    }

    public int getSearchMinScore() {
        return searchMinScore;
    }

    public int getSearchMaxScore() {
        return searchMaxScore;
    }

    public String getSearchLocation() {
        return searchLocation;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public void setSearchMinAge(int searchMinAge) {
        this.searchMinAge = searchMinAge;
    }

    public void setSearchMaxAge(int searchMaxAge) {
        this.searchMaxAge = searchMaxAge;
    }

    public void setSearchMinScore(int searchMinScore) {
        this.searchMinScore = searchMinScore;
    }

    public void setSearchMaxScore(int searchMaxScore) {
        this.searchMaxScore = searchMaxScore;
    }

    public void setSearchLocation(String searchLocation) {
        this.searchLocation = searchLocation;
    }

    @Override
    public String toString() {
        return "SearchTitleVO{" +
                "searchTitle='" + searchTitle + '\'' +
                ", searchMinAge=" + searchMinAge +
                ", searchMaxAge=" + searchMaxAge +
                ", searchMinScore=" + searchMinScore +
                ", searchMaxScore=" + searchMaxScore +
                ", searchLocation='" + searchLocation + '\'' +
                '}';
    }
}
