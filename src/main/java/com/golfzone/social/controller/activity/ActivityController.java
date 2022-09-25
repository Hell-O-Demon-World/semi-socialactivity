package com.golfzone.social.controller.activity;

import com.golfzone.social.activity.ActivityDAO;
import com.golfzone.social.activity.ActivityDAOImpl;
import com.golfzone.social.activity.ActivityVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActivityController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String activityResultMsg = "";
        // init get parameter
        String activityTitle = req.getParameter("activityTitle");
        String activityDescription = req.getParameter("activityDescription");

        // Checking length, input nothing
        if ((activityTitle.length() > 22 || activityTitle.length() < 1)) {
            activityResultMsg = "제목의 길이는 1 ~ 10 자리 이내여야 합니다.";
        } else if ((activityDescription.length() > 46 || activityDescription.length() < 1)) {
            activityResultMsg = "내용의 길이는 1 ~ 46 자리 이내여야 합니다.";
        } else if (activityTitle.equals("") || activityDescription.equals("")) {
            activityResultMsg = "값을 입력해 주세요";
        } else {
            // init VO, DAO
            ActivityDAO activityDAO = new ActivityDAOImpl();
            ActivityVO activityVO = new ActivityVO();
            activityVO.setActivityTitle(activityTitle);
            activityVO.setActivityDescription(activityDescription);
            activityDAO.insertActivity(activityVO);
            System.out.println(activityResultMsg);
        }
        req.setAttribute("activityResultMsg", activityResultMsg);
        req.getRequestDispatcher("").forward(req, resp);
    }
}