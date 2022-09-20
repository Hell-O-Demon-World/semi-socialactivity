package com.golfzone.social.album;

public class AlbumVO {

    private int albumNum;
    private String imageName;
    private String imagePath;

    public int getAlbumNum() {
        return albumNum;
    }

    public void setAlbumNum(int albumNum) {
        this.albumNum = albumNum;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "AlbumVO{" +
                "albumNum=" + albumNum +
                ", imageName='" + imageName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
