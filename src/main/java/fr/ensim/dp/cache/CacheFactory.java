package fr.ensim.dp.cache;

public class CacheFactory {

    public ICache getMemoryCache()
    {
        return MemoryCache.getInstance();
    }
    public ICache getDiskCache(String mapName)
    {
        return DiskCache.getInstance(mapName);
    }
}
