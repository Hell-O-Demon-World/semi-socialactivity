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
        int userNum = -1;
        if (req.getParameter("userNum") != null) {
            userNum = Integer.parseInt(req.getParameter("userNum"));
        }
        String searchTitle = req.getParameter("clubName");
        String searchMinAge = req.getParameter("ageLow");
        String searchMaxAge = req.getParameter("ageHigh");
        String searchMinScore = req.getParameter("tierLow");
        String searchMaxScore = req.getParameter("tierHigh");
        String searchLocation = req.getParameter("location");

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
        if (searchClubVO.getSearchTitle().equals("") &&
                searchClubVO.getSearchMinAge().equals("0") &&
                searchClubVO.getSearchMaxAge().equals("0") &&
                searchClubVO.getSearchMinScore().equals("0") &&
                searchClubVO.getSearchMaxScore().equals("0") &&
                searchClubVO.getSearchLocation().equals("")) {
            for (ClubVO vo : searchClubDAO.searchAllClub(searchClubVO)) {
                System.out.println(vo);
            }
        } else {
            for (ClubVO vo : searchClubDAO.searchByCondition(searchClubVO)) {
                System.out.println(vo);
            }
        }
        req.setAttribute("userNum", userNum);
        req.setAttribute("resultMsg", clubSearchResultMsg);
        req.getRequestDispatcher("/search/search.jsp").forward(req, resp);

    }
}




