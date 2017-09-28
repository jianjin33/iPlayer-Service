package com.iplayer.media.api.dao;

import com.iplayer.media.api.entity.VideoListBean;
import com.iplayer.media.common.AbstractDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28.
 */
public interface HomeVideoListDao {
    VideoListBean getVideoList();
}
