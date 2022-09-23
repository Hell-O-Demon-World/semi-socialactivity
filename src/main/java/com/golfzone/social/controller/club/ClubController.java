package com.golfzone.social.controller.club;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClubController extends HttpServlet {
    // create new club controller

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clubResultMsg = "";
        req.setAttribute("resultMsg" ,clubResultMsg);
        req.getRequestDispatcher(clubResultMsg).forward(req, resp);
    }
}
