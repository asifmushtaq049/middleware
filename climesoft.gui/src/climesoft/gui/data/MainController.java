package climesoft.gui.data;

import climesoft.data.graphql.GraphQLFactory;
import climesoft.data.json.JSONException;
import climesoft.data.json.JSONObject;
import climesoft.data.xml.XML;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import climesoft.net.AsyncHttpClient;
import climesoft.net.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static climesoft.net.Dsl.asyncHttpClient;

public class MainController {
    @FXML
    private ToggleGroup conversionType;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextField inputLink;

    public MainController(){

    }
    public void initialize(){
        conversionType.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> ov, Toggle old_toggle,
                 Toggle new_toggle) -> {
                    if (conversionType.getSelectedToggle() != null) {
                        RadioButton rb = (RadioButton) conversionType.getSelectedToggle();
                        switch(rb.getId()){
                            case CONVERSION.JSON_TO_XML:
                                jsonToXML();
                                break;
                            case CONVERSION.JSON_TO_Graph:
                                jsonToGraph();
                                break;
                            case CONVERSION.XML_TO_Graph:
                                xmlToGraph();
                                break;
                            case CONVERSION.XML_TO_JSON:
                                xmlToJson();
                                break;
                            case CONVERSION.Graph_TO_JSON:
                                graphToJson();
                                break;
                            case CONVERSION.Graph_TO_XML:
                                graphToXML();
                                break;
                        }
                    }
                });
    }

    private void graphToXML() {
        if(!inputIsEmpty()){
            outputTextArea.setText(GraphQLFactory.toXML(inputTextArea.getText()));
        }
    }

    private void graphToJson() {
        if(!inputIsEmpty()){
            String json = GraphQLFactory.toJson(inputTextArea.getText());
            outputTextArea.setText(json);
        }
    }

    private void xmlToJson() {
        if(!inputIsEmpty()){
            JSONObject jsonOutput = XML.toJSONObject(inputTextArea.getText());
            outputTextArea.setText(jsonOutput.toString());
        }
    }

    private void xmlToGraph() {
        if(!inputIsEmpty()){
            outputTextArea.setText(GraphQLFactory.xmlToGraphQL(inputTextArea.getText()));
        }
    }

    private void jsonToGraph() {
        if(!inputIsEmpty()){
            outputTextArea.setText(GraphQLFactory.jsonToGraphQL(inputTextArea.getText()));
        }
    }

    private void jsonToXML() {
        if(!inputIsEmpty()){
            try{
                JSONObject obj = new JSONObject(inputTextArea.getText());
                String xmlOutput = XML.toString(obj);
                outputTextArea.setText(xmlOutput);
            }catch(JSONException e){
                outputTextArea.setText("Error: " + e.getMessage());
            }
        }
    }

    private boolean inputIsEmpty(){
        return inputTextArea.getText().isEmpty();
    }

    public void getData(ActionEvent actionEvent) {
        if(!inputLink.getText().isEmpty()){
            AsyncHttpClient c = asyncHttpClient();
            Future<Response> f = c.prepareGet(inputLink.getText().trim()).execute();
            try {
                Response r = f.get();
                inputTextArea.setText(r.getResponseBody());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    class CONVERSION{
        static final String JSON_TO_XML = "jsonToXML";
        static final String JSON_TO_Graph = "jsonToGraph";
        static final String XML_TO_JSON = "xmlToJson";
        static final String XML_TO_Graph = "xmlToGraph";
        static final String Graph_TO_JSON = "graphToJson";
        static final String Graph_TO_XML = "graphToXML";
    }

}
