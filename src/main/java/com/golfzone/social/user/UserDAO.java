package com.golfzone.social.user;

import java.util.List;

public interface UserDAO {
    List<UserVO> selectAll();
    int insertUser(UserVO userVO);
    UserVO findByUserNum(int userNum);
    UserVO findByUser(String userId);
}
