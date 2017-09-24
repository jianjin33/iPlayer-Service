package com.iplayer.media.api.entity;

/**
 * Created by jianzuming on 17/9/24.
 */
public class UserBean {
    private int id;
    private String user_name;
    private String user_pwd;
    private String user_vip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_vip() {
        return user_vip;
    }

    public void setUser_vip(String user_vip) {
        this.user_vip = user_vip;
    }
}
