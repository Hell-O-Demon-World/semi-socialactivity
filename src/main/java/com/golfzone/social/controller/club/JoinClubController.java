package com.golfzone.social.controller.club;

import com.golfzone.social.club.ClubDAO;
import com.golfzone.social.club.ClubDAOImpl;
import com.golfzone.social.club.ClubVO;
import com.golfzone.social.clubmember.ClubMemberDAO;
import com.golfzone.social.clubmember.ClubMemberDAOImpl;
import com.golfzone.social.clubmember.ClubMemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinClubController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String clubResultMsg = "resultMsg";
        String clubNum = req.getParameter("clubNum");
        ClubDAO clubDAO = new ClubDAOImpl();
        ClubVO clubVO = new ClubVO();
        System.out.println("클럽 넘버" + clubNum);
        ClubMemberDAO clubMemberDAO = new ClubMemberDAOImpl();
        ClubMemberVO clubMemberVO = new ClubMemberVO();
        clubMemberVO.setClubNum(Integer.parseInt(clubNum));

        if (clubMemberDAO.findByClubNum(clubMemberVO).getClubNum() != 0){
            clubResultMsg = "이미 가입한 클럽입니다.";
        }
        else {
            // role num, auth_num, club num, user num, tier name
            clubMemberVO.setRoleNum(2);
            clubMemberVO.setUserNum(3);
            clubMemberVO.setTierName("unrank");
            clubMemberDAO.insertClubMember(clubMemberVO);
            clubResultMsg = "클럽 가입 완료!";
        }
        req.setAttribute("resultMsg" ,clubResultMsg);
        req.getRequestDispatcher("/club.jsp").forward(req, resp);
    }
}
