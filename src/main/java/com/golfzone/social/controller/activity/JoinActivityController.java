package com.golfzone.social.controller.activity;

import com.golfzone.social.activitymember.ActivityMemberDAO;
import com.golfzone.social.activitymember.ActivityMemberDAOImpl;
import com.golfzone.social.activitymember.ActivityMemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinActivityController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String activityMemberResultMsg = "";
        // init get parameter
        int activityNum = Integer.parseInt(req.getParameter("activityNum"));
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));
        ActivityMemberVO activityMemberVO = new ActivityMemberVO();
        ActivityMemberDAO activityMemberDAO = new ActivityMemberDAOImpl();

        activityMemberVO.setActivityNum(activityNum);
        activityMemberVO.setUserNum(userNum);
        activityMemberVO.setClubNum(clubNum);

        // Checking Number, input nothing
        if (activityMemberDAO.findUserByActivityNum(activityMemberVO).getActivityNum() == 0 && activityMemberDAO.findUserByActivityNum(activityMemberVO).getUserNum() == 0) {
            // init VO, DAO
            activityMemberDAO = new ActivityMemberDAOImpl();
            activityMemberVO = new ActivityMemberVO();
            activityMemberVO.setActivityNum(activityNum);
            activityMemberVO.setClubNum(clubNum);
            activityMemberVO.setUserNum(userNum);
            activityMemberDAO.insertActivityMember(activityMemberVO);
            activityMemberResultMsg = "Join Success";
        } else {
            activityMemberResultMsg = "Already joined";
        }
        req.setAttribute("userNum", userNum);
        req.setAttribute("activityMemberResultMsg", activityMemberResultMsg);
        req.getRequestDispatcher("/club.jsp").forward(req, resp);
    }
}
