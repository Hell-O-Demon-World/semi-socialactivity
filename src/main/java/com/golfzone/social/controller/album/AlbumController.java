package com.golfzone.social.controller.album;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlbumController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String AlbumInsertResultMsg = "";

        req.setAttribute("AlbumInsertResultMsg", AlbumInsertResultMsg);
        req.getRequestDispatcher("/album/album.jsp").forward(req, resp);
    }
}