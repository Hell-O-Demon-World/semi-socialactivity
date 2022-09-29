package com.golfzone.social.controller.auth;

import com.golfzone.social.user.UserDAO;
import com.golfzone.social.user.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuitUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String quitResultMsg = "회원 탈퇴 실패";
        // init get parameter
        String userNum = req.getParameter("userNum");

        UserDAO userDAO = new UserDAOImpl();

        int flag = userDAO.deleteUserByUserNum(Integer.parseInt(userNum));
        if (flag == 1) {
            quitResultMsg = "회원 탈퇴 완료...";
        }
        System.out.println(quitResultMsg);
        req.setAttribute("quitResultMsg", quitResultMsg);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}