package com.golfzone.social.controller.club;

import com.golfzone.social.club.ClubDAO;
import com.golfzone.social.club.ClubDAOImpl;
import com.golfzone.social.club.ClubVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateClubController extends HttpServlet {
    // create new club controller

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String clubResultMsg = "resultMsg";
        int userNum = Integer.parseInt(req.getParameter("userNum"));

        String clubName = req.getParameter("clubName");
        String clubMaxCount = req.getParameter("maxCount");
        String clubAge = req.getParameter("age");
        String clubLocation = req.getParameter("location");
        String clubTier = req.getParameter("tier");
        String clubDescription = req.getParameter("description");
        String clubEmblemPath = req.getParameter("emblemPath");
        String clubSex = req.getParameter("sex");
        String clubPw = req.getParameter("pw");

        ClubDAO clubDAO = new ClubDAOImpl();
        ClubVO clubVO = new ClubVO();
        clubVO.setClubName(clubName);
        clubVO.setClubMaxCount(Integer.parseInt(clubMaxCount));
        clubVO.setClubAge(Integer.parseInt(clubAge));
        clubVO.setClubLocation(clubLocation);

        if (Integer.parseInt(clubTier) == 6) {
            clubVO.setClubTier("diamond");
        } else if (Integer.parseInt(clubTier) == 7) {
            clubVO.setClubTier("platinum");
        } else if (Integer.parseInt(clubTier) == 8) {
            clubVO.setClubTier("gold");
        } else if (Integer.parseInt(clubTier) == 9) {
            clubVO.setClubTier("silver");
        } else if (Integer.parseInt(clubTier) == 10) {
            clubVO.setClubTier("bronze");
        } else {
            clubVO.setClubTier("unrank");
        }
        clubVO.setClubDescription(clubDescription);
        clubVO.setClubEmblemPath(clubEmblemPath);

        if (clubSex == null) {
            clubSex = String.valueOf(2);
        }

        clubVO.setClubSex(Integer.parseInt(clubSex));
        clubVO.setClubPw(clubPw);
        if (clubDAO.findByClubName(clubVO).getClubName() != null) {
            if (clubDAO.findByClubName(clubVO).getClubName().equals(clubVO.getClubName())) {
                clubResultMsg = "이미 존재하는 클럽명입니다.";
            }
        } else {
            if (clubPw == null) {
                clubVO.setClubPw("");
            }
            clubDAO.insertClub(clubVO);
            /* 클럽 멤버에 추가 역할은 방장 */
            clubResultMsg = "클럽 생성 완료!";
        }
        System.out.println(clubResultMsg);
        req.setAttribute("resultMsg", clubResultMsg);
        req.setAttribute("userNum: ", userNum);
        req.getRequestDispatcher("/club.jsp").forward(req, resp);
    }
}
