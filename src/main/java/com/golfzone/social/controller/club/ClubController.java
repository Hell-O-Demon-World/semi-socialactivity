package com.golfzone.social.controller.club;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClubController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Setting request type UTF-8 */
        req.setCharacterEncoding("UTF-8");
        /* get params from club.jsp */
        int userNum = Integer.parseInt(req.getParameter("userNum"));

        req.setAttribute("userNum", userNum);
        req.getRequestDispatcher("/club.jsp").forward(req, resp);
    }
}
