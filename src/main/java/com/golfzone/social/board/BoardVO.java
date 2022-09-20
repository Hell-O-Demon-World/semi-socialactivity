package com.golfzone.social.board;

public class BoardVO {

    private int boardNum;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;

    public int getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "boardNum=" + boardNum +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                '}';
    }
}
