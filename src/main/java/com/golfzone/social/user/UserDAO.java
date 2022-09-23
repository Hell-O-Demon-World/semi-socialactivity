package com.golfzone.social.user;

import java.util.List;

public interface UserDAO {
    List<UserVO> selectAll();
    int insertUser(UserVO userVO);
    UserVO findByUser(String userId);
}
