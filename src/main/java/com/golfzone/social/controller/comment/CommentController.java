package com.golfzone.social.controller.comment;

import com.golfzone.social.comment.CommentDAO;
import com.golfzone.social.comment.CommentDAOImpl;
import com.golfzone.social.comment.CommentVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String commentResultMsg = "";
        // init get parameter
        String commentContext = req.getParameter("commentContext");
        String commentWriter = req.getParameter("commentWriter");

        // Checking length, input nothing
        if ((commentWriter.length() > 46 || commentWriter.length() < 1)) {
            commentResultMsg = "내용의 길이는 1 ~ 46 자리 이내여야 합니다.";
        } else if (commentContext.equals("") || commentWriter.equals("")) {
            commentResultMsg = "값을 입력해 주세요";
        } else {
            // init VO, DAO`
            CommentDAO commentDAO = new CommentDAOImpl();
            CommentVO commentVO = new CommentVO();
            commentVO.setCommentContext(commentContext);
            commentVO.setCommentWriter(commentWriter);
            commentDAO.insertComment(commentVO);
            System.out.println(commentResultMsg);
        }
        req.setAttribute("commentResultMsg", commentResultMsg);
        req.getRequestDispatcher("/Board.jsp").forward(req, resp);
    }
}