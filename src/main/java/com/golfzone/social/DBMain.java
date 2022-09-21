package com.golfzone.social;

import com.golfzone.social.user.UserDAO;
import com.golfzone.social.user.UserDAOImpl;

public class DBMain {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
    }
}
