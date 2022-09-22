package com.golfzone.social.controller;

import com.golfzone.social.user.UserDAO;
import com.golfzone.social.user.UserDAOImpl;
import com.golfzone.social.user.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class AuthController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAOImpl();
        UserVO userVO = new UserVO();
        userVO = userDAO.findByUser(req.getParameter("userID"));
        String resultPath = "";
        String resultMsg = "";

        //login
        if ((req.getParameter("userID").equals(userVO.getUserId())) && (req.getParameter("password").equals(userVO.getUserPw()))){
            //success
            resultPath = "/main.jsp";
            resultMsg = "로그인 성공.";
        }
        else{
            //fail
            resultMsg = "회원가입이 필요합니다.";
        }
        req.setAttribute("resultMsg" ,resultMsg);
        req.getRequestDispatcher(resultPath).forward(req, resp);
    }
}
