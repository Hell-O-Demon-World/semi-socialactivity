package com.golfzone.social.controller.album;

import com.golfzone.social.album.AlbumDAO;
import com.golfzone.social.album.AlbumDAOImpl;
import com.golfzone.social.album.AlbumVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlbumController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String AlbumResultMsg = "";
        // init get parameter
        String albumNum = req.getParameter("albumNum");
        String imageName = req.getParameter("imageName");
        String imagePath = req.getParameter("imagePath");

        // Checking length, input nothing
        if (imageName.equals("") || imagePath.equals("")) {
            AlbumResultMsg = "값을 입력해 주세요";
        } else {
            // init VO, DAO
            AlbumDAO albumDAO = new AlbumDAOImpl();
            AlbumVO albumVO = new AlbumVO();
            albumVO.setImageName(imageName);
            albumVO.setImagePath(imagePath);
            albumDAO.insertAlbum(albumVO);
            System.out.println(AlbumResultMsg);
        }
        req.setAttribute("AlbumResultMsg", AlbumResultMsg);
        req.getRequestDispatcher("").forward(req, resp);
    }
}