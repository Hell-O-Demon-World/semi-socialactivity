package com.golfzone.social.controller.comment;

import com.golfzone.social.comment.CommentDAO;
import com.golfzone.social.comment.CommentDAOImpl;
import com.golfzone.social.comment.CommentVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String commentResultMsg = "댓글 삭제 실패";
        // init get parameter
        String commentNum = req.getParameter("commentNum");

        CommentVO commentVO = new CommentVO();
        CommentDAO commentDAO = new CommentDAOImpl();
        commentVO.setCommentNum(Integer.parseInt(commentNum));

        int flag = commentDAO.deleteComment(commentVO);
        if (flag == 1) {
            commentResultMsg = "댓글삭제완료..";
        }
        System.out.println(commentResultMsg);
        req.setAttribute("commentResultMsg: ", commentResultMsg);
        req.getRequestDispatcher("/").forward(req, resp);

    }
}
