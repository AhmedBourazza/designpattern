package fr.ensim.dp.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheFactoryTest {

    @Test
    void getMemoryCache() {
        CacheFactory cacheFactory = new CacheFactory();
        MemoryCache memoryCache = (MemoryCache) cacheFactory.getMemoryCache();
        assertNotNull(memoryCache);
    }

    @Test
    void getDiskCache() {
        CacheFactory cacheFactory = new CacheFactory();
        DiskCache diskCache = (DiskCache) cacheFactory.getDiskCache("AhmedMap");
        assertNotNull(diskCache);
    }
}