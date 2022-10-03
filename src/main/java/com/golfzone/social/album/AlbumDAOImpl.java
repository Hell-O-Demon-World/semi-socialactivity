package com.golfzone.social.album;

import com.golfzone.social.db.MariaDB;
import com.golfzone.social.db.dbCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAOImpl implements AlbumDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public AlbumDAOImpl() {
        dbCon.DAOImpl();
    }

    @Override
    public List<AlbumVO> selectAll() {

        List<AlbumVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.ALBUM_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                AlbumVO vo = new AlbumVO();
                vo.setAlbumNum(rs.getInt("ALBUM_NUM"));
                vo.setImageName(rs.getString("IMAGE_NAME"));
                vo.setImagePath(rs.getString("IMAGE_PATH"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        } 
        return vos;
    }

    @Override
    public int insertAlbum(AlbumVO albumVO) {
        int flag;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.INSERT_ALBUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, albumVO.getImageName());
            pstmt.setString(2, albumVO.getImagePath());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        } 
        return flag;
    }
}
