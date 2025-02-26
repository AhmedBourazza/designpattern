package fr.ensim.dp.cache;

import org.jdesktop.swingx.mapviewer.TileCache;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;

public class MemoryCacheAdaptor extends TileCache {
    MemoryCache memoryCache;

    public MemoryCacheAdaptor(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
    }

    @Override
    public BufferedImage get(URI uri) throws IOException {

        byte[] buf = memoryCache.retreive(uri.toString());
        if(buf == null) {
            return null;
        }
        return ImageIO.read(new ByteArrayInputStream(buf));
    }

    @Override
    public void put(URI uri, byte[] bimg, BufferedImage img) {
        memoryCache.add(uri.toString(), bimg);
    }

}
