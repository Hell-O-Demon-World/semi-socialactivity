package com.golfzone.social.controller.search;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchClubController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Setting request type UTF-8 */
        req.setCharacterEncoding("UTF-8");
        /* get params */
        String clubSearchResultMsg = "resultMsg";
        int userNum = 0;
        if (req.getParameter("userNum") != null) {
            userNum = Integer.parseInt(req.getParameter("userNum"));
        }
        String searchTitle = req.getParameter("clubName");
        String searchMinAge = req.getParameter("ageLow");
        String searchMaxAge = req.getParameter("ageHigh");
        String searchMinScore = req.getParameter("tierLow");
        String searchMaxScore = req.getParameter("tierHigh");
        String searchLocation = req.getParameter("location");

        /* 클럽 멤버에 추가 역할은 방장 */
        clubSearchResultMsg = "Search Complete";

        req.setAttribute("userNum", userNum);
        req.setAttribute("searchLocation", searchLocation);
        req.setAttribute("searchTitle", searchTitle);
        req.setAttribute("searchMinAge", searchMinAge);
        req.setAttribute("searchMaxAge", searchMaxAge);
        req.setAttribute("searchMinScore", searchMinScore);
        req.setAttribute("searchMaxScore", searchMaxScore);

        req.setAttribute("resultMsg", clubSearchResultMsg);
        req.getRequestDispatcher("/search/search.jsp").forward(req, resp);
    }
}
