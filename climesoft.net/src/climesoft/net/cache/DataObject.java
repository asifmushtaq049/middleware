package climesoft.net.cache;

public class DataObject {

    private String data;


    public DataObject(String data){
        this.data = data;
    }

    public static DataObject get(String data) {
        return new DataObject(data);
    }

    public String getData(){
        return this.data;
    }

}
