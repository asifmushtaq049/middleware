package climesoft.main;


import climesoft.data.json.JSONObject;
import climesoft.data.xml.XML;
import climesoft.net.AsyncHttpClient;
import climesoft.net.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static climesoft.net.Dsl.asyncHttpClient;

public class Main {

    public static void main(String[] args){
        AsyncHttpClient c = asyncHttpClient();
        Future<Response> f = c.prepareGet("http://localhost/test.php").execute();
        try {
            Response r = f.get();
//            System.out.println(f.toString());
//            System.out.println(r.getResponseBody());
            System.out.println("Get Headers:" + r.getHeaders());
            System.out.println("Remote Address: " + r.getRemoteAddress());
            System.out.println("Local Address: " + r.getLocalAddress());
            System.out.println("Status Code: " + r.getStatusCode());
            System.out.println("Status Text: " + r.getStatusText());
            System.out.println("Content Type: " + r.getContentType());
            System.out.println("--------Origianl---------");
            System.out.println(r.getResponseBody());
            System.out.println("---------XML---------");
            JSONObject obj = new JSONObject(r.getResponseBody());
            String xmlOutput = XML.toString(obj);
            System.out.println(xmlOutput);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }


//    public static void main(String... args){
////        // Create Server
//        AsyncHttpClient s = asyncHttpClient(config().setProxyServer(proxyServer("127.0.0.1", 38080)));
////

////
////
////        // Auto call method....
////        Future<Integer> whenStatusCode = c.prepareGet("http://www.example.com/")
////                .execute(new AsyncHandler<Integer>() {
////                    private Integer status;
////                    @Override
////                    public State onStatusReceived(HttpResponseStatus responseStatus) throws Exception {
////                        status = responseStatus.getStatusCode();
////                        return State.ABORT;
////                    }
////
////                    @Override
////                    public State onHeadersReceived(HttpHeaders headers) throws Exception {
////                        return null;
////                    }
////
////                    @Override
////                    public State onBodyPartReceived(HttpResponseBodyPart bodyPart) throws Exception {
////                        return State.ABORT;
////                    }
////                    @Override
////                    public Integer onCompleted() throws Exception {
////                        return status;
////                    }
////                    @Override
////                    public void onThrowable(Throwable t) {
////                    }
////                });
////
////        try {
////            Integer statusCode = whenStatusCode.get();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        } catch (ExecutionException e) {
////            e.printStackTrace();
////        }
//
////
////        try {
////            WebSocket websocket = c.prepareGet("ws://demos.com/echo")
////                    .execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(
////                            new WebSocketListener() {
////
////                                @Override
////                                public void onOpen(WebSocket websocket) {
////                                    websocket.sendTextFrame("...");
////                                }
////
////                                @Override
////                                public void onClose(WebSocket websocket, int code, String reason) {
////
////                                }
////
////                                @Override
////                                public void onTextFrame(String payload, boolean finalFragment, int rsv) {
////                                    System.out.println(payload);
////                                }
////
////                                @Override
////                                public void onError(Throwable t) {
////                                }
////                            }).build()).get();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        } catch (ExecutionException e) {
////            e.printStackTrace();
////        }
//
//
////        AsyncHttpClient client = new AsyncHttpClient();
////        Response response = client.prepareGet(("http://sonatype.com")
////                .execute().get();
//    }
}