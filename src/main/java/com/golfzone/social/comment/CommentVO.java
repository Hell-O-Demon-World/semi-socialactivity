package com.golfzone.social.comment;

public class CommentVO {
    private int commentNum;
    private int boardNum;
    private int clubNum;
    private String commentContext;
    private String commentWriter;

    public int getCommentNum() {
        return commentNum;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public int getClubNum() {
        return clubNum;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public void setClubNum(int clubNum) {
        this.clubNum = clubNum;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "commentNum=" + commentNum +
                ", boardNum=" + boardNum +
                ", clubNum=" + clubNum +
                ", commentContext='" + commentContext + '\'' +
                ", commentWriter='" + commentWriter + '\'' +
                '}';
    }
}
