package com.iplayer.media.api.function.impl;

import com.iplayer.media.api.dao.HomeVideoListDao;
import com.iplayer.media.api.entity.VideoListBean;
import com.iplayer.media.api.function.IHomeVideoListServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/28.
 */

@Service
public class HomeVideoListServerImpl implements IHomeVideoListServer {

    @Autowired
    HomeVideoListDao homeVideoListDao;

    @Override
    public VideoListBean getHomeVideoList() {

        try {
            return homeVideoListDao.getVideoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}