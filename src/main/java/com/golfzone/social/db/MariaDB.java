package com.golfzone.social.db;

public interface MariaDB {
    String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    String URL = "jdbc:mariadb://localhost:3306/socialactivity";
    String USER = "root";
    String PASSWORD = "root1234";
    String USER_SELECT_ALL = "select * from user";
    String USER_FIND_BY_USER = "select * from user where user_id = ";
    String INSERT_USER = "insert into user(user_name, user_id, user_pw, user_location, user_age, user_sex, user_tier, user_score) values(?, ?, ?, ?, ?, ?, ?, ?)";
    String CLUB_FIND_BY_CLUB_NAME = "select * from club where club_name = ?";
    String INSERT_CLUB = "insert into club(club_name, club_maxcount, club_age, club_location, club_tier, club_description, club_emblempath, club_sex, club_pw) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

}
