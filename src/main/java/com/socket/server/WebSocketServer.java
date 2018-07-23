package com.socket.server;

import com.socket.bean.Message;
import com.socket.util.JsonUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/23 0023
 * 用途：
 * 描述:
 */
@Component
@ServerEndpoint("/webSocket/{id}")
public class WebSocketServer {

    //当前用户数量
    private static int onlineCount = 0;

    //当前连接集合
    private static ConcurrentHashMap<String, WebSocketServer> webSocket = new ConcurrentHashMap<>();

    //与某个客户端的连接会话
    private Session session;

    private static Logger log = org.apache.logging.log4j.LogManager.getLogger(WebSocketServer.class);

    private String id = "";

    private Message messageBean = new Message();


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session) {
        this.session = session;
        this.id = id;//发送消息者
        webSocket.put(id, this);//存储当前连接
        addOnlineCount();//在线人数加1
        log.info("用户" + id + "加入！当前在线人数为" + getOnlineCount());
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message,Session session){
        log.info("来自客户端的消息:" + message);
        //可以自己约定字符串内容，比如 内容|0 表示信息群发，内容|X 表示信息发给id为X的用户
        String sendMessage = message.split(",")[0];
        String sendUserId = message.split(",")[1];
        String friendId = message.split(",")[2];
        try {
            if(sendUserId.equals("0"))
                sendToAll(sendMessage);
            else
                sendMessageToUser(sendUserId,sendMessage,friendId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @OnClose
    public void onClose() {
        webSocket.remove(this);
        subOnleneCount();
    }


    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }


    public void sendMessageToUser(String userId, String message,String friendId) throws IOException {
        if (webSocket.get(userId) != null) {
            //用户在线
            messageBean.setUserId(userId);
            messageBean.setMessage(message);
            messageBean.setFriendId(friendId);
            if (id.equals(userId)) {
                webSocket.get(userId).sendMessage(JsonUtil.toJson(messageBean));
            } else {

                webSocket.get(userId).sendMessage(JsonUtil.toJson(messageBean));
            }
        } else {
//            发送消息给自己
            sendMessageToUser(id, "当前用户不在线",id);
        }
    }


    public void sendToAll(String message) throws IOException {
        for (String key : webSocket.keySet()) {
            webSocket.get(key).sendMessage(message);
        }
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        onlineCount++;
    }

    private static synchronized void subOnleneCount() {
        onlineCount--;
    }
}
