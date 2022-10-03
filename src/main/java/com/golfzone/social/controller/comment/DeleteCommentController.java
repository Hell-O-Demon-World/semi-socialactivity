package com.golfzone.social.controller.comment;

import com.golfzone.social.board.BoardDAO;
import com.golfzone.social.board.BoardDAOImpl;
import com.golfzone.social.board.BoardVO;
import com.golfzone.social.club.ClubVO;
import com.golfzone.social.comment.CommentDAO;
import com.golfzone.social.comment.CommentDAOImpl;
import com.golfzone.social.comment.CommentVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteCommentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String commentResultMsg = "댓글 삭제 실패";
        // init get parameter
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int boardNum = Integer.parseInt(req.getParameter("boardNum"));
        String commentNum = req.getParameter("commentNum");

        CommentVO commentVO = new CommentVO();
        CommentDAO commentDAO = new CommentDAOImpl();
        commentVO.setCommentNum(Integer.parseInt(commentNum));
        ClubVO clubVO = new ClubVO();
        clubVO.setClubNum(clubNum);

        int flag = commentDAO.deleteComment(commentVO);
        if (flag == 1) {
            commentResultMsg = "댓글삭제완료..";
        }
        req.setAttribute("commentResultMsg: ", commentResultMsg);
        req.setAttribute("userNum", userNum);
        req.setAttribute("clubNum", clubNum);
        req.setAttribute("boardNum",boardNum);
        req.getRequestDispatcher("/club/clubmain.jsp").forward(req, resp);

    }
}
