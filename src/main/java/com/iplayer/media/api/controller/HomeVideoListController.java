package com.iplayer.media.api.controller;

import com.iplayer.media.api.entity.VideoListBean;
import com.iplayer.media.api.function.IHomeVideoListServer;
import com.iplayer.media.util.ReturnUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/28.
 */


@Controller
@RequestMapping(value = "home")
public class HomeVideoListController {

    @Autowired
    IHomeVideoListServer homeVideoListServer;

    @ResponseBody
    @RequestMapping(value = "videoList")
    public Map getHomeVideoList(HttpServletRequest httpServletRequest) {
        return homeVideoListServer.getHomeVideoList();
    }


}
