module climesoft.data {
    requires protobuf.java;
    requires protobuf.java.format;
    requires java.xml;
    requires jackson.all;
    exports climesoft.data.json;
    exports climesoft.data.xml;
    exports climesoft.data.protobuff;
}