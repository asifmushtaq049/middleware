package climesoft.main;


import climesoft.data.json.JSONObject;
import climesoft.data.xml.XML;
import climesoft.net.AsyncHttpClient;
import climesoft.net.Request;
import climesoft.net.Response;
import climesoft.net.cache.BuildCache;
import climesoft.net.ws.WebSocket;
import climesoft.net.ws.WebSocketListener;
import climesoft.net.ws.WebSocketUpgradeHandler;

import java.security.Key;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static climesoft.net.Dsl.asyncHttpClient;
import static climesoft.net.Dsl.trace;

public class Main {



    public static void main(String[] args) {
        BuildCache.putToCache("data", "Arsalan");
        try {
            for (int i = 0; i <= 10000000; i++) {
                System.out.println(BuildCache.readFromCache("data"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        try {
//            ProtoBuffUtil.jsonToProto("{\"name\": \"Asif\",\"id\": 2}");
//            ProtoBuffUtil.test();
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//        }


//        AsyncHttpClient c = asyncHttpClient();
//        c.prepareGet("127.0.0.1").execute();
//        try {
//            WebSocket websocket = c.prepareGet("ws://localhost/test.php")
//                    .execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(
//                            new WebSocketListener() {
//
//                                @Override
//                                public void onOpen(WebSocket websocket) {
//                                    websocket.sendTextFrame("...");
//                                    System.out.println("Open");
//                                }
//
//                                @Override
//                                public void onClose(WebSocket websocket, int code, String reason) {
//                                    System.out.println("Close");
//                                }
//
//                                @Override
//                                public void onTextFrame(String payload, boolean finalFragment, int rsv) {
//                                    System.out.println(payload);
//                                    System.out.println("onTextFrame");
//                                }
//
//                                @Override
//                                public void onError(Throwable t) {
//                                }
//                            }).build()).get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//    }

//    Future<Integer> whenStatusCode = asyncHttpClient.prepareGet("http://www.example.com/")
//            .execute(new AsyncHandler<Integer>() {
//                private Integer status;
//                @Override
//                public State onStatusReceived(HttpResponseStatus responseStatus) throws Exception {
//                    status = responseStatus.getStatusCode();
//                    return State.ABORT;
//                }
//                @Override
//                public State onHeadersReceived(HttpHeaders headers) throws Exception {
//                    return State.ABORT;
//                }
//                @Override
//                public State onBodyPartReceived(HttpResponseBodyPart bodyPart) throws Exception {
//                    return State.ABORT;
//                }
//                @Override
//                public Integer onCompleted() throws Exception {
//                    return status;
//                }
//                @Override
//                public void onThrowable(Throwable t) {
//                }
//            });
//
//    Integer statusCode = whenStatusCode.get();

    }
}