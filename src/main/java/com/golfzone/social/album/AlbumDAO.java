package com.golfzone.social.album;

import java.util.List;

public interface AlbumDAO {
    List<AlbumVO> selectAll();

    int insertAlbum(AlbumVO albumVO);
}
