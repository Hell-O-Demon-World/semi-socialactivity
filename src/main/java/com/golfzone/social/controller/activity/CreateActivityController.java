package com.golfzone.social.controller.activity;

import com.golfzone.social.activity.ActivityDAO;
import com.golfzone.social.activity.ActivityDAOImpl;
import com.golfzone.social.activity.ActivityVO;
import com.golfzone.social.activitymember.ActivityMemberDAO;
import com.golfzone.social.activitymember.ActivityMemberDAOImpl;
import com.golfzone.social.activitymember.ActivityMemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateActivityController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Setting request type UTF-8 */
        req.setCharacterEncoding("UTF-8");
        String activityResultMsg = "";
        // init get parameter
        String activityTitle = req.getParameter("activityTitle");
        String activitiyDescription = req.getParameter("activitiyDescription");
        int userNum = Integer.parseInt(req.getParameter("userNum"));
        int clubNum = Integer.parseInt(req.getParameter("clubNum"));

        ActivityDAO activityDAO = new ActivityDAOImpl();
        ActivityVO activityVO = new ActivityVO();
        activityVO.setActivityTitle(activityTitle);
        activityVO.setActivityDescription(activitiyDescription);
        activityVO.setClubNum(clubNum);
        // init VO, DAO
        activityDAO.insertActivity(activityVO);
        List<ActivityVO> activityVOS = activityDAO.selectAll();

        ActivityMemberDAO activityMemberDAO = new ActivityMemberDAOImpl();
        ActivityMemberVO activityMemberVO = new ActivityMemberVO();
        activityMemberVO.setActivityNum(activityVOS.get(activityVOS.size() - 1).getActivityNum());
        activityMemberVO.setUserNum(userNum);
        activityMemberVO.setClubNum(clubNum);

        activityMemberDAO.insertActivityMember(activityMemberVO);
        activityResultMsg = "액티비티가 생성되었습니다.";

        req.setAttribute("userNum", userNum);
        req.setAttribute("clubNum", clubNum);
        req.setAttribute("activityMemberResultMsg", activityResultMsg);

        req.getRequestDispatcher("/club/clubmain.jsp").forward(req, resp);
    }
}
