
<!DOCTYPE HTML>
<html>
<head>
    <title>WebSocket</title>
</head>

<body>
Welcome<br/>
<input id="text" type="text" /><button onclick="send()">Send</button>    <button onclick="closeWebSocket()">Close</button>
<div id="message">
</div>
</body>

<script type="text/javascript">

    var websocket = null;
    var id = "";

    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
        websocket = new WebSocket("ws://localhost:8088/webSocket/${id!}");
    }
    else{
        alert('Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function(){
        document.getElementById('message').innerHTML = "error" + '<br/>';
    };

    //连接成功建立的回调方法
    websocket.onopen = function(event){
        document.getElementById('message').innerHTML = "open" + '<br/>';
    }

    //接收到消息的回调方法
    websocket.onmessage = function(event){
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function(){
        document.getElementById('message').innerHTML = "close" + '<br/>';
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.close();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML){
        var obj = eval('(' + innerHTML + ')');
        var message = obj.message;
        id = obj.friendId;
        if(!message){
            message = innerHTML;
        }
        document.getElementById('message').innerHTML = message + '<br/>';
    }

    //关闭连接
    function closeWebSocket(){
        websocket.close();
    }

    //发送消息
    function send(){
        var friendId = '${id!}';
        var message = document.getElementById('text').value;
        if(!id){
            id=1;
        }
        message = message + "," +id+","+friendId;
        websocket.send(message);
    }
</script>
</html>