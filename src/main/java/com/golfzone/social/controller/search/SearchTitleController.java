package com.golfzone.social.controller.search;

import com.golfzone.social.search.SearchTitleDAO;
import com.golfzone.social.search.SearchTitleDAOImpl;
import com.golfzone.social.search.SearchTitleVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchTitleController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String clubSearchResultMsg = "resultMsg";
        String searchTitle = req.getParameter("searchTitle");
        /*
        int searchMinAge = Integer.parseInt(req.getParameter("searchMinAge"));
        int searchMaxAge = Integer.parseInt(req.getParameter("searchMaxAge"));
        int searchMinScore = Integer.parseInt(req.getParameter("searchMinScore"));
        int searchMaxScore = Integer.parseInt(req.getParameter("searchMaxScore"));
        String searchLocation = req.getParameter("searchLocation");

        if (searchMinAge != null)
        if (searchMaxAge != null)
        if (searchMinScore != null)
        if (searchMaxScore != null)
        if (searchLocation != null)


        */

        SearchTitleDAO searchTitleDAO = new SearchTitleDAOImpl();
        SearchTitleVO searchTitleVO = new SearchTitleVO();
        searchTitleVO.setSearchTitle(searchTitle);

        /* 클럽 멤버에 추가 역할은 방장 */
        clubSearchResultMsg = "검색스완료!";
        System.out.println(searchTitleDAO.searchByClubTitle(searchTitleVO));
        req.setAttribute("resultMsg", clubSearchResultMsg);
        req.getRequestDispatcher("/search.jsp").forward(req, resp);

    }
}




