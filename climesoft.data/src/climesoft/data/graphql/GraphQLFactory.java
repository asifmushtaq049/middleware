package climesoft.data.graphql;


import climesoft.data.json.JSONObject;
import climesoft.data.xml.XML;
import com.github.wnameless.json.flattener.JsonFlattener;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.*;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;


import java.util.Set;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

public class GraphQLFactory {

    public static String toJson(String value){
        JSONObject json = new JSONObject();
        String[] keyPairs = value.substring(1, value.length()-1).split(",");
        for(String keyPair : keyPairs){
            String[] keyValue = keyPair.split("=");
            json.put(keyValue[0].trim(), keyValue[1].trim());
        }
        return json.toString();
    }

    public static String toXML(String value){
        String json = GraphQLFactory.toJson(value);
        JSONObject obj = new JSONObject(json);
        return XML.toString(obj);
    }

    public static String jsonToGraphQL(String value){
        System.out.println(JsonFlattener.flatten(value));
        JSONObject json = new JSONObject(JsonFlattener.flatten(value));
        Set<String> keys = json.keySet();
        StringBuilder graphBuilder = new StringBuilder("{");
        for(String key : keys){
            graphBuilder.append(key).append("=").append(json.get(key)).append(",");
        }
        graphBuilder.deleteCharAt(graphBuilder.length()-1);
        return graphBuilder.append("}").toString();
    }

    public static String xmlToGraphQL(String value){
        return (jsonToGraphQL(XML.toJSONObject(value).toString()));
    }

    public static String example(){
        String schema = "type Query{hello: String name: String}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("name", new StaticDataFetcher("world")))
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("asif")))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{name, hello}");
        return executionResult.getData().toString();
    }

}
