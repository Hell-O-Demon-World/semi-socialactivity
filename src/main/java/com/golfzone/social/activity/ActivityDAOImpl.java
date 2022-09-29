package com.golfzone.social.activity;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAOImpl implements ActivityDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ActivityDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertActivity(ActivityVO activityVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("insertActivity: conn success");
            String sql = MariaDB.INSERT_ACTIVITY;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activityVO.getClubNum());
            pstmt.setString(2, activityVO.getActivityTitle());
            pstmt.setString(3, activityVO.getActivityDescription());
            flag = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        } // end finally
        return flag;
    }

    @Override
    public List<ActivityVO> selectAll() {
        List<ActivityVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

            String sql = MariaDB.ACTIVITY_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ActivityVO vo = new ActivityVO();
                vo.setActivityNum(rs.getInt("ACTIVITY_NUM"));
                vo.setActivityTitle(rs.getString("ACTIVITY_TITLE"));
                vo.setActivityDescription(rs.getString("ACTIVITY_DESCRIPTION"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } // end finally
        return vos;
    }

    @Override
    public ActivityVO findByActivityNum(ActivityVO activityVO) {
        ActivityVO vo = new ActivityVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

            String sql = MariaDB.ACTIVITY_FIND_BY_ACTIVITY_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activityVO.getActivityNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setActivityNum(rs.getInt("ACTIVITY_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setActivityTitle(rs.getString("ACTIVITY_TITLE"));
                vo.setActivityDescription(rs.getString("ACTIVITY_DESCRIPTION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } // end finally
        return vo;
    }

    @Override
    public List<ActivityVO> selectAllByClubNum(ClubVO clubVO) {
        List<ActivityVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("Activity selectAll: conn success");

            String sql = MariaDB.ACTIVITY_FIND_BY_CLUB_NUM;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clubVO.getClubNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ActivityVO vo = new ActivityVO();
                vo.setActivityNum(rs.getInt("ACTIVITY_NUM"));
                vo.setActivityTitle(rs.getString("ACTIVITY_TITLE"));
                vo.setActivityDescription(rs.getString("ACTIVITY_DESCRIPTION"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } // end finally
        return vos;
    }
}
