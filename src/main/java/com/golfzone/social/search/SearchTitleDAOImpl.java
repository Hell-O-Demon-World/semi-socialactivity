package com.golfzone.social.search;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchTitleDAOImpl implements SearchTitleDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public SearchTitleDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);
//			jdbcConnectionTest();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClubVO> searchByClubTitle(SearchTitleVO searchTitleVO) {
        SearchTitleVO vo = new SearchTitleVO();
        List<ClubVO> vos = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("searchByClubTitle: 연결됐다 ㅅㅂ");

            String sql = MariaDB.SEARCH_BY_CLUB_TITLE;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + searchTitleVO.getSearchTitle() + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ClubVO vo2 = new ClubVO();
                vo2.setClubName(rs.getString("CLUB_NAME"));
                vo2.setClubMaxCount(rs.getInt("CLUB_MAXCOUNT"));
                vo2.setClubAge(rs.getInt("CLUB_AGE"));
                vo2.setClubLocation(rs.getString("CLUB_LOCATION"));
                vo2.setClubTier(rs.getString("CLUB_TIER"));
                vo2.setClubDescription(rs.getString("CLUB_DESCRIPTION"));
                vo2.setClubEmblemPath(rs.getString("CLUB_EMBLEMPATH"));
                vo2.setClubSex(rs.getInt("CLUB_SEX"));
                vo2.setClubPw(rs.getString("CLUB_PW"));
                vos.add(vo2);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vos;
    }
}
