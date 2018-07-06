package climesoft.main;

import climesoft.data.protobuf.JsonFormat;
import climesoft.data.protobuf.XmlFormat;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

public class ProtoBuffUtil {
    public static void test(){
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder().setName("Asif").setId(2).build();
        JsonFormat jsonFormat = new JsonFormat();
        String asJson = jsonFormat.printToString(person);

        System.out.println(asJson);

        XmlFormat xmlFormat = new XmlFormat();
        String asXml = xmlFormat.printToString(person);

        System.out.println(asXml);
    }
    public static void jsonToProto(String asJson) throws InvalidProtocolBufferException {
        Message.Builder builder  = PersonOuterClass.Person.newBuilder();
        com.google.protobuf.util.JsonFormat.parser().merge(asJson, builder);
        Message person = builder.build();
        System.out.println(person.toString());
    }
}
