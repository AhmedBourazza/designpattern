package fr.ensim.dp.cache;

import fr.ensim.dp.cache.filter.IFilterCache;
import java.util.HashMap;

public class MemoryCache implements ICache {
    private final HashMap<String, byte[]> data;
    private long size;

    private static final MemoryCache mem = new MemoryCache();

    private MemoryCache() {
        data = new HashMap<>();
        size = 0;
    }

    public static MemoryCache getInstance() {
        return mem;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (key == null || buf == null) {
            return false;
        }
        if (data.containsKey(key)) {

            return false;
        }
        else {
            data.put(key, buf);
            size += buf.length;
            return true;
        }

    }

    @Override
    public byte[] retreive(String key) {
        if(key != null ) {
            return data.get(key);
        }  else
            return null;
    }

    @Override
    public void clear() {
        data.clear();
        size = 0;
    }

    @Override
    public void setFilterCache(IFilterCache filter) {
    }
}
