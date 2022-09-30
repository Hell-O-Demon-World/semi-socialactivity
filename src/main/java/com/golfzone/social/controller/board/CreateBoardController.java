package com.golfzone.social.controller.board;

import com.golfzone.social.board.BoardDAO;
import com.golfzone.social.board.BoardDAOImpl;
import com.golfzone.social.board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateBoardController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String boardResultMsg = "";
        // init get parameter
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        String boardTitle = req.getParameter("boardTitle");
        String boardContent = req.getParameter("boardContent");
        String boardWriter = req.getParameter("boardWriter");

        // Checking length, input nothing
        if ((boardTitle.length() > 11 || boardTitle.length() < 1)) {
            boardResultMsg = "제목의 길이는 1 ~ 10 자리 이내여야 합니다.";
        } else if ((boardContent.length() > 46 || boardContent.length() < 1)) {
            boardResultMsg = "내용의 길이는 1 ~ 46 자리 이내여야 합니다.";
        } else if (boardTitle.equals("") || boardContent.equals("") || boardWriter.equals("")) {
            boardResultMsg = "값을 입력해 주세요";
        } else {
            // init VO, DAO
            BoardDAO boardDAO = new BoardDAOImpl();
            BoardVO boardVO = new BoardVO();
            boardVO.setBoardTitle(boardTitle);
            boardVO.setBoardContent(boardContent);
            boardVO.setBoardWriter(boardWriter);
            boardDAO.insertBoard(boardVO);
            System.out.println(boardResultMsg);
        }

        req.setAttribute("userNum", userNum);
        req.setAttribute("clubNum", clubNum);
        req.setAttribute("boardResultMsg", boardResultMsg);
        req.getRequestDispatcher("/club/clubmain.jsp").forward(req, resp);
    }
}
