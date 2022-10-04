package com.golfzone.social.search;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.db.MariaDB;
import com.golfzone.social.db.dbCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchClubDAOImpl implements SearchClubDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public SearchClubDAOImpl() {
        dbCon.DAOImpl();
    }

    @Override
    public List<ClubVO> searchByCondition(SearchClubVO searchClubVO) {
        List<ClubVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            String sql = MariaDB.SEARCH_CLUB_BY_CONDITION;

            if ((!(searchClubVO.getSearchTitle().equals(""))) ||
                    (!(searchClubVO.getSearchMinAge().equals("0"))) ||
                    (!(searchClubVO.getSearchMaxAge().equals("0"))) ||
                    (!(searchClubVO.getSearchMinScore().equals("0"))) ||
                    (!(searchClubVO.getSearchMaxScore().equals("0"))) ||
                    (!(searchClubVO.getSearchLocation().equals("")))) {
                sql += " where";
            }

            if (!(searchClubVO.getSearchTitle().equals(""))) {
                sql += " club_name like '%" + searchClubVO.getSearchTitle() + "%'";
            }
            if ((!(sql.endsWith("where"))) && (!(searchClubVO.getSearchMinAge().equals("0")))) {
                sql += " and club_age >= " + Integer.parseInt(searchClubVO.getSearchMinAge());
            } else if ((sql.endsWith("where")) && !(searchClubVO.getSearchMinAge().equals("0"))) {
                sql += " club_age >= " + Integer.parseInt(searchClubVO.getSearchMinAge());
            }

            if ((!(sql.endsWith("where"))) && (!(searchClubVO.getSearchMaxAge().equals("0")))) {
                sql += " and club_age <= " + Integer.parseInt(searchClubVO.getSearchMaxAge());
            } else if ((sql.endsWith("where")) && (!(searchClubVO.getSearchMaxAge().equals("0")))) {
                sql += " club_age <= " + Integer.parseInt(searchClubVO.getSearchMaxAge());
            }

            if (!(sql.endsWith("where"))) {
                if ((!(searchClubVO.getSearchMinScore().equals("0"))) && (!(searchClubVO.getSearchMaxScore().equals("0")))) {
                    if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 11) {
                        sql += " and club_tier in (" + "'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 10) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " and club_tier in (" + "'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " and club_tier in (" + "'bronze'" + ")";
                        }
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 9) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " and club_tier in (" + "'silver', 'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " and club_tier in (" + "'silver', 'bronze'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                            sql += " and club_tier in (" + "'silver'" + ")";
                        }
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 8) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " and club_tier in (" + "'gold', 'silver', 'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " and club_tier in (" + "'gold', 'silver', 'bronze'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                            sql += " and club_tier in (" + "'gold', 'silver'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 8) {
                            sql += " and club_tier in (" + "'gold'" + ")";
                        }
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 7) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " and club_tier in (" + "'platinum', 'gold', 'silver', 'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " and club_tier in (" + "'platinum', 'gold', 'silver', 'bronze'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                            sql += " and club_tier in (" + "'platinum', 'gold', 'silver'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 8) {
                            sql += " and club_tier in (" + "'platinum', 'gold'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 7) {
                            sql += " and club_tier in (" + "'platinum'" + ")";
                        }
                    }
                } else if ((!(searchClubVO.getSearchMinScore().equals("0"))) && (searchClubVO.getSearchMaxScore().equals("0"))) {
                    if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 7) {
                        sql += " and club_tier in (" + "'platinum', 'gold', 'silver', 'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 8) {
                        sql += " and club_tier in (" + "'gold', 'silver', 'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 9) {
                        sql += " and club_tier in (" + "'silver', 'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 10) {
                        sql += " and club_tier in (" + "'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 11) {
                        sql += " and club_tier in (" + "'unrank'" + ")";
                    }
                } else if ((searchClubVO.getSearchMinScore().equals("0")) && (!(searchClubVO.getSearchMaxScore().equals("0")))) {
                    if (Integer.parseInt(searchClubVO.getSearchMaxScore()) <= 6) {
                        sql += " and club_tier in (" + "'diamond'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 7) {
                        sql += " and club_tier in (" + "'diamond', 'platinum'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 8) {
                        sql += " and club_tier in (" + "'diamond', 'platinum', 'gold'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                        sql += " and club_tier in (" + "'diamond', 'platinum', 'gold', 'silver'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                        sql += " and club_tier in (" + "'diamond', 'platinum', 'gold', 'silver', 'bronze'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                        sql += " and club_tier in (" + "'diamond', 'platinum', 'gold', 'silver', 'bronze', 'unrank'" + ")";
                    }
                }
            } else {
                if ((!(searchClubVO.getSearchMinScore().equals("0"))) && (!(searchClubVO.getSearchMaxScore().equals("0")))) {
                    if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 11) {
                        sql += " club_tier in (" + "'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 10) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " club_tier in (" + "'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " club_tier in (" + "'bronze'" + ")";
                        }
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 9) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " club_tier in (" + "'silver', 'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " club_tier in (" + "'silver', 'bronze'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                            sql += " club_tier in (" + "'silver'" + ")";
                        }
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 8) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " club_tier in (" + "'gold', 'silver', 'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " club_tier in (" + "'gold', 'silver', 'bronze'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                            sql += " club_tier in (" + "'gold', 'silver'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 8) {
                            sql += " club_tier in (" + "'gold'" + ")";
                        }
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 7) {
                        if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                            sql += " club_tier in (" + "'platinum', 'gold', 'silver', 'bronze', 'unrank'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                            sql += " club_tier in (" + "'platinum', 'gold', 'silver', 'bronze'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                            sql += " club_tier in (" + "'platinum', 'gold', 'silver'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 8) {
                            sql += " club_tier in (" + "'platinum', 'gold'" + ")";
                        } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 7) {
                            sql += " club_tier in (" + "'platinum'" + ")";
                        }
                    }
                } else if ((!(searchClubVO.getSearchMinScore().equals("0"))) && (searchClubVO.getSearchMaxScore().equals("0"))) {
                    if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 7) {
                        sql += " club_tier in (" + "'platinum', 'gold', 'silver', 'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 8) {
                        sql += " club_tier in (" + "'gold', 'silver', 'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 9) {
                        sql += " club_tier in (" + "'silver', 'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 10) {
                        sql += " club_tier in (" + "'bronze', 'unrank'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMinScore()) == 11) {
                        sql += " club_tier in (" + "'unrank'" + ")";
                    }
                } else if ((searchClubVO.getSearchMinScore().equals("0")) && (!(searchClubVO.getSearchMaxScore().equals("0")))) {
                    if (Integer.parseInt(searchClubVO.getSearchMaxScore()) <= 6) {
                        sql += " club_tier in (" + "'diamond'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 7) {
                        sql += " club_tier in (" + "'diamond', 'platinum'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 8) {
                        sql += " club_tier in (" + "'diamond', 'platinum', 'gold'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 9) {
                        sql += " club_tier in (" + "'diamond', 'platinum', 'gold', 'silver'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 10) {
                        sql += " club_tier in (" + "'diamond', 'platinum', 'gold', 'silver', 'bronze'" + ")";
                    } else if (Integer.parseInt(searchClubVO.getSearchMaxScore()) == 11) {
                        sql += " club_tier in (" + "'diamond', 'platinum', 'gold', 'silver', 'bronze', 'unrank'" + ")";
                    }
                }
            }

            if ((!(sql.endsWith("where"))) && (!(searchClubVO.getSearchLocation().equals("")))) {
                sql += " and club_location like '%" + searchClubVO.getSearchLocation() + "%'";
            } else if ((sql.endsWith("where")) && (!(searchClubVO.getSearchLocation().equals("")))) {
                sql += " club_location like '%" + searchClubVO.getSearchLocation() + "%'";
            }
            pstmt = conn.prepareStatement(sql);
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
            throw new RuntimeException();
        } finally {
            dbCon.dbConClose(rs, pstmt, conn);
        }
        return vos;
    }
}
