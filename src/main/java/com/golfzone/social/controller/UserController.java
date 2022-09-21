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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserVO> userList = new ArrayList<>();
        UserDAO userDAO = new UserDAOImpl();
    }
}
