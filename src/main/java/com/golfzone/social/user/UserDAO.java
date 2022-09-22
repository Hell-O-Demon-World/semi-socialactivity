package com.golfzone.social.user;

import java.util.List;

public interface UserDAO {
    List<UserVO> selectAll();
    void insertUser(UserVO userVO);
    UserVO findByUser(String userId);
}
