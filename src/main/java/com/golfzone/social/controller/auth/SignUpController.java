package com.golfzone.social.controller.auth;

import com.golfzone.social.user.UserDAO;
import com.golfzone.social.user.UserDAOImpl;
import com.golfzone.social.user.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resultMsg = "";
        // init get parameter
        String userId = req.getParameter("userID");
        String userPw = req.getParameter("userPW");
        String userLocation = req.getParameter("location2");
        String userState = req.getParameter("state2");
        String userAge = req.getParameter("age");
        String userName = req.getParameter("userName");
        String userSex = req.getParameter("userGender");
        String userScoreMsg = req.getParameter("tierName");
        System.out.println("userID: "+userId+"userPW: "+userPw);
        System.out.println(userId.length() + " " + userPw.length());
        // Checking length, input nothing
        if ((userId.length() > 10 && userId.length() < 5) || (userPw.length() > 10 && userPw.length() < 5)) {
            resultMsg = "길이는 5 ~ 10 자리 이내여야 합니다.";
        } else if (userId.equals("") || userPw.equals("") || userName.equals("") || userLocation.equals("") || userState.equals("") || userAge.equals("") || userScoreMsg.equals("") || userSex.equals("")) {
            resultMsg = "값을 입력해 주세요";
        } else {
            // init VO, DAO
            UserDAO userDAO = new UserDAOImpl();
            UserVO userVO = new UserVO();
            userVO.setUserId(userId);
            userVO.setUserPw(userPw);
            userVO.setUserLocation(userLocation + " " + userState);
            userVO.setUserAge(Integer.parseInt(userAge));
            userVO.setUserName(userName);
            userVO.setUserSex(Boolean.parseBoolean(userSex));
            if (userScoreMsg.equals(6)) {
                userVO.setUserTier("diamond");
            } else if (userScoreMsg.equals(7)) {
                userVO.setUserTier("platinum");
            } else if (userScoreMsg.equals(8)) {
                userVO.setUserTier("gold");
            } else if (userScoreMsg.equals(9)) {
                userVO.setUserTier("silver");
            } else if (userScoreMsg.equals(10)) {
                userVO.setUserTier("bronze");
            } else {
                userVO.setUserTier("unrank");
            }
            userVO.setUserScore(Integer.parseInt(userScoreMsg) * 10);

            UserVO tempUserVO = userDAO.findByUser(userId);
            // check id duplicate
            if (tempUserVO != null) {
                resultMsg = "이미 존재하는 아이디 입니다.";
            } else{
                userDAO.insertUser(userVO);
                resultMsg = "회원 가입 완료";
            }
        }
        req.setAttribute("resultMsg", resultMsg);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
