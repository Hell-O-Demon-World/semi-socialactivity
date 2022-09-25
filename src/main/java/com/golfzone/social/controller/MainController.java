package com.golfzone.social.controller;

import com.golfzone.social.club.ClubDAO;
import com.golfzone.social.club.ClubDAOImpl;
import com.golfzone.social.club.ClubVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ClubDAO clubDAO = new ClubDAOImpl();
//        List<ClubVO> clubVOS = new ArrayList<>();
//        clubVOS = clubDAO.selectAll();
//        req.setAttribute("clubVOS", clubVOS);
    }
}
