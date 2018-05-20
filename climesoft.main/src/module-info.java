module climesoft.main {
    requires climesoft.data;
    requires climesoft.net;
    requires protobuf.java;
    requires protobuf.java.format;
    requires jdk.incubator.httpclient;
    requires io.netty.all;
    requires graphql.java;
    requires protobuf.java.util;
    exports climesoft.main;
}