package climesoft.main;

import climesoft.data.json.JSONObject;
import climesoft.data.protobuff.JsonFormat;
import climesoft.data.xml.XML;
import climesoft.net.*;
//import climesoft.net.channel.ChannelPoolPartitioning;
//import climesoft.net.proxy.ProxyServer;
//import climesoft.net.request.body.generator.BodyGenerator;
//import climesoft.net.request.body.multipart.Part;
//import climesoft.net.uri.Uri;
import climesoft.net.ws.WebSocketListener;
import climesoft.net.ws.WebSocketUpgradeHandler;
import climesoft.net.ws.WebSocket;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.resolver.NameResolver;

import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static climesoft.net.Dsl.asyncHttpClient;
import static climesoft.net.Dsl.proxyServer;
import static climesoft.net.Dsl.config;


public class Main {

    public static void main(String[] args){
//        JsonFormat.print();
    }







//    public static void main(String... args){
//        String json_data = "{\"student\":{\"name\":\"Neeraj Mishra\", \"age\":\"22\"}}";
//
//        JSONObject obj = new JSONObject(json_data);
//        String xmlOutput = XML.toString(obj);
//
//        System.out.print(xmlOutput);
//
////        String xmlData = "<data><student><name>Neeraj Mishra</name><age>22</age></student></data>";
////        JSONObject jsonOutput = XML.toJSONObject(xmlData);
////
////
////
////        // Create Server
//        AsyncHttpClient s = asyncHttpClient(config().setProxyServer(proxyServer("127.0.0.1", 38080)));
////
////        Request request = get("http://www.example.com/").build();
////        Future<Response> whenResponse = asyncHttpClient.execute(request);
//
//        AsyncHttpClient c = asyncHttpClient();
////        Request r = new Request() {
////            @Override
////            public String getMethod() {
////                return null;
////            }
////
////            @Override
////            public Uri getUri() {
////                return null;
////            }
////
////            @Override
////            public String getUrl() {
////                return null;
////            }
////
////            @Override
////            public InetAddress getAddress() {
////                return null;
////            }
////
////            @Override
////            public InetAddress getLocalAddress() {
////                return null;
////            }
////
////            @Override
////            public HttpHeaders getHeaders() {
////                return null;
////            }
////
////            @Override
////            public List<Cookie> getCookies() {
////                return null;
////            }
////
////            @Override
////            public byte[] getByteData() {
////                return new byte[0];
////            }
////
////            @Override
////            public List<byte[]> getCompositeByteData() {
////                return null;
////            }
////
////            @Override
////            public String getStringData() {
////                return null;
////            }
////
////            @Override
////            public ByteBuffer getByteBufferData() {
////                return null;
////            }
////
////            @Override
////            public InputStream getStreamData() {
////                return null;
////            }
////
////            @Override
////            public BodyGenerator getBodyGenerator() {
////                return null;
////            }
////
////            @Override
////            public List<Param> getFormParams() {
////                return null;
////            }
////
////            @Override
////            public List<Part> getBodyParts() {
////                return null;
////            }
////
////            @Override
////            public String getVirtualHost() {
////                return null;
////            }
////
////            @Override
////            public List<Param> getQueryParams() {
////                return null;
////            }
////
////            @Override
////            public ProxyServer getProxyServer() {
////                return null;
////            }
////
////            @Override
////            public Realm getRealm() {
////                return null;
////            }
////
////            @Override
////            public File getFile() {
////                return null;
////            }
////
////            @Override
////            public Boolean getFollowRedirect() {
////                return null;
////            }
////
////            @Override
////            public int getRequestTimeout() {
////                return 0;
////            }
////
////            @Override
////            public int getReadTimeout() {
////                return 0;
////            }
////
////            @Override
////            public long getRangeOffset() {
////                return 0;
////            }
////
////            @Override
////            public Charset getCharset() {
////                return null;
////            }
////
////            @Override
////            public ChannelPoolPartitioning getChannelPoolPartitioning() {
////                return null;
////            }
////
////            @Override
////            public NameResolver<InetAddress> getNameResolver() {
////                return null;
////            }
////        }
////        c.prepareRequest(Request)
//        Future<Response> f = c.prepareGet("https://developer.twitter.com/en/docs").execute();
//
//        try {
//            Response r = f.get();
//            System.out.println(f.toString());
//            System.out.println(r.getResponseBody());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
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