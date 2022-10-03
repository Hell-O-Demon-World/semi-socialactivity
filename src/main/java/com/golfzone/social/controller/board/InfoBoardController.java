package com.golfzone.social.controller.board;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InfoBoardController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String boardResultMsg = "";
        // init get parameter
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int boardNum = Integer.parseInt(req.getParameter("boardNum"));
        req.setAttribute("userNum", userNum);
        req.setAttribute("clubNum", clubNum);
        req.setAttribute("boardNum", boardNum);
        req.setAttribute("boardResultMsg: ", boardResultMsg);
        req.getRequestDispatcher("/club/clubmain.jsp").forward(req, resp);
    }
}
