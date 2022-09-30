package com.golfzone.social.board;

public class BoardVO {

    private int boardNum;

    private int clubNum;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;

    public int getBoardNum() {
        return boardNum;
    }

    public int getClubNum() {
        return clubNum;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "boardNum=" + boardNum +
                ", clubNum=" + clubNum +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                '}';
    }
}
