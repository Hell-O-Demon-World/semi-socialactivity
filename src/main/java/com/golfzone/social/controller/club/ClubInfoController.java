package com.golfzone.social.controller.club;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClubInfoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));
        req.setAttribute("clubNum", clubNum);
        req.setAttribute("userNum", userNum);
        req.getRequestDispatcher("/club/clubmain.jsp").forward(req, resp);
    }
}
