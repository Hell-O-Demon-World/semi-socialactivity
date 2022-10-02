package com.golfzone.social.controller.comment;

import com.golfzone.social.board.BoardDAO;
import com.golfzone.social.board.BoardDAOImpl;
import com.golfzone.social.board.BoardVO;
import com.golfzone.social.club.ClubVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class InfoCommentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String commentResultMsg = "";
        // init get parameter
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int boardViewNum = Integer.parseInt(req.getParameter("boardViewNum"));

        ClubVO clubVO = new ClubVO();
        clubVO.setClubNum(clubNum);
        BoardDAO boardDAO = new BoardDAOImpl();
        List<BoardVO> boardVOS = boardDAO.selectAllByClubNum(clubVO);

        int boardNum = boardVOS.get(boardViewNum - 1).getBoardNum();
        req.setAttribute("commentResultMsg", commentResultMsg);
        req.setAttribute("userNum", userNum);
        req.setAttribute("clubNum", clubNum);
        req.setAttribute("boardNum",boardNum);
        req.getRequestDispatcher("/club/clubmain.jsp").forward(req, resp);
    }
}
