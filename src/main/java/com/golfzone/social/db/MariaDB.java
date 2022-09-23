package com.golfzone.social.db;

public interface MariaDB {
    String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    String URL = "jdbc:mariadb://localhost:3306/socialactivity";
    String USER = "root";
    String PASSWORD = "root1234";
    String USER_SELECT_ALL = "select * from user";
    String USER_FIND_BY_USER = "select * from user where user_id = ";
    String USER_INSERT = "insert into user(user_name, user_id, user_pw, user_location, user_age, user_sex, user_tier, user_score) values";
    String INSERT_USER = "insert into user(user_name, user_id, user_pw, user_location, user_age, user_sex, user_tier, user_score) values(?, ?, ?, ?, ?, ?, ?, ?)";
}
