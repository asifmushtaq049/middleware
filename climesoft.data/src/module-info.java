module climesoft.data {
    requires protobuf.java;
    requires protobuf.java.format;
    requires java.xml;
    requires jackson.all;
    requires java.xml.bind;
    requires jackson.core;
    requires com.fasterxml.jackson.dataformat.smile;
    requires graphql.java;
    requires json.flattener;
    exports climesoft.data.json;
    exports climesoft.data.xml;
    exports climesoft.data.protobuf;
    exports climesoft.data.graphql;
}