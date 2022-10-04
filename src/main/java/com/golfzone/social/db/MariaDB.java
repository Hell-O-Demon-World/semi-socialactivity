package com.golfzone.social.db;

public interface MariaDB {
    String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    String URL = "jdbc:mariadb://localhost:3306/socialactivity";
    String USER = "root";
    String PASSWORD = "root1234";

    /* SELECT ALL */
    String ALBUM_SELECT_ALL = "select * from album";
    String ACTIVITY_SELECT_ALL = "select * from activity";
    String ACTIVITY_MEMBER_SELECT_ALL = "select * from activity_member";
    String CLUB_SELECT_ALL = "select * from club";
    String CLUB_MEMBER_SELECT_ALL = "select * from club_member";
    String USER_SELECT_ALL = "select * from user";
    String CLUB_SELECT_ALL_DESC = "select * from club order by club_num desc";
    /* DELETE */
    String DELETE_USER_FROM_ACTIVITY_MEMBER = "delete from activity_member where activity_member_num = ?";
    String DELETE_USER_FROM_USER = "delete from user where user_num = ?";
    String DELETE_BOARD = "delete from board where board_num = ?";
    String DELETE_COMMENT = "delete from comment where comment_num = ?";

    /* INSERT */
    String INSERT_ACTIVITY = "insert into activity(club_num, activity_title, activity_description) values(?, ?, ?)";
    String INSERT_ACTIVITY_MEMBER = "insert into activity_member(activity_num, club_num, user_num) values(?, ?, ?)";
    String INSERT_ALBUM = "insert into album(image_name, image_path) values(?, ?)";
    String INSERT_BOARD = "insert into board(club_num, board_title, board_content, board_writer) values(?, ?, ?, ?)";
    String INSERT_COMMENT = "insert into comment(board_num, club_num, comment_content, comment_writer) values(?, ?, ?, ?)";
    String INSERT_CLUB = "insert into club(club_name, club_maxcount, club_age, club_location, club_tier, club_description, club_emblempath, club_sex, club_pw) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String INSERT_CLUB_MEMBER = "insert into club_member(role_num, club_num, user_num) values(?, ?, ?)";
    String INSERT_USER = "insert into user(user_name, user_id, user_pw, user_location, user_age, user_sex, user_tier, user_score) values(?, ?, ?, ?, ?, ?, ?, ?)";

    /* FIND BY */
    String CLUB_FIND_BY_CLUB_NAME = "select * from club where club_name = ?";
    String CLUB_FIND_BY_CLUB_PASSWORD = "select * from club where club_name = ?, club_pw = ?";
    String CLUB_MEMBER_FIND_BY_USER_NUM_CLUB_NUM = "select * from club_member where user_num = ? and club_num = ?";
    String USER_FIND_BY_USER = "select * from user where user_id = ?";
    String USER_FIND_BY_USER_NUM = "select * from user where user_num = ?";
    String USER_FIND_BY_ACTIVITY_MEMBER = "select * from activity_member where user_num = ? and activity_num = ?";
    String ACTIVITY_MEMBER_FIND_BY_ACTIVITY_NUM_USER_NUM = "select * from activity_member where activity_num = ? and user_num = ?";
    String CLUB_MEMBER_FIND_BY_USER_NUM = "select * from club_member where user_num = ?";
    String CLUB_FIND_BY_CLUB_NUM = "select * from club where club_num = ?";
    String ACTIVITY_FIND_BY_ACTIVITY_NUM = "select * from activity where activity_num = ?";
    String ACTIVITY_MEMBER_FIND_BY_USER_NUM = "select * from activity_member where user_num = ?";
    String ACTIVITY_MEMBER_FIND_BY_CLUB_NUM = "select * from activity_member where club_num = ?";
    String ACTIVITY_FIND_BY_CLUB_NUM = "select * from activity where club_num = ?";
    String BOARD_FIND_BY_CLUB_NUM = "select * from board where club_num = ?";
    String BOARD_FIND_BY_BOARD_NUM = "select * from board where board_num = ?";
    String COMMENT_FIND_BY_BOARD_NUM = "select * from comment where board_num = ?";

    /* COUNT */
    String COUNT_CLUB_MEMBER = "select count(*) as count from club_member where club_num = ?";
    String COUNT_ACTIVITY_MEMBER = "select count(*) as count from activity_member where activity_num = ?";

    /* SEARCH */
    String SEARCH_CLUB_BY_CONDITION = "select * from club";

}
