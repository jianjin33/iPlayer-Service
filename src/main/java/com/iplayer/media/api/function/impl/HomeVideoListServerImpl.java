package com.iplayer.media.api.function.impl;

import com.iplayer.media.api.dao.HomeVideoListDao;
import com.iplayer.media.api.entity.VideoListBean;
import com.iplayer.media.api.function.IHomeVideoListServer;
import com.iplayer.media.core.Constants;
import com.iplayer.media.util.ReturnUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public Map getHomeVideoList() {

        try {
            List<VideoListBean> list = homeVideoListDao.getVideoList();
            Map map = new HashMap();
            map.put("list",list);
            return ReturnUtils.returnMess(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReturnUtils.returnMess(Constants.RESULT_CODE_ERROR);
    }
}