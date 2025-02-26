package fr.ensim.dp.cache;

import org.jdesktop.swingx.mapviewer.TileCache;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;

public class DiskCacheAdaptor extends TileCache {
    DiskCache diskCache;
    public  DiskCacheAdaptor(DiskCache diskCache) {
        this.diskCache = diskCache;
    }
    @Override
    public BufferedImage get(URI uri) throws IOException {
        byte[] buf= diskCache.retreive(uri.toString());
        return ImageIO.read(new ByteArrayInputStream(buf));
    }

    @Override
    public void put(URI uri, byte[] bimg, BufferedImage img)
    {
        diskCache.add(uri.toString(),bimg);
    }
}
