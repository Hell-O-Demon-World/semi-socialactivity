package com.golfzone.social.controller.activity;

import com.golfzone.social.activitymember.ActivityMemberDAO;
import com.golfzone.social.activitymember.ActivityMemberDAOImpl;
import com.golfzone.social.activitymember.ActivityMemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuitActivityController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Setting request type UTF-8 */
        req.setCharacterEncoding("UTF-8");
        String activityMemberResultMsg = "";
        // init get parameter
        int activityMemberNum = Integer.parseInt(req.getParameter("activityMemberNum"));
        int activityNum = Integer.parseInt(req.getParameter("activityNum"));
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));

        ActivityMemberVO activityMemberVO = new ActivityMemberVO();
        ActivityMemberDAO activityMemberDAO = new ActivityMemberDAOImpl();

        activityMemberVO.setActivityMemberNum(activityMemberNum);
        activityMemberVO.setActivityNum(activityNum);
        activityMemberVO.setClubNum(clubNum);
        activityMemberVO.setUserNum(userNum);

        // Checking Number, input nothing
        if (activityMemberDAO.findUserByActivityNum(activityMemberVO).getActivityNum() == 0) {
            activityMemberResultMsg = "가입하지 않은 액티비티입니다.";
        } else {
            // init VO, DAO
            activityMemberDAO.deleteActivityMember(activityMemberVO);
            activityMemberResultMsg = "탈퇴완료...";
        }
        req.setAttribute("userNum", userNum);
        req.setAttribute("activityMemberResultMsg", activityMemberResultMsg);
        req.getRequestDispatcher("/mypage/mypage.jsp").forward(req, resp);
    }
}
