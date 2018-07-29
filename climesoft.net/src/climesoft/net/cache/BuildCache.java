package climesoft.net.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class BuildCache {

    private static Cache<String, DataObject> cache = Caffeine.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build();

    public static void putToCache(String key, String value){
        DataObject dataObject = DataObject.get(value);
        cache.put(key, dataObject);

    }
    public static String readFromCache(String key) throws Exception{
        DataObject outData = cache.getIfPresent(key);
        return outData.getData();
    }
}
