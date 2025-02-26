package fr.ensim.dp.cache;

import fr.ensim.dp.cache.filter.IFilterCache;

import java.io.*;
import java.util.HashMap;

public class DiskCache implements ICache {
    private File cacheDir;
    private static HashMap<String, DiskCache> mapCache = new HashMap<>();

    private DiskCache(String mapName) {
        cacheDir = new File(mapName);
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
    }

    @Override
    public long size() {
        long totalSize = 0;
        for (File file : cacheDir.listFiles()) {
            totalSize += file.length();
        }
        return totalSize;
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (key == null || buf == null) {
            return false;
        }

        try {
            File cacheFile = new File(cacheDir, key);
            FileOutputStream fos = new FileOutputStream(cacheFile);
            fos.write(buf);
            System.out.println("Adding " + key + " to " + cacheFile);
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public byte[] retreive(String key) {
        if (key != null) {
            File cacheFile = new File(cacheDir, key);

                try (FileInputStream fis = new FileInputStream(cacheFile)) {
                    byte[] buf = new byte[(int) cacheFile.length()];
                    fis.read(buf);
                    return buf;
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        return null;
    }

    @Override
    public void clear() {
        for (File file : cacheDir.listFiles()) {
            file.delete();
        }
    }

    @Override
    public void setFilterCache(IFilterCache filter) {
    }

    public static  DiskCache getInstance(String mapName) {
        mapCache.putIfAbsent(mapName, new DiskCache(mapName));
        return mapCache.get(mapName);
    }

}
