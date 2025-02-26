package fr.ensim.dp.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskCacheTest {

    private String tileId = "tile";
    private byte[] tileData = new byte[]{0, 1, 2};

    @Test
    void size() {
        DiskCache.getInstance("Mapnik").add(tileId, tileData);
        assertTrue(DiskCache.getInstance("Mapnik").size() > 0);
    }

    @Test
    void add() {
        boolean added = DiskCache.getInstance("Mapnik").add(tileId, tileData);
        assertTrue(added, "ajoutée avec succès");

    }

    @Test
    void retreive() {
        DiskCache.getInstance("Mapnik").add(tileId, tileData);

        byte[] retrievedData = DiskCache.getInstance("Mapnik").retreive(tileId);
        assertNotNull(retrievedData, "Les données récupérées ne doivent pas être nulles");
        assertArrayEquals(tileData, retrievedData, "Les données récupérées doivent correspondre à celles ajoutées");
    }

    @Test
    void clear() {
        DiskCache.getInstance("Mapnik").add(tileId, tileData);
        assertTrue(DiskCache.getInstance("Mapnik").size() > 0, "La taille du cache doit être supérieure à 0 après ajout");
        DiskCache.getInstance("Mapnik").clear();
        assertEquals(0, DiskCache.getInstance("Mapnik").size(), "La taille du cache doit être égale à 0 après effacement");
    }

    @Test
    void getInstance() {
       assertNotNull(DiskCache.getInstance("Mapnik"));
       assertNotNull(DiskCache.getInstance("OSM France"));

    }


}
