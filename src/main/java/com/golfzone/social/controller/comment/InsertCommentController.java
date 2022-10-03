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

public class InsertCommentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String commentResultMsg = "";
        // init get parameter
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int boardViewNum = Integer.parseInt(req.getParameter("boardViewNum"));
        String commentContext = req.getParameter("commentContext");
        String commentWriter = req.getParameter("commentWriter");

        ClubVO clubVO = new ClubVO();
        clubVO.setClubNum(clubNum);
        BoardDAO boardDAO = new BoardDAOImpl();
        List<BoardVO> boardVOS = boardDAO.selectAllByClubNum(clubVO);
        int boardNum = boardVOS.get(boardViewNum - 1).getBoardNum();
        // Checking length, input nothing
        if ((commentContext.length() > 46 || commentContext.length() < 1)) {
            commentResultMsg = "내용의 길이는 1 ~ 46 자리 이내여야 합니다.";
        } else if (commentContext.equals("") || commentWriter.equals("")) {
            commentResultMsg = "값을 입력해 주세요";
        } else {
            // init VO, DAO`
            CommentDAO commentDAO = new CommentDAOImpl();
            CommentVO commentVO = new CommentVO();
            commentVO.setBoardNum(boardNum);
            commentVO.setClubNum(clubNum);
            commentVO.setCommentContext(commentContext);
            commentVO.setCommentWriter(commentWriter);
            commentDAO.insertComment(commentVO);
        }
        req.setAttribute("commentResultMsg", commentResultMsg);
        req.setAttribute("userNum", userNum);
        req.setAttribute("clubNum", clubNum);
        req.setAttribute("boardNum",boardNum);
        req.getRequestDispatcher("/club/clubmain.jsp").forward(req, resp);
    }
}