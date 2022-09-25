package com.golfzone.social.comment;

public class CommentVO {
    private int commentNum;
    private String commentContext;
    private String commentWriter;

    public int getCommentNum() {
        return commentNum;
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
                ", commentContext='" + commentContext + '\'' +
                ", commentWriter='" + commentWriter + '\'' +
                '}';
    }
}
