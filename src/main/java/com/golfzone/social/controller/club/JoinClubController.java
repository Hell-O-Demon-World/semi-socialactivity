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
        /* Setting request type UTF-8 */
        req.setCharacterEncoding("UTF-8");
        String clubResultMsg = "resultMsg";
        /* get params from club.jsp */
        int clubNum = Integer.parseInt(req.getParameter("clubNum")) + 1;
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        /* init */
        ClubDAO clubDAO = new ClubDAOImpl();
        ClubVO clubVO = new ClubVO();

        ClubMemberDAO clubMemberDAO = new ClubMemberDAOImpl();
        ClubMemberVO clubMemberVO = new ClubMemberVO();
        clubMemberVO.setRoleNum(3); // Meaning of 3 is a reguler memeber
        clubMemberVO.setClubNum(clubNum);
        clubMemberVO.setUserNum(userNum);
        if (clubMemberDAO.findByUserNumClubNum(clubMemberVO).getUserNum() == 0 && clubMemberDAO.findByUserNumClubNum(clubMemberVO).getClubNum() == 0){
            /* insert member to club member */
            clubMemberDAO.insertClubMember(clubMemberVO);
            clubResultMsg = "클럽 가입 완료!";
        }
        else {
            clubResultMsg = "이미 가입한 클럽입니다.";
        }
        req.setAttribute("resultMsg" ,clubResultMsg);
        req.setAttribute("userNum", userNum);
        req.getRequestDispatcher("/club.jsp").forward(req, resp);
    }
}
