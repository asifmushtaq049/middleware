package climesoft.main;


import climesoft.data.json.JSONObject;
import climesoft.data.xml.XML;
import climesoft.net.AsyncHttpClient;
import climesoft.net.Response;
import climesoft.net.ws.WebSocket;
import climesoft.net.ws.WebSocketListener;
import climesoft.net.ws.WebSocketUpgradeHandler;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static climesoft.net.Dsl.asyncHttpClient;

public class Main {

    public static void main(String[] args){
        try {
            ProtoBuffUtil.jsonToProto("{\"name\": \"Asif\",\"id\": 2}");
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
//        AsyncHttpClient c = asyncHttpClient();
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

    }
}