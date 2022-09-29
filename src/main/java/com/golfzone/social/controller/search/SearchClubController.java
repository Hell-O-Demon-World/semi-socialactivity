package com.golfzone.social.controller.search;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.search.SearchClubDAO;
import com.golfzone.social.search.SearchClubDAOImpl;
import com.golfzone.social.search.SearchClubVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchClubController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String clubSearchResultMsg = "resultMsg";
        String searchTitle = req.getParameter("searchTitle");
        String searchMinAge = req.getParameter("searchMinAge");
        String searchMaxAge = req.getParameter("searchMaxAge");
        String searchMinScore = req.getParameter("searchMinScore");
        String searchMaxScore = req.getParameter("searchMaxScore");
        String searchLocation = req.getParameter("searchLocation");

        SearchClubDAO searchClubDAO = new SearchClubDAOImpl();
        SearchClubVO searchClubVO = new SearchClubVO();

        if (searchTitle != null) {
            searchClubVO.setSearchTitle(searchTitle);
        }

        if (searchMinAge != null) {
            searchClubVO.setSearchMinAge(searchMinAge);
        }

        if (searchMaxAge != null) {
            searchClubVO.setSearchMaxAge(searchMaxAge);
        }

        if (searchMinScore != null) {
            searchClubVO.setSearchMinScore(searchMinScore);
        }

        if (searchMaxScore != null) {
            searchClubVO.setSearchMaxScore(searchMaxScore);
        }

        if (searchLocation != null) {
            searchClubVO.setSearchLocation(searchLocation);
        }

        /* 클럽 멤버에 추가 역할은 방장 */
        clubSearchResultMsg = "검색스완료!";
        System.out.println(searchClubVO);
        if (searchClubVO.getSearchTitle() == null &&
                searchClubVO.getSearchMinAge() == null &&
                searchClubVO.getSearchMaxAge() == null &&
                searchClubVO.getSearchMinScore() == null &&
                searchClubVO.getSearchMaxScore() == null &&
                searchClubVO.getSearchLocation() == null) {
            for (ClubVO vo:searchClubDAO.searchAllClub(searchClubVO)) {
                System.out.println(vo);
            }
        } else {
            for (ClubVO vo:searchClubDAO.searchByCondition(searchClubVO)) {
                System.out.println(vo);
            }
        }
        req.setAttribute("resultMsg", clubSearchResultMsg);
        req.getRequestDispatcher("/search.jsp").forward(req, resp);

    }
}




