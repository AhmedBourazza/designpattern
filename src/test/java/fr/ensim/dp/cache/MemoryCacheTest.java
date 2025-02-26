package fr.ensim.dp.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryCacheTest {

    @Test
    void getInstance() {
        assertNotNull(MemoryCache.getInstance());

    }

    @Test
    void size() {
        assertEquals(0, MemoryCache.getInstance().size());
    }
    @Test
    void add() {
        byte[] b = new byte[]{};
        assertTrue(MemoryCache.getInstance().add("Ilyas",b));
        assertFalse(MemoryCache.getInstance().add("Ilyas",b));

    }


    @Test
    void retreive() {
        byte[] b = new byte[]{};
        MemoryCache.getInstance().add("Ahmed",b);
        assertEquals(b,MemoryCache.getInstance().retreive("Ahmed"));


    }

    @Test
    void clear() {
        byte[] b = new byte[]{};
        MemoryCache.getInstance().add("John", b);
        MemoryCache.getInstance().clear();
        assertEquals(0, MemoryCache.getInstance().size());
    }
}