package fr.ensim.dp.cache;

import fr.ensim.dp.cache.filter.IFilterCache;

import java.io.*;

public class DiskCache implements ICache{
    private File cacheDir;

    @Override
    public long size() {
        return 0;
    }

    public DiskCache(String mapName) {

    }

    @Override
    public boolean add(String key, byte[] buf) {
        try {
            File cacheFile = new File(cacheDir, key);
            fos.write(buf);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public byte[] retreive(String key) {
        if(key != null ) {
            try {
                FileInputStream fis = new FileInputStream(key);
                byte[] buf = new byte[(int) cacheFile.length()];
                fis.read(buf);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }  else
            return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void setFilterCache(IFilterCache filter) {

    }
    public void createFile(String mapName)
    {
        File f = new File(mapName);
        f.mkdirs();
    }
}
