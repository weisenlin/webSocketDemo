package com.socket.bean;

import java.io.Serializable;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/23 0023
 * 用途：
 * 描述:
 */
public class Message implements Serializable {

    private String userId;

    private String message;

    private String friendId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
