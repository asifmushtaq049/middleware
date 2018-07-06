module climesoft.net {
    requires java.activation;
    requires io.netty.all;
    requires slf4j.api;
    requires java.xml;
    requires java.security.jgss;
    requires org.reactivestreams;
    requires netty.reactive.streams;
    requires com.github.benmanes.caffeine;
    exports climesoft.net;
    exports climesoft.net.ws;
    exports climesoft.net.cache;
}